package Test;

import Java.Goblin;
import Java.Human;
import Java.Land;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HumanvsGoblinTest {
    Land land;
    Goblin goblin;
    Human human;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        land = new Land();
        goblin = new Goblin();
        human = new Human();
    }

    @DisplayName("Test Human")
    @Test
    void testHuman() {
        assertNotNull(human, "Test Human Failed");
    }

    @DisplayName("Test Goblin")
    @Test
    void testGoblin() {
        assertNotNull(goblin, "Test Goblin Failed");
    }

    @DisplayName("Test Check Adjacent")
    @Test
    void checkAdjacent() {
        int[] indices = {0,1};
        land.grid[0][1] = human;
        land.grid[1][1] = goblin;
        assertTrue(land.checkAdjacent(human, goblin, land.grid), "Test Check Adjacent Failed");
    }

    @DisplayName("Test Find Indices")
    @Test
    void findIndices() {
        int[] indices = {0,1};
        land.grid[0][1] = human;
        assertEquals(indices, land.findIndices(human, land.grid), "Test Fill Blanks Failed");
    }

    @DisplayName("Test Combat")
    @Test
    void combat() {
        assertNotNull(land.combat(), "Test Combat Failed");
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