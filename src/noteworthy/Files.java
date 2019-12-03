/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noteworthy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfugue.pattern.*;
import org.jfugue.midi.*;

/**
 *
 * @author mayra
 */
public class Files {
    
    private static final int NOT_FOUND = -1;                                    //constantes para o comando de sobreescrever arquivos
    private static final int NO = 1;
           
    
    public String read() throws IOException{
        
        File file = selectFile(true);

        if(file != null){
            StringBuilder stringBuilder = new StringBuilder();                  //para construir string final
            BufferedReader reader = new BufferedReader(new FileReader(file));   //seleciona arquivo para ser lido
            String paragraph;                                                

            while((paragraph = reader.readLine()) != null)                      //lê parágrafos inteiros (até seus \n) até acabar arquivo
                stringBuilder.append(paragraph).append("\n");                   //separa parágrafos novamente para saída

            reader.close();
            return stringBuilder.toString();                                    //retorna única String do arquivo .txt carregado
        }
        
        return null;
    }
    
    public void write(String text) throws FileNotFoundException{

        File file = makeFile(".txt");                                           
        PrintWriter out;                                                        
        out = new PrintWriter(file.getPath());
        out.println(text);
        out.close();  
    }
    
    public void write(Pattern pattern) throws IOException{
        
        File file = makeFile(".midi");                                          
        MidiFileManager.savePatternToMidi(pattern, file);
    }
    
    private File selectFile(boolean fileOnly){
        
        JFileChooser jfc  = new JFileChooser(System.getProperty("user.dir"));
        jfc.setDialogTitle("Select file");
        
        if(fileOnly){                                                           //se for pra selecionar um arquivo específico
                                                                                
            jfc.setAcceptAllFileFilterUsed(false);                              //apenas arquivos .txt
            jfc.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
        }                                                                       //se for pra selecionar um caminho
        else jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);           //selecionar pasta de destino

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)            //operação não cancelada
            return jfc.getSelectedFile();
        
        return null;
    }
    
    private String buildPath(File directory, String fileName, String fileType){
        
        if (fileName == null)
            fileName = "untitled" + fileType;
        
        if (fileName.lastIndexOf('.') == NOT_FOUND) 
            fileName = fileName.concat(fileType);                               //checa extensão no nome salvo (da pra fazer melhor mas preguiça)

        return directory.getPath() + "\\" + fileName;                           //constroi caminho para novo arquivo
    }
        
    private File makeFile(String fileType){
        
        int overwrite;                                                          //flag para repetir operação de nomeção do arquivo
        File directory = selectFile(false);                                     //seleciona o diretório onde quer escrever o novo arquivo
        File file = null;
        
        do{
            overwrite = NOT_FOUND;
            String fileName = JOptionPane.showInputDialog(null,"Save file as:", "untitled" + fileType);
            file = new File(buildPath(directory, fileName, fileType));

            if(file.exists() && !file.isDirectory())                            //testa se usuário quer sobreescrever arquivo com o mesmo nome
                overwrite = JOptionPane.showConfirmDialog(null, "This file already exists. Do you wish to overwrite it?", "Found file",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        } while(overwrite == NO);                                               //se foi encontrada outro arquivo de mesmo nome e o usuário não quer sobreescrever, repete operação pra salvar com outro nome
        
        return file;
    }
    
}