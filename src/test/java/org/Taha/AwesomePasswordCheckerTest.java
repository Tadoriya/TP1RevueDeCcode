package org.Taha;

import org.Taha.AwesomePasswordChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AwesomePasswordCheckerTest {

    @Test
    public void testgetInstanceTest() throws IOException {
        // Assurer que l'instance est non null
        assertNotNull(AwesomePasswordChecker.getInstance(), "L'instance doit etre non null");
    }

  @Test
    public void testgetInstanceWihtParam() throws IOException {
        File f = new File("src/main/ressources/cluster_centers_HAC_aff.csv");
        assertNotNull(AwesomePasswordChecker.getInstance(f), "L'instance doit etre non null");
        File tempFile = File.createTempFile("test2", ".txt");
        AwesomePasswordChecker result = AwesomePasswordChecker.getInstance(tempFile);
        assertNotNull(result);
        tempFile.delete();
    }

    @Test
    void testMaskAff_LowercaseLetters() throws IOException {
        String a = "Tadoriya3";
        
        // Fournir un InputStream vide 
        ByteArrayInputStream zz = new ByteArrayInputStream("".getBytes());
        AwesomePasswordChecker checker = new AwesomePasswordChecker(zz);
        
        int tab[] = checker.maskAff(a);
        assertNotNull(tab);
        assertTrue(tab.length == 28, "La taille doit etre 28");
        assertArrayEquals(
        new int[] { 3, 1, 2, 1, 1, 1, 2, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, tab);
    }

    @Test
    void testMaskAff_UppercaseLetters() throws IOException {
        ByteArrayInputStream zzz = new ByteArrayInputStream("".getBytes());
        AwesomePasswordChecker checker = new AwesomePasswordChecker(zzz);
        int[] expected = {3, 1, 1, 4, 1, 1, 1, 3, 1, 1, 1, 1, 2, 1, 7, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, checker.maskAff("ItsJustSaitama :/"));
    }

    @Test
    public void testGetDistance() throws IOException {
        File file = new File("src/main/ressources/cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance(file);
        
        String password = "Tadoriya3";
        double distance = checker.getDistance(password);
        
        // On peut comparer la distance avec un seuil ou une valeur attendue
        assertTrue( distance >= 0);
        assertEquals(distance,4.688994465931258);
    }

    @Test
    public void testGetDistance2() throws IOException {
        File file = new File("src/main/ressources/cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance(file);
        
        String password = "ItsJustSaitama :/";
        double distance = checker.getDistance(password);
        
        assertTrue( distance >= 0);
        assertEquals(distance,10.208928554075703);
    }

    @Test
    public void testMD5() {
        String expected = "5d41402abc4b2a76b9719d911017c592"; // MD5 de "hello"
        String result = AwesomePasswordChecker.computeMD5("hello");
                
        // Vérification
        assertNotNull(result);
        assertEquals(expected,result);
    }
// jacoco me donne 90 et je peux l'augmenter a 96 si je comment la main 
    
}
