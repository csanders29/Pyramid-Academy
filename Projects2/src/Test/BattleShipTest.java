package Test;

import Java.BattleShip;
import Java.Board;
import Java.Player;
import Java.ShipDerived;
import com.google.common.collect.ArrayListMultimap;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleShipTest {
    BattleShip battleShip;
    Board board;
    Player player;
    ShipDerived ship;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        battleShip = new BattleShip();
        board = new Board();
        player = new Player();
        ship = new ShipDerived();
    }

    @DisplayName("Test Player Name")
    @Test
    void testPlayerName() {
        player.setName("John");
        assertEquals("John", player.getName(), "Test Player Name Failed");
    }

    @DisplayName("Test Ship Type")
    @Test
    void testShipType() {
        ship.setType("carrier");
        assertEquals("carrier", ship.getType(), "Test Ship Type Failed");
    }

    @DisplayName("Test Ship Length")
    @Test
    void testShipLength() {
        ship.setLength(5);
        assertEquals(5, ship.getLength(), "Test Ship Length Failed");
    }

    @DisplayName("Test Ship Coordinates")
    @Test
    void testShipCoordinates() {
        ship.setCoordinates(0,0);
        ArrayListMultimap<Integer, Integer> c = ArrayListMultimap.create();
        c.put(0,0);
        assertEquals(c, ship.getCoordinates(), "Test Ship Type Failed");
    }

    @DisplayName("Test Call Shot")
    @Test
    void callShot() {

    assertEquals("Continue", board.callShot(0,0), "Test Hang Failed");
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