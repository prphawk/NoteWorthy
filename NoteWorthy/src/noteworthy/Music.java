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
    
    public void build(){
        
       
        Player player = new Player(); 
        StringBuilder string = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            
            char ch = text.charAt(i);
            
            switch(ch){
                
                case 'a': noteString = LA + octaveString; string.append(noteString); break;
                case 'b': noteString = SI + octaveString; string.append(noteString); break;
                case 'c': noteString = DO + octaveString; string.append(noteString); break;
                case 'd': noteString = RE + octaveString; string.append(noteString); break;
                case 'e': noteString = MI + octaveString; string.append(noteString); break;
                case 'f': noteString = FA + octaveString; string.append(noteString); break;
                case 'g': noteString = SOL+ octaveString; string.append(noteString); break;
                case ' ': noteString = PAUSE; string.append(noteString); break;
                case 'i':
                case 'o':
                case 'u': string.append(noteString); break;
                case '.':
                case '?': octaveString = "5 "; break;
                
                case 'B': 
                    if(text.charAt(i+1) == '+') bpm += 50; bpmString = "T" + bpm + " ";
                    if(text.charAt(i+1) == '-') bpm -= 50; bpmString = "T" + bpm + " ";
                    string.append(bpmString); break;
                case 'O': 
                    if(text.charAt(i+1) == '+') octave++; octaveString = octave + " ";
                    if(text.charAt(i+1) == '-') octave--; octaveString = octave + " "; 
                    
                case '\n': 
                    Random rand = new Random(); 
                    instrument = rand.nextInt(127); 
                    instrumentString = "I" + instrument + " "; 
                    string.append(instrumentString); break;                    
            }
        }

        player.play(string.toString());
        
    }
    
    
}
