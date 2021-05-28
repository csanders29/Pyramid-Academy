package Test;

import Java.GuessNumber;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuessNumberTest {
    GuessNumber guessNumber;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        guessNumber = new GuessNumber();
    }

    @DisplayName("Test Guess Number")
    @Test
    void guessNumber() {
       int num = 10;
       guessNumber.secretNumber = 15;
        assertEquals("Too low", guessNumber.guess(num), "Test Guesss Number Failed");
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