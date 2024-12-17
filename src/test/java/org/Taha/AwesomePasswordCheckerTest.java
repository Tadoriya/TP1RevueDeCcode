package org.Taha;

import org.Taha.AwesomePasswordChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class AwesomePasswordCheckerTest {

    @Test
    public void getInstanceTest() throws IOException {
        // Assurer que l'instance est non null
        assertNotNull(AwesomePasswordChecker.getInstance(), "L'instance doit etre non null");
    }

  @Test
    public void getInstanceWihtParam() throws IOException {
        File f = new File("src\\main\\ressources\\cluster_centers_HAC_aff.csv");
        assertNotNull(AwesomePasswordChecker.getInstance(f), "L'instance doit etre non null");
        File tempFile = File.createTempFile("test2", ".txt");
        AwesomePasswordChecker result = AwesomePasswordChecker.getInstance(tempFile);
        assertNotNull(result);
        tempFile.delete();
    }

    @Test
    void testMaskAff_LowercaseLetters() throws IOException {
        String a = "Tadoriya3";
        
        // Fournir un InputStream vide (ou valide selon les besoins)
        ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());
        AwesomePasswordChecker checker = new AwesomePasswordChecker(inputStream);
        
        int tab[] = checker.maskAff(a);
        assertNotNull(tab);
        assertTrue(tab.length == 28, "La taille doit etre 28");
        assertArrayEquals(
        new int[] { 3, 1, 2, 1, 1, 1, 2, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, tab);
    }

    // @Test
    // void testMaskAff_UppercaseLetters() {
    //     AwesomePasswordChecker checker = new AwesomePasswordChecker();
    //     int[] expected = {3, 3, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //     assertArrayEquals(expected, checker.maskAff("EASXYZ"));
    // }

    // @Test
    // void testMaskAff_Digits() {
    //     AwesomePasswordChecker checker = new AwesomePasswordChecker();
    //     int[] expected = {5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //     assertArrayEquals(expected, checker.maskAff("123456"));
    // }

    // @Test
    // void testMaskAff_SpecialCharacters() {
    //     AwesomePasswordChecker checker = new AwesomePasswordChecker();
    //     int[] expected = {6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //     assertArrayEquals(expected, checker.maskAff("!@&>?."));
    // }

    // @Test
    // void testMaskAff_EmptyPassword() {
    //     AwesomePasswordChecker checker = new AwesomePasswordChecker();
    //     int[] expected = new int[28];
    //     assertArrayEquals(expected, checker.maskAff(""));
    // }

    // @Test
    // void testMaskAff_Combination() {
    //     AwesomePasswordChecker checker = new AwesomePasswordChecker();
    //     int[] expected = {1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    //     assertArrayEquals(expected, checker.maskAff("eXAl1!"));
    // }
}
