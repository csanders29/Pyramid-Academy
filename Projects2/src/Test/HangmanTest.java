package Test;

import Java.Hangman;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HangmanTest {
    Hangman hangman;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        hangman = new Hangman();
    }

    @DisplayName("Test Choose Word")
    @Test
    void choosesWord() {
        String[] words = new String[]{"cat","dog","car","rat","bat"};
        String word = hangman.chooseWord(words);
        System.out.println(word);
        assertNotNull(word, "Test Choose Word Failed");
    }

    @DisplayName("Test Check Guess")
    @Test
    void checksGuess() {
        char guess = 'a';
        String word = "cat";

        assertTrue(hangman.checkGuess(guess, word), "Test Check Guess Failed");
    }

    @DisplayName("Test Fill Blanks")
    @Test
    void fillBlanks() {
        char g = 'a';
        String s = "cat";

        assertEquals("_ a _", hangman.fillBlanks(s,g), "Test Fill Blanks Failed");
    }

    @DisplayName("Test Hang")
    @Test
    void hangTest() {
        char guess = 'a';
        String word = "cat";
        int count = 3;

        assertEquals("+---+\nO  |\n|\\ |\n   |\n  ===", hangman.hang(count), "Test Hang Failed");
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