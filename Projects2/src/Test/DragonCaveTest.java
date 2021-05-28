package Test;
import Java.DragonCave;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DragonCaveTest {
    DragonCave dragonCave;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - I am only called once!!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each...");
        dragonCave = new DragonCave();
    }

    @DisplayName("Test Dragon Cave")
    @Test
    void dragonCave() {
        if(dragonCave.choice1 == 1){
            System.out.println(dragonCave.str1);
            assertNotNull(dragonCave.str1, "Test #1 Failed");
        }
        else if(dragonCave.choice1 == 2){
            System.out.println(dragonCave.str2);
            assertNotNull(dragonCave.str2, "Test #1 Failed");
        }

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



