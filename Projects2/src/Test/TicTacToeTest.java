package Test;

import Java.TicTacToe;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeTest {
    TicTacToe tic;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        tic = new TicTacToe();
    }

    @DisplayName("Test Comp Move")
    @Test
    void compMove() {
        assertTrue(tic.compMove(), "Test Comp Move Failed");
    }

    @DisplayName("Test Board Full")
    @Test
    void boardFull() {
        assertFalse(tic.boardFull(), "Test Board Full Failed");
    }

    @DisplayName("Test Check Win")
    @Test
    void checkWin() {
        assertFalse(tic.checkWin('X'), "Test Check Win Failed");
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