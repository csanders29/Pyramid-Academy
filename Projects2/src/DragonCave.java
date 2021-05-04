import java.util.*;  // Import the Scanner class

public class DragonCave {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)");

        int choice1 = scan.nextInt();  // Read user input

        if(choice1 == 1){
            System.out.println("You approach the cave...\n" +
                    "It is dark and spooky...\n" +
                    "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                    "Gobbles you down in one bite!");

        }
        else if(choice1==2){
            System.out.println("You enter the cave... " +
                    "As you look around your eyes fixate on another set \n" +
                    "of eyes looking back at you from the shadows. \n" +
                    "A large green dragon comes out from the shadows... \n" +
                    "It is friendly! It cooks up some hot dogs for you!");

        }

    }
}