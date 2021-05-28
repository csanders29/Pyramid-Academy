package Test;

import Java.CaesarCipher;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherTest {
    CaesarCipher cipher;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        cipher = new CaesarCipher();
    }

    @DisplayName("Test Encrypt")
    @Test
    void testEncrypt() throws IOException {
        String s = "Hi I am China!";
        int i = 1;
        assertEquals("Ij J bn Dijob!", cipher.encrypt(s,i), "Test Encrypt Failed");
    }

    @DisplayName("Test Decrypt")
    @Test
    void testDecrypt() throws IOException {
        assertEquals("Hi I am China!", cipher.decrypt(1), "Test decrypt Failed");
    }

    @AfterEach
    void tearDown() {
        System.out.println("In After Each....");
    }

    //This is only called after everything else
    @AfterAll
    public static void afterClass() {
        System.out.println("After!!! **** - I am only called once!!!");
    }

}