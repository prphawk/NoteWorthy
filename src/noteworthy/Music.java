/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noteworthy;

import org.jfugue.pattern.*;
import java.util.Random;

/**
 *
 * @author mayra
 */

public class Music {
    
    public static class Note{

        public static final String DO = "C";                                    //puramente pela minha vontade de des-gringar essas notas
        public static final String RE = "D";
        public static final String MI = "E";
        public static final String FA = "F";
        public static final String SOL = "G";
        public static final String LA = "A";
        public static final String SI = "B";
        public static final String PAUSE = "R ";                                //pausa não tem oitava colada, tem espaço no final para separar
    }

    private static final int OCTAVE_DEFAULT = 5;                                //5ª oitava
    private static final int INSTRUMENT_DEFAULT = 0;                            //piano
    private static final int BPM_DEFAULT = 120;                                 //agraggio
    
    private int octave;                                                         //valores numéricos para operações
    private int instrument;
    private int bpm;
    
    private String text;
    private String noteString;                                                  //ultima nota tocada    
  
    
    public Music(String aText){
        
        text = aText;                                                           //texto a ser formatado de acordo com os comandos do jfugue 
        octave = OCTAVE_DEFAULT;                                                //5
        instrument = INSTRUMENT_DEFAULT;                                        //0
        bpm = BPM_DEFAULT;                                                      //120
        noteString = Note.PAUSE;                                                //caso a operação seja repetir ultima nota sem nenhuma nota ter sido tocada, emite pausa -> "R "
    }
    
    public Pattern build(){                                                     //constroi uma string personalizada de acordo com os comandos do jfugue
       
        StringBuilder musicString = new StringBuilder();                        //para construir a pattern final a partir de uma string formada com StringBuilder
        
        for (int i = 0; i < text.length(); i++) {                               //cada char do texto
            
            char ch = text.charAt(i);
            
            switch(ch){
                
                case 'a': musicString.append(setNoteTo(Note.LA)); break;
                case 'b': musicString.append(setNoteTo(Note.SI)); break;
                case 'c': musicString.append(setNoteTo(Note.DO)); break;
                case 'd': musicString.append(setNoteTo(Note.RE)); break;
                case 'e': musicString.append(setNoteTo(Note.MI)); break;
                case 'f': musicString.append(setNoteTo(Note.FA)); break;
                case 'g': musicString.append(setNoteTo(Note.SOL)); break;
                case ' ': 
                case 'i':
                case 'o':
                case 'u': musicString.append(noteString); break;                //printa na string final a ultima nota tocada
                case ';': musicString.append(Note.PAUSE); break;
                
                case '.':
                case '?': octave = OCTAVE_DEFAULT; break;                       //volta a oitava e volume (n implementado) default
                
                case '+':
                case '-': /*volume aqui*/ break;
                
                case 'T':
                    if(text.charAt(i+1) == '+') musicString.append(setBPMTo(bpm+50));
                    if(text.charAt(i+1) == '-') musicString.append(setBPMTo(bpm-50));
                    i++; break;
                
                case 'O': 
                    if(text.charAt(i+1) == '+' && octave < 9) octave++;         //de 0 a 9
                    if(text.charAt(i+1) == '-' && octave > 0) octave--;
                    i++; break;
                   
                case '\n': 
                    Random rand = new Random();
                    musicString.append(setInstrumentTo(rand.nextInt(127))); break; 
                   
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': 
                    int chValue = Character.getNumericValue(ch);
                    musicString.append(setInstrumentTo(instrument+chValue)); break;
                    
                //default: musicString.append(noteString); break;

            }
        }
        return new Pattern(musicString.toString());                             //retorna nova Pattern construida
    }

    private String setBPMTo(int value){
        if(bpm > 50)
            bpm = value;
        return "T" + bpm + " ";
    }
    
    private String setInstrumentTo(int value){
        if (value < 128)
            instrument = value; 
        return "I" + instrument + " "; 
    }
    
    private String setNoteTo(String note){
        return noteString = note + octave + " "; 
    }

}