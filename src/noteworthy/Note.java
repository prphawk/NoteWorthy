/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noteworthy;

/**
 *
 * @author frede
 */
public class Note {
    private char note;
    private int octave;
    
    public Note(String note, int octave) throws Exception {
        switch(note) {
            case "Dó": this.note = 'C'; break;
            case "Ré": this.note = 'D'; break;
            case "Mi": this.note = 'E'; break;
            case "Fá": this.note = 'F'; break;
            case "Sol": this.note = 'G'; break;
            case "Lá": this.note = 'A'; break;
            case "Si": this.note = 'B'; break;
            default: throw new Exception("Nota inválida.");
        }
        if (octave < 0) {
            throw new Exception("Underflow de oitava.");
        }
        if (octave > 10 || (octave == 10 && this.note <= 'B')) {
            throw new Exception("Overflow de oitava.");
        }
        this.octave = octave;
    }
    
    public Note(char note, int octave) throws Exception {
        if (note < 'A' || note > 'G') {
            throw new Exception("Nota inválida.");
        }
        this.note = note;
        if (octave < 0) {
            throw new Exception("Underflow de oitava.");
        }
        if (octave > 10 || (octave == 10 && this.note <= 'B')) {
            throw new Exception("Overflow de oitava.");
        }
        this.octave = octave;
    }
    
    public Note(String note) throws Exception {
        switch(note) {
            case "Dó": this.note = 'C'; break;
            case "Ré": this.note = 'D'; break;
            case "Mi": this.note = 'E'; break;
            case "Fá": this.note = 'F'; break;
            case "Sol": this.note = 'G'; break;
            case "Lá": this.note = 'A'; break;
            case "Si": this.note = 'B'; break;
            default: throw new Exception("Nota inválida.");
        }
        this.octave = 5;
    }
    
    public Note(char note) throws Exception {
        if (note < 'A' || note > 'G') {
            throw new Exception("Nota inválida.");
        }
        this.note = note;
        this.octave = 5;
    }
    
    public void incrementOctave() throws Exception {
        octave++;
        if (octave < 0) {
            throw new Exception("Underflow de oitava.");
        }
        if (octave > 10 || (octave == 10 && this.note <= 'B')) {
            throw new Exception("Overflow de oitava.");
        }
    }
    
    public void decrementOctave() throws Exception {
        octave--;
        if (octave < 0) {
            throw new Exception("Underflow de oitava.");
        }
        if (octave > 10 || (octave == 10 && this.note <= 'B')) {
            throw new Exception("Overflow de oitava.");
        }
    }

    @Override
    public String toString() {
        return Character.toString(note) + Integer.toString(octave) + " ";
    }
}
