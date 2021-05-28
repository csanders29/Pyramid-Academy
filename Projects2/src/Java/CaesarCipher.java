package Java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

public class CaesarCipher implements Serializable{
    public static void main(String[] args) throws IOException {
        File f = new File("file.txt");
        Scanner scan = new Scanner(System.in);
        String message ="";
        int key;

        System.out.println("Do you wish to encrypt or decrypt a message?");
        String temp = scan.next();

        if(temp.equalsIgnoreCase("encrypt")){
            System.out.println("Enter your messsage: ");
            message = scan.next() + scan.nextLine();
            System.out.println("Choose your key number (1-52): ");
            key = scan.nextInt();

            System.out.println("Your translated text is: ");
            System.out.println(encrypt(message, key));;
            System.out.println("\nWould you like to decrypt your message? (Y/N)");
            char d = scan.next().charAt(0);
            if(d == 'y'){
                System.out.println(decrypt(key));
            }
            else{
                f.delete();
                System.exit(0);
            }
        }
        else if(temp.equalsIgnoreCase("decrypt")){
            System.out.println("Enter key number: ");
            key = scan.nextInt();
            System.out.println(decrypt(key));
        }
        else{
            main(null);
        }

        f.deleteOnExit();

    }

    public static String encrypt(String s, int k) throws IOException {
        FileOutputStream out = new FileOutputStream(String.valueOf(Paths.get("file.txt")));
        String result = "";
        char[] str = s.toCharArray();

        for (int i = 0; i < str.length; i++) {
            // For upper letters
            if (Character.isAlphabetic(s.charAt(i))) {
                str[i] = (char) (((int) str[i] - k));
            }
            // For digits
            else {
                str[i] = s.charAt(i);
                result += (char)(((int)(s.charAt(i))) % 10 + '0');
            }
        }

        out.write(String.valueOf(str).getBytes(StandardCharsets.UTF_8));
        return String.valueOf(str);
    }

    public static String decrypt(int k) throws IOException {

        Scanner scan = new Scanner(Paths.get("file.txt"));
        String r = scan.nextLine();
        char[] str = r.toCharArray();

        for (int i = 0; i < str.length; i++) {
            // For upper letters
            if (Character.isAlphabetic(r.charAt(i))) {
                str[i] = (char) (((int) str[i] - k));
            }
            // For digits
            else {
                str[i] = r.charAt(i);
            }
        }
        return String.valueOf(str);
    }
}

