package org.Taha;

import org.Taha.AwesomePasswordChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

public class AwesomePasswordCheckerTest {

    @Test
    void testMaskAff_LowercaseLetters() {
         String a = "Na ";
        AwesomePasswordChecker checker = new AwesomePasswordChecker();
        int tab[] = checker.maskAff(a);
        assertNotNull(tab);
        assertTrue(tab.length == 28, "La taille doit etre 28");
        // Verifier que le tableau correspond bien à la fonctionalité de la fonction
        // maskAff
        assertArrayEquals(
                new int[] { 3, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, tab);
 
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
