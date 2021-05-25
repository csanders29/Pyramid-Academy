package Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Hangman2 {
    public static char[] wordarr = new char[]{'_','_','_'};
    public static ArrayList<Character> missedLets = new ArrayList<Character>();
    public static int count=0;
    public static String[] words = new String[]{"cat","dog","car","rat","bat"};
    public static int score =0;

    public static void main(String[] args) throws IOException {

        File scores = new File("src/scores.txt");
        FileInputStream in = new FileInputStream(String.valueOf(Paths.get("src/art.txt")));

        String name = "";

        String word = chooseWord(words);
        char[] tmp = word.toCharArray();
        Scanner scan = new Scanner(System.in);

        char guess= 'z';
        char play = 'Y';
        System.out.println("H A N G M A N");
        System.out.println("Enter your name: ");
        try{
            name = scan.next();
        } catch(Exception e){e.getMessage();}


        if(Arrays.equals(tmp, wordarr)){
            play = 'N';
        }
        else{ //game loop
            while (!Arrays.equals(tmp, wordarr)) {
                hang(count, missedLets, word, guess);
                System.out.println("Missed Letters:" + missedLets.toString());
                fillBlanks(word, guess);

                if(Arrays.equals(tmp, wordarr)){
                    break;
                }

                System.out.println("Guess a letter");

                try{
                    guess = scan.next().charAt(0);
                } catch(Exception e){e.getMessage();}

                checkGuess(guess, word, missedLets);
            }
        }

        FileOutputStream out = new FileOutputStream(String.valueOf(Paths.get("src/scores.txt")));
        String f = "Name: " + name + ", Score: " + score;
        out.write(f.getBytes(StandardCharsets.UTF_8));


        System.out.println(name + ", you've guessed the word " + word+ "! Your score is " + score);
        Scanner sc = new Scanner(Paths.get("src/scores.txt"));
        //sc.useDelimiter("\\Z || \\s");
        System.out.println("You have the highest score!");
        System.out.println("\nPlay Again?(Y/N)");

        try{
            char c = scan.next().charAt(0);

            if(c== 'Y' || c== 'y'){
                resetVars();
                main(null);
            }
        } catch(Exception e){ e.getMessage();}

    }

    public static String chooseWord(String[] w) {
        double i = Math.random() * ( 4 - 0 );
        return words[(int) i];
    }

    public static void checkGuess(char guess, String word,ArrayList<Character> missedLet) throws IOException {
        if(missedLet.contains(guess) || Arrays.asList(wordarr).contains(guess)){
            System.out.println("You've guessed that letter already");
        }
        else{
            if (guess != word.charAt(0) && guess != word.charAt(1) && guess != word.charAt(2)) {
                missedLets.add(guess);
                score -= 5;
                count++;
            }
            else{
                score += 10;
            }
           // hang(count,missedLets,word,guess);
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

    public static void hang(int count, ArrayList<Character> m, String w, char g) throws IOException {
        //switch statement
        String line, line1, line2, line3, line4, line5, line6 = "";

        try (Stream<String> lines = Files.lines(Paths.get("src/art.txt"))) {
            line = lines.skip(count * 6).findFirst().get();
            System.out.println(line);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        line2 = Files.readAllLines(Paths.get("src/art.txt")).get(count*6+1);
        line3 = Files.readAllLines(Paths.get("src/art.txt")).get(count*6+2);
        line4 = Files.readAllLines(Paths.get("src/art.txt")).get(count*6+3);
        line5 = Files.readAllLines(Paths.get("src/art.txt")).get(count*6+4);
        line6 = Files.readAllLines(Paths.get("src/art.txt")).get(count*6+5);
        System.out.println(line2 + "\n" + line3 + "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n");
    }

    public static void resetVars() {
        wordarr = new char[]{'_','_','_'};
        missedLets = new ArrayList<Character>();
        int count=0;
    }

}

