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
    private static final int VOLUME_DEFAULT = 70;
    private static final int VOLUME_STEP = 10;
    private static final int MAX_LIMIT = 127;
    
    private int octave;                                                         //valores numéricos para operações
    private int instrument;
    private int bpm;
    private int volume;
    
    private final String text;
    private String noteString;                                                  //ultima nota tocada    
  
    
    public Music(String aText){
        
        text = aText;                                                           //texto a ser formatado de acordo com os comandos do jfugue 
        octave = OCTAVE_DEFAULT;                                                //5
        instrument = INSTRUMENT_DEFAULT;                                        //0
        bpm = BPM_DEFAULT;                                                      //120
        volume = VOLUME_DEFAULT;
        noteString = Note.PAUSE;                                                //caso a operação seja repetir ultima nota sem nenhuma nota ter sido tocada, emite pausa -> "R "
    }

    public Pattern build(){                                                     //constroi uma string personalizada de acordo com os comandos do jfugue

        StringBuilder musicString = new StringBuilder();                        //para construir a pattern final a partir de uma string formada com StringBuilder

        for (int i = 0; i < text.length(); i++) {                               //cada char do texto

            char ch = text.charAt(i);

            appendNotes(ch, musicString);

            appendInstruments(ch, musicString);

            switch(ch) {

                case ' ':
                case 'i':
                case 'o':
                case 'u': musicString.append(noteString); break;                //printa na string final a ultima nota tocada
                case ';': musicString.append(Note.PAUSE); break;

                case '.':
                case '?': octave = OCTAVE_DEFAULT; volume = VOLUME_DEFAULT; break;//volta a oitava e volume default

                case '+': musicString.append(setVolumeTo(volume+VOLUME_STEP)); break;
                case '-': musicString.append(setVolumeTo(volume-VOLUME_STEP)); break;

                case 'T':
                    if(text.charAt(i+1) == '+') musicString.append(setBPMTo(bpm+50));
                    if(text.charAt(i+1) == '-') musicString.append(setBPMTo(bpm-50));
                    i++; break;

                case 'O':
                    if(text.charAt(i+1) == '+' && octave < 9) octave++;         //de 0 a 9 sempre
                    if(text.charAt(i+1) == '-' && octave > 0) octave--;
                    i++; break;

                case '\n':
                    Random rand = new Random();
                    musicString.append(setInstrumentTo(rand.nextInt(MAX_LIMIT))); break;
            }
        }
        return new Pattern(musicString.toString());                             //retorna nova Pattern construida
    }

    private void appendNotes(char ch, StringBuilder musicString) {

        if((int) ch >= 'a' && (int) ch <= 'g') {

            String note = Note.LA;

            switch (ch) {
                case 'a': break;
                case 'b': note = Note.SI; break;
                case 'c': note = Note.DO; break;
                case 'd': note = Note.RE; break;
                case 'e': note = Note.MI; break;
                case 'f': note = Note.FA; break;
                case 'g': note = Note.SOL; break;
            }

            musicString.append(setNoteTo(note));
        }
    }

    private void appendInstruments(int ascii, StringBuilder musicString) {
        if(ascii >= '1' && ascii <= '9') {
            musicString.append(setInstrumentTo(instrument+ ascii));
        }
    }

    private String setBPMTo(int value){
        if(value > 0)
            bpm = value;
        return "T" + bpm + " ";
    }
    
    private String setInstrumentTo(int value){
        if (value < MAX_LIMIT)
            instrument = value; 
        return "I" + instrument + " "; 
    }
    
    private String setVolumeTo(int value){
        if (value < MAX_LIMIT)
            volume = value;            
        return ":CON(7," + volume + ") ";
    }
        
    private String setNoteTo(String note){
        return noteString = note + octave + " "; 
    }

}