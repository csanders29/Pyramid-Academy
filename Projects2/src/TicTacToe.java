import java.util.ArrayList;
import java.util.*;

public class TicTacToe {
    public static char[] board = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
    public static int move;
    public static boolean win = false;
    public static boolean gameEnded = false;
    public static char userChoice;
    public static char compChoice;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char play = 'Y';
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Do you want to be X or O?");
        userChoice = scan.next().charAt(0);
        if(userChoice == 'X'){
            compChoice = 'O';
        }
        else{
            compChoice = 'X';
        }

        System.out.println("The computer will go first.");
        compMove();

        while(!win || !boardFull() || !gameEnded){
            System.out.println("What is your next move? (1-9)");
            move = scan.nextInt();
            board[move-1] = userChoice;
            compMove();

            if(checkWin(userChoice)){
                System.out.println("You have won!\nPlay Again?(Y/N)");
                win = true;
                gameEnded = true;
                break;
            }
            else if(checkWin(compChoice)){
                System.out.println("You have lost.\nPlay Again?(Y/N)");
                win = true;
                gameEnded = true;
                break;
            }
            else if(boardFull()){
                System.out.println("Tie!\nPlay Again?(Y/N)");
                break;
            }
        }

        char c = scan.next().charAt(0);
        if(c== 'Y' || c== 'y'){
            resetVars();
            main(null);
        }
        else{
            System.exit(0);}
    }

    public static void compMove() {
        int i = (int) (Math.random() * ( 8 - 0 ));

            if(board[i] != 'X' && board[i] != 'O'){
                board[i] = compChoice;
            }
            else{
                compMove();
                updateBoard();
            }
    }

    public static boolean boardFull() { //return boolean
            for(int i=0;i< board.length;i++){ //check if board is full
                if(board[i]!= 'X' || board[i]!='O'){
                    return false;
                }
            }
        return true;
    }

    public static boolean checkWin(char choice) { //return boolean
        for(int i=0;i< board.length;i+=3){//check rows
            if(board[i]==choice && board[i+1]==choice && board[i+2]==choice){
                win=true;
            }
        }

        for(int i=0;i< 3;i++){//check columns
            if(board[i]==choice && board[i+3]==choice && board[i+6]==choice){
                win=true;
            }
        }

        //check diagonals
        if(board[0]==choice && board[4]==choice && board[8]==choice){
            win=true;
        }
        else if(board[2]==choice && board[4]==choice && board[6]==choice){
            win=true;
        }

        return win;
    }

    public static void updateBoard() {
                System.out.println(board[0]+" | "+board[1]+" | "+board[2]);
                System.out.println("-------------");
                System.out.println(board[3]+" | "+board[4]+" | "+board[5]);
                System.out.println("-------------");
                System.out.println(board[6]+" | "+board[7]+" | "+board[8]);
                System.out.println("\n");
                checkWin(userChoice);
                boardFull();

    }

    public static void resetVars() {
        board = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
        win = false;
        gameEnded = false;
    }
}
