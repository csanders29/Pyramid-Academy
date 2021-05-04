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
                    hang(count, missedLets, word, guess);
                    System.out.println("Missed Letters:" + missedLets.toString());
                    fillBlanks(word, guess);

                    if(Arrays.equals(tmp, wordarr)){
                        break;
                    }

                    System.out.println("Guess a letter");
                    guess = scan.next().charAt(0);
                    checkGuess(guess, word, missedLets);
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

    public static void checkGuess(char guess, String word,ArrayList<Character> missedLet) {
        if(missedLet.contains(guess) || Arrays.asList(wordarr).contains(guess)){
            System.out.println("You've guessed that letter already");
        }
        else{
            if (guess != word.charAt(0) && guess != word.charAt(1) && guess != word.charAt(2)) {
                missedLets.add(guess);
                count++;
            }
            hang(count,missedLets,word,guess);
        }

    }

    public static void fillBlanks(String s, char g) {
        if(g==s.charAt(0)){
            wordarr[0]=g;
        }
        else if(g==s.charAt(1)){
            wordarr[1]=g;
        }
        else if(g==s.charAt(2)){
            wordarr[2]=g;
        }
            System.out.println(wordarr[0]+" "+wordarr[1]+" "+wordarr[2]);
    }

    public static void hang(int count, ArrayList<Character> m, String w, char g) {
        //switch statement
        switch(count) {
            case 1:
                System.out.println("+---+");
                System.out.println("O  |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 2:
                System.out.println("+---+");
                System.out.println("O  |");
                System.out.println("|  |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 3:
                System.out.println("+---+");
                System.out.println("O  |");
                System.out.println("|\\ |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 4:
                System.out.println("+---+");
                System.out.println(" O  |");
                System.out.println("/|\\|");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 5:
                System.out.println("+---+");
                System.out.println(" O  |");
                System.out.println("/|\\|");
                System.out.println("/  |");
                System.out.println("  ===");
                break;
            case 6:
                System.out.println("+---+");
                System.out.println(" O  |");
                System.out.println("/|\\|");
                System.out.println("/ \\|");
                System.out.println("  ===");
                break;
            default:
                System.out.println("+---+");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
        }
    }

    public static void resetVars() {
        wordarr = new char[]{'_','_','_'};
        missedLets = new ArrayList<Character>();
        int count=0;
    }

}
