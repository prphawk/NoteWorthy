/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noteworthy;

import org.jfugue.pattern.*;
import org.jfugue.player.*;
import org.jfugue.theory.*;
import org.jfugue.*;
import java.util.Random;

/**
 *
 * @author mayra
 */


public class Music {
    
    
    private String text;
        
    public static final String DO = "C";
    public static final String RE = "D";
    public static final String MI = "E";
    public static final String FA = "F";
    public static final String SOL = "G";
    public static final String LA = "A";
    public static final String SI = "B";
    public static final String PAUSE = "R ";
    
    public Pattern pattern;
    public String noteString;
    public String octaveString;
    public String instrumentString;
    public String bpmString;
    
    private int octave;
    private int instrument;
    private int bpm;
  
    public Music(String text){
        this.text = text;
        noteString = PAUSE;
        
        octaveString = "5 ";
        instrumentString = "I0 ";
        bpmString = "T120 ";
        
        octave = 5;
        instrument = 0;
        bpm = 120;
    }
    
    public Pattern build(){
       
        StringBuilder musicString = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            
            char ch = text.charAt(i);
            
            switch(ch){
                
                case 'A': musicString.append(setNoteTo(LA)); break;
                case 'B': musicString.append(setNoteTo(SI)); break;
                case 'C': musicString.append(setNoteTo(DO)); break;
                case 'D': musicString.append(setNoteTo(RE)); break;
                case 'E': musicString.append(setNoteTo(MI)); break;
                case 'F': musicString.append(setNoteTo(FA)); break;
                case 'G': musicString.append(setNoteTo(SOL)); break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g': musicString.append(noteString); break;
                case ' ': /* aumenta volume*/ break;
                case '!': musicString.append(setInstrumentTo(114)); break;
                case 'i':
                case 'o':
                case 'u': 
                case 'I':
                case 'O':
                case 'U': musicString.append(setInstrumentTo(7)); break;
                case ';': musicString.append(setInstrumentTo(76)); break;
                case ',': musicString.append(setInstrumentTo(20)); break;
                case '.':
                case '?': octave = 5; octaveString = "5 "; break; //e volume default
                
                case 'T': 
                    if(text.charAt(i+1) == '+') bpm += 50; 
                    if(text.charAt(i+1) == '-' && bpm > 50) bpm -= 50; 
                    bpmString = "T" + bpm + " ";
                    musicString.append(bpmString); break;
                /*
                case 'O': 
                    if(text.charAt(i+1) == '+' && octave < 9) octave++;  //de 0 a 9
                    if(text.charAt(i+1) == '-' && octave > 0) octave--;
                    octaveString = octave + " "; break;
                */    
                case '\n': musicString.append(setInstrumentTo(15)); break;
                    //Random rand = new Random(); 
                    //instrument = 15;rand.nextInt(127); 
                   
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': musicString.append(setInstrumentTo(instrument+Character.getNumericValue(ch))); break;
                    
                default: musicString.append(noteString); break;

            }
        }

        return pattern = new Pattern(musicString.toString());
        }

    public String setInstrumentTo(int value){
        instrument = value; 
        return instrumentString = "I" + instrument + " "; 
    }
    
    public String setNoteTo(String note){
        return noteString = note + octaveString; 
    }

}
