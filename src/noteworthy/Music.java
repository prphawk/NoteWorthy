/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noteworthy;

import org.jfugue.pattern.*;

/**
 *
 * @author mayra
 */

public class Music {
    
    private String text;
        
    public static final String DO = "C"; //puramente pela minha vontade de des-gringar essas notas
    public static final String RE = "D";
    public static final String MI = "E";
    public static final String FA = "F";
    public static final String SOL = "G";
    public static final String LA = "A";
    public static final String SI = "B";
    public static final String PAUSE = "R "; //pausa não tem oitava colada, tem espaço no final para separar
    
    public Pattern pattern; //saída
    public String noteString; //nota tocada (concatenada depois com sua oitava)
    public String octaveString;
    public String instrumentString;
    public String bpmString;
    
    private int octave; //valores numéricos para operações
    private int instrument;
    private int bpm;
  
    public Music(String text){
        this.text = text; //texto recebido
        noteString = PAUSE; //caso a operação seja repetir ultima nota sem nenhuma nota ter sido tocada, emite pausa
        
        //defaults (referências do jfugue):
        octaveString = "5 "; //oitavas nao estão sendo mais alteradas de acordo com o novo mapeamento dele :// mas cada nota está colada com a sua
        instrumentString = "I0 "; //I + cod do instrumento (esse é o piano)
        bpmString = "T120 "; //T + bpms (agraggio eu acho)
        
        octave = 5;
        instrument = 0;
        bpm = 120;
    }
    
    public Pattern build(){ //constroi uma string personalizada de acordo com os comandos do jfugue
       
        StringBuilder musicString = new StringBuilder(); //para construir a pattern final a partir de uma string formada com StringBuilder
        
        for (int i = 0; i < text.length(); i++) { //cada char do texto
            
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
                case 'g': musicString.append(noteString); break; //de 'a' até 'g' repete última nota
                case ' ': /* aumenta volume*/ break;
                case '!': musicString.append(setInstrumentTo(114)); break;
                case 'i':
                case 'o':
                case 'u': 
                case 'I':
                case 'O': //isso fode as oitavas
                case 'U': musicString.append(setInstrumentTo(7)); break;
                case ';': musicString.append(setInstrumentTo(76)); break;
                case ',': musicString.append(setInstrumentTo(20)); break;
                case '.':
                case '?': octave = 5; octaveString = "5 "; break; //volta a oitava e volume (n implementado) default
                
                case 'T': //n tem bpm mais mas
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
                    //Random rand = new Random(); //queria instrumentos randomicos antes (0 a 127)
                    //instrument = 15;rand.nextInt(127); 
                   
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': musicString.append(setInstrumentTo(instrument+Character.getNumericValue(ch))); break; //regra do maps
                    
                default: musicString.append(noteString); break;

            }
        }

        return pattern = new Pattern(musicString.toString()); //retorna nova Pattern construida
        }

    public String setInstrumentTo(int value){ //para mudar um instrumento na String pro jfugue eh "I + valor do instrumento" uma vez
        instrument = value; 
        return instrumentString = "I" + instrument + " "; 
    }
    
    public String setNoteTo(String note){
        return noteString = note + octaveString; 
    }

}
