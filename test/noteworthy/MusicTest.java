/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noteworthy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mayra
 */
public class MusicTest {
    
    @Before
    public void setUp() {
        System.out.println("Começando teste...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Terminando teste...");
    }

    /**
     * Test of build method, of class Music.
     */
    @Test
    public void testBuild() {
        System.out.println("build");
        Music instance = new Music("a b c d e f g 2 ; O+O+O-T+T-abcdefg++"); //nao tem como testar a troca de instrumentos randomica
        String expResult = "A5 A5 B5 B5 C5 C5 D5 D5 E5 E5 F5 F5 G5 G5 I2 G5 R G5 T170 T120 A6 B6 C6 D6 E6 F6 G6 :CON(7,80) :CON(7,90) ";
        String result = instance.build().toString();
        assertEquals(expResult, result);
    }
    
}
