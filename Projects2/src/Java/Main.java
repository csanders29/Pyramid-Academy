package Java;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


class Main
{
    public static String name ="";
    public static Snake snake=new Snake();
    public static void saveFile(String name, int score)
    {
        try{
            File out = new File("Java/output.txt");
            out.createNewFile();
            Files.writeString(Path.of("Java/output.txt"),name+" "+score);
        }
        catch (Exception e){e.printStackTrace();}

    }

    public static void main(String[] args)
    {
        Grid g = new Grid();
        System.out.println("What is your name");
        name= new Scanner(System.in).nextLine();
        //Grid g = new Grid();
        //GUI star game
        while (1==1)
        {
            // System.out.println("up down right left");
            // snake.changeToDirect=new Scanner(System.in).nextLine();//user input//keyevents
            // snake.checkDirect();
            // snake.move();
            //snake.snakeInc();//eat the Fruit??
            //Fruit updat
            //snake die??->
            //end game display
            //GUI display
            //snake.accelerate()//speed of snake
            //fps.control(speed)// time
        }
        //saveFile(name, snake.getScore() );
    }




}