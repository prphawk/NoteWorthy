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
    
    public static final String DO = "C";                                        //puramente pela minha vontade de des-gringar essas notas
    public static final String RE = "D";
    public static final String MI = "E";
    public static final String FA = "F";
    public static final String SOL = "G";
    public static final String LA = "A";
    public static final String SI = "B";
    public static final String PAUSE = "R ";                                    //pausa não tem oitava colada, tem espaço no final para separar
    
    private static final int OCTAVE_DEFAULT = 5;                                //5ª oitava
    private static final int INSTRUMENT_DEFAULT = 0;                            //piano
    private static final int BPM_DEFAULT = 120;                                 //agraggio
    
    private int octave;                                                         //valores numéricos para operações
    private int instrument;
    private int bpm;
    
    private String text;
    private String noteString;                                                  //nota tocada
    private String octaveString;                                                //nota é concatenada com sua oitava
    private String instrumentString;                                            //I + cod do instrumento
    private String bpmString;                                                   //T + bpms
    
  
    public Music(String aText){
        
        text = aText;                                                           //texto a ser formatado de acordo com os comandos do jfugue 
                
        octave = OCTAVE_DEFAULT;                                                //5
        instrument = INSTRUMENT_DEFAULT;                                        //0
        bpm = BPM_DEFAULT;                                                      //120
        
        noteString = PAUSE;                                                     //caso a operação seja repetir ultima nota sem nenhuma nota ter sido tocada, emite pausa -> "R "
        octaveString = OCTAVE_DEFAULT + " ";                                    //printar na string final nota + oitava (exceto para PAUSE) + espaço para separar comandos -> "5 "
        instrumentString = "I" + INSTRUMENT_DEFAULT + " ";                      //printar na string final I + codigo do intrumento + espaço para separar comandos -> "I0 "
        bpmString = "T" + BPM_DEFAULT + " ";                                    //printar na string final T + bpms + espaço para separar comandos -> "T120 "
    }
    
    public Pattern build(){                                                     //constroi uma string personalizada de acordo com os comandos do jfugue
       
        StringBuilder musicString = new StringBuilder();                        //para construir a pattern final a partir de uma string formada com StringBuilder
        
        for (int i = 0; i < text.length(); i++) {                               //cada char do texto
            
            char ch = text.charAt(i);
            
            switch(ch){
                
                case 'a': musicString.append(setNoteTo(LA)); break;
                case 'b': musicString.append(setNoteTo(SI)); break;
                case 'c': musicString.append(setNoteTo(DO)); break;
                case 'd': musicString.append(setNoteTo(RE)); break;
                case 'e': musicString.append(setNoteTo(MI)); break;
                case 'f': musicString.append(setNoteTo(FA)); break;
                case 'g': musicString.append(setNoteTo(SOL)); break;
                case ' ': 
                case 'i':
                case 'o':
                case 'u': musicString.append(noteString); break;                //printa na string final a ultima nota tocada
                case ';': musicString.append(PAUSE); break;
                
                case '.':
                case '?': 
                    octave = OCTAVE_DEFAULT; 
                    octaveString = OCTAVE_DEFAULT + " "; break;                 //volta a oitava e volume (n implementado) default
                
                case '+':
                case '-': /*volume aqui*/ break;
                
                case 'T':
                    if(text.charAt(i+1) == '+') bpm += 50; 
                    if(text.charAt(i+1) == '-' && bpm > 50) bpm -= 50; 
                    bpmString = "T" + bpm + " ";
                    musicString.append(bpmString); i++; break;
                
                case 'O': 
                    if(text.charAt(i+1) == '+' && octave < 9) octave++;         //de 0 a 9
                    if(text.charAt(i+1) == '-' && octave > 0) octave--;
                    octaveString = octave + " "; i++; break;
                   
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

    private String setInstrumentTo(int value){ 
        instrument = value; 
        return instrumentString = "I" + instrument + " "; 
    }
    
    private String setNoteTo(String note){
        return noteString = note + octaveString; 
    }

}