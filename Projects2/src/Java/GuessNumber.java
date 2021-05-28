package Java;

import java.util.*;

public class GuessNumber {
    public static int secretNumber;
    public static void main(String[] args) {
        Scanner hi = new Scanner(System.in);
        System.out.println("Hi! What is your name?");
        String name = hi.next();
        System.out.println("Well, "+ name + ", I am thinking of a number...\n" +
                "\n" +
                "Take a guess.");
        System.out.println();
        System.out.println("Enter maximum amount for number range: ");
        int maxNumber = hi.nextInt();
        int tries = 1;
        secretNumber = (int) (Math.random() * maxNumber) + 1;
        System.out.println("Guess the secret number: ");
        int x = hi.nextInt();
        char c='Y';

            while (x != secretNumber) {
                guess(x);
                System.out.println("Guess again: ");
                x = hi.nextInt();
                tries++;
            }

        System.out.println("Congratz, "+ name +" you won in " + tries + " tries!");
        System.out.println();
        tries = 1;
        System.out.println("Do you want to play again? (Y/N): ");
        c = hi.next().trim().charAt(0);

        if(c== 'Y' || c== 'y'){
            main(null);
        }
    }

    public static String guess(int x){
        String s;
        if (x < secretNumber) {
            s = "Too low";

        } else {
            s = "Too high";
        }
        System.out.println(s);
        return s;
    }
}
