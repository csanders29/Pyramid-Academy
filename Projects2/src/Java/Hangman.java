package Java;

import java.util.*;

public class Hangman {
    public static char[] wordarr = new char[]{'_','_','_'};
    public static ArrayList<Character> missedLets = new ArrayList<Character>();
    public static int count=0;
    public static String[] words = new String[]{"cat","dog","car","rat","bat"};

    public static void main(String[] args) {

        String word = chooseWord(words);
        char[] tmp = word.toCharArray();
        Scanner scan = new Scanner(System.in);
        char guess= 'z';
        char play = 'Y';
        System.out.println("H A N G M A N");

            if(Arrays.equals(tmp, wordarr)){
                play = 'N';
            }
            else{
                while (!Arrays.equals(tmp, wordarr)) {
                    hang(count);
                    System.out.println("Missed Letters:" + missedLets.toString());
                    fillBlanks(word, guess);

                    if(Arrays.equals(tmp, wordarr)){
                        break;
                    }

                    System.out.println("Guess a letter");
                    guess = scan.next().charAt(0);
                    checkGuess(guess, word);
                }
            }

        System.out.println("You've guessed the word " + word+ "!\nPlay Again?(Y/N)");
        char c = scan.next().charAt(0);
        if(c== 'Y' || c== 'y'){
            resetVars();
            main(null);
        }
    }

    public static String chooseWord(String[] w) {
        double i = Math.random() * ( 4 - 0 );
        return words[(int) i];
    }

    public static boolean checkGuess(char guess, String word) {
        if(missedLets.contains(guess) || Arrays.asList(wordarr).contains(guess)){
            System.out.println("You've guessed that letter already");
            return false;
        }
        else{
            if (guess != word.charAt(0) && guess != word.charAt(1) && guess != word.charAt(2)) {
                missedLets.add(guess);
                count++;
                hang(count);
                return false;
            }
            else{
                hang(count);
                return true; }

        }

    }

    public static String fillBlanks(String s, char g) {
        if(g==s.charAt(0)){
            wordarr[0]=g;
        }
        else if(g==s.charAt(1)){
            wordarr[1]=g;
        }
        else if(g==s.charAt(2)){
            wordarr[2]=g;
        }
            String str = wordarr[0]+" "+wordarr[1]+" "+wordarr[2];
            System.out.println(wordarr[0]+" "+wordarr[1]+" "+wordarr[2]);
            return str;
    }

    public static String hang(int count) {
        //switch statement
        String str = "+---+\nO  |\n   |\n   |\n  ===";
        switch(count) {
            case 1:
                str = "+---+\nO  |\n   |\n   |\n  ===";
                System.out.println("+---+");
                System.out.println("O  |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 2:
                str = "+---+\nO  |\n|  |\n   |\n  ===";
                System.out.println("+---+");
                System.out.println("O  |");
                System.out.println("|  |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 3:
                str = "+---+\nO  |\n|\\ |\n   |\n  ===";
                System.out.println("+---+");
                System.out.println("O  |");
                System.out.println("|\\ |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 4:
                str = "+---+\n O  |\n/|\\|\n   |\n  ===";
                System.out.println("+---+");
                System.out.println(" O  |");
                System.out.println("/|\\|");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 5:
                str = "+---+\n O  |\n/|\\|\n/  |\n  ===";
                System.out.println("+---+");
                System.out.println(" O  |");
                System.out.println("/|\\|");
                System.out.println("/  |");
                System.out.println("  ===");
                break;
            case 6:
                str = "+---+\n O  |\n/|\\|\n/ \\|\n  ===";
                System.out.println("+---+");
                System.out.println(" O  |");
                System.out.println("/|\\|");
                System.out.println("/ \\|");
                System.out.println("  ===");
                break;
            default:
                str = "+---+\n   |\n   |\n   |\n  ===";
                System.out.println("+---+");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
        }
        return str;
    }

    public static void resetVars() {
        wordarr = new char[]{'_','_','_'};
        missedLets = new ArrayList<Character>();
        int count=0;
    }

}
