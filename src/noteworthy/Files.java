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

/**
 *
 * @author mayra
 */
public class Files {
    
    private static final int NOT_FOUND = -1;
    private static final int NO = 1;
    private static final int CANCEL = 2;
    
    public Files(){
    }
    
    public File selectFile(boolean txt_only){
        
        JFileChooser jfc  = new JFileChooser(System.getProperty("user.dir"));
        jfc.setDialogTitle("Select file");
        
        if(txt_only){
            jfc.setAcceptAllFileFilterUsed(false); //apenas arquivos .txt
            jfc.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
        }
        else jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //selecionar pasta de destino

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) //operação não cancelada
            return jfc.getSelectedFile();
        
        return null;
    }
    
    public String read(File file) throws IOException{

        BufferedReader reader = null; //precisa
        StringBuilder stringBuilder = new StringBuilder(); //para construir string final

        reader = new BufferedReader(new FileReader(file)); //seleciona arquivo para ser lido
        String paragraph = null; //inicializa string do buffer

        while((paragraph = reader.readLine()) != null) //lê parágrafos inteiros (até seus \n) até acabar arquivo
            stringBuilder.append(paragraph).append("\n"); //separa parágrafos novamente para saída

        reader.close();
        return stringBuilder.toString(); //caixa de texto com material do arquivo .txt carregado
    }
        
    public void write(File directory, String text, String extension){
        
        String fileName = JOptionPane.showInputDialog(null,"Save file as:", "untitled" + extension);

        if (fileName != null){ //operação nao cancelada
        
            try {

                if (fileName.lastIndexOf('.') == NOT_FOUND) 
                    fileName = fileName.concat(extension); //checa extensão no nome salvo

                String path = directory.getPath() + "\\" + fileName; //constroi caminho para novo arquivo 
                File newFile = new File(path);

                if(newFile.exists() && !newFile.isDirectory()){ //testa se usuário quer sobreescrever arquivo com o mesmo nome
                    int overwrite = JOptionPane.showConfirmDialog(null, "This file already exists. Do you wish to overwrite it?", "Found file",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(overwrite == NO) {
                        write(directory, text, extension); return;
                    } //se não, repete operação pro usuário salvar com outro nome
                    if(overwrite == CANCEL) return; //existe a opção de cancelar, o "cancelar" e o "nao" precisam retornar se/depoisdo recursivo. o que segue é o "sim" e o que nao entrou nessa clausula
                }
                
                if(".txt".equals(extension)){
                    PrintWriter out; //se usuário resolveu sobreescrever
                    out = new PrintWriter(path);
                    out.println(text);
                    out.close();  
                }
                if (".midi".equals(extension)){
                        /* essa eh o método pra salvar pattern em arquivo MIDI mas aparentemente ele nao existe mais
                    Player player = new Player();
                    Pattern pattern = new Pattern(text); 
                    try {
                        MidiFileManager.savePatternToMidi(pattern, new File("JFugue4.mid"));
                    } catch (IOException e)
                    {
                    // handle IO Exception
                    }*/
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NoteWorthy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}