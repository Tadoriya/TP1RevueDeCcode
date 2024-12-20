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
        File file = new File("C:\\\\Users\\\\hp\\\\Desktop\\\\Revue de code\\\\Tp1RevueDeCode\\\\src\\\\main\\\\ressources\\\\cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance(file);
        
        String password = "Tadoriya3";
        double distance = checker.getDistance(password);
        
        // On peut comparer la distance avec un seuil ou une valeur attendue
        assertTrue( distance >= 0);
        assertEquals(distance,4.688994465931258);
    }

    @Test
    public void testGetDistance2() throws IOException {
        File file = new File("C:\\\\Users\\\\hp\\\\Desktop\\\\Revue de code\\\\Tp1RevueDeCode\\\\src\\\\main\\\\ressources\\\\cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance(file);
        
        String password = "ItsJustSaitama :/";
        double distance = checker.getDistance(password);
        
        assertTrue( distance >= 0);
        assertEquals(distance,10.208928554075703);
    }

    @Test
    public void testMD5WithHello() {
        //String expected = "5d41402abc4b2a76b9719d911017c592"; // MD5 de "hello"
        String result = computeMD5("hello");
                
                // Vérification
                assertNotNull(result);
                System.out.println(result);
            }
        
            private String computeMD5(String input) {
                byte[] message = input.getBytes();
        int messageLenBytes = message.length;

        int numBlocks = ((messageLenBytes + 8) >>> 6) + 1;
        int totalLen = numBlocks << 6;
        byte[] paddingBytes = new byte[totalLen - messageLenBytes];
        paddingBytes[0] = (byte) 0x80;

        long messageLenBits = (long) messageLenBytes << 3;
        ByteBuffer lengthBuffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(messageLenBits);
        byte[] lengthBytes = lengthBuffer.array();

        byte[] paddedMessage = new byte[totalLen];
        System.arraycopy(message, 0, paddedMessage, 0, messageLenBytes);
        System.arraycopy(paddingBytes, 0, paddedMessage, messageLenBytes, paddingBytes.length);
        System.arraycopy(lengthBytes, 0, paddedMessage, totalLen - 8, 8);

        int[] h = {
            0x67452301,
            0xefcdab89,
            0x98badcfe,
            0x10325476
        };

        int[] k = {
            0xd76aa478, 0xe8c7b756, 0x242070db, 0xc1bdceee, 0xf57c0faf, 0x4787c62a, 0xa8304613, 0xfd469501,
            0x698098d8, 0x8b44f7af, 0xffff5bb1, 0x895cd7be, 0x6b901122, 0xfd987193, 0xa679438e, 0x49b40821,
            0xf61e2562, 0xc040b340, 0x265e5a51, 0xe9b6c7aa, 0xd62f105d, 0x02441453, 0xd8a1e681, 0xe7d3fbc8,
            0x21e1cde6, 0xc33707d6, 0xf4d50d87, 0x455a14ed, 0xa9e3e905, 0xfcefa3f8, 0x676f02d9, 0x8d2a4c8a,
            0xfffa3942, 0x8771f681, 0x6d9d6122, 0xfde5380c, 0xa4beea44, 0x4bdecfa9, 0xf6bb4b60, 0xbebfbc70,
            0x289b7ec6, 0xeaa127fa, 0xd4ef3085, 0x04881d05, 0xd9d4d039, 0xe6db99e5, 0x1fa27cf8, 0xc4ac5665,
            0xf4292244, 0x432aff97, 0xab9423a7, 0xfc93a039, 0x655b59c3, 0x8f0ccc92, 0xffeff47d, 0x85845dd1,
            0x6fa87e4f, 0xfe2ce6e0, 0xa3014314, 0x4e0811a1, 0xf7537e82, 0xbd3af235, 0x2ad7d2bb, 0xeb86d391
        };

        int[] r = {
            7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22,
            5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20,
            4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23,
            6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21
        };

        for (int i = 0; i < numBlocks; i++) {
            int[] w = new int[16];
            for (int j = 0; j < 16; j++) {
                w[j] = ByteBuffer.wrap(paddedMessage, (i << 6) + (j << 2), 4)
                        .order(ByteOrder.LITTLE_ENDIAN).getInt();
            }

            int a = h[0];
            int b = h[1];
            int c = h[2];
            int d = h[3];

            for (int j = 0; j < 64; j++) {
                int f, g;
                if (j < 16) {
                    f = (b & c) | (~b & d);
                    g = j;
                } else if (j < 32) {
                    f = (d & b) | (~d & c);
                    g = (5 * j + 1) % 16;
                } else if (j < 48) {
                    f = b ^ c ^ d;
                    g = (3 * j + 5) % 16;
                } else {
                    f = c ^ (b | ~d);
                    g = (7 * j) % 16;
                }
                int temp = d;
                d = c;
                c = b;
                b = b + Integer.rotateLeft(a + f + k[j] + w[g], r[j]);
                a = temp;
            }

            h[0] += a;
            h[1] += b;
            h[2] += c;
            h[3] += d;
        }

        ByteBuffer md5Buffer = ByteBuffer.allocate(16).order(ByteOrder.LITTLE_ENDIAN);
        md5Buffer.putInt(h[0]).putInt(h[1]).putInt(h[2]).putInt(h[3]);
        byte[] md5Bytes = md5Buffer.array();

        StringBuilder md5Hex = new StringBuilder();
        for (byte b : md5Bytes) {
            md5Hex.append(String.format("%02x", b));
        }

        return md5Hex.toString();
            }
}
