package Java;

import java.util.*;
public class BattleShip {
    private ShipDerived[] p1ships;
    private ShipDerived[] p2ships;
    private String str;
    private Map<Integer,Integer> coordinates;
    private boolean sunk;

    public static void main(String[] args){
        Player p1 = new Player();
        Player p2 = new Player();
        Board p1board = new Board();
        Board p2board = new Board();
        Board p1board2 = new Board();
        Board p2board2 = new Board();
        Scanner scan = new Scanner(System.in);

        System.out.println("Battleship Multiplayer");
        System.out.println("Enter player 1 name: ");
        p1.setName(scan.nextLine());
        System.out.println("Enter player 2 name: ");
        p2.setName(scan.nextLine());

        p1board.fillBoard();
        p1board2.fillBoard();
        p1board.printBoard();

        for(int i=5;i>=1;i--){
            p1.setShips();
            ShipDerived[] p1ships = p1.getShips();
            System.out.println(p1.getName() + ", enter the coordinates for your "+ p1ships[i-1].getType()+ " ship.");
            System.out.println("Choose your coordinates: ");
            String temp = scan.next();
            System.out.println("Place horizontally or vertically? (h/v)");
            char temp2 = scan.next().charAt(0);
            p1board.arrangeShips(temp, temp2, p1ships[i-1]);
        }

        System.out.println("\n-------------------------------------\n");
        p2board.fillBoard();
        p2board2.fillBoard();
        p2board.printBoard();

        for(int i=5;i>=1;i--){
            p2.setShips();
            ShipDerived[] p2ships = p2.getShips();
            System.out.println(p2.getName() + ", enter the coordinates for your "+ p2ships[i-1].getType()+ " ship.");
            System.out.println("Choose your coordinates: ");
            String temp = scan.next();
            System.out.println("Place horizontally or vertically? (h/v)");
            char temp2 = scan.next().charAt(0);
            p2board.arrangeShips(temp, temp2, p2ships[i-1]);
        }

        System.out.println("\n-------------------------------------\n");
        /*p2board.fillBoard();
        p2board2.fillBoard();
        p2board.printBoard();*/

        if(!p1board.allshipSunk(p1.getShips()) && !p2board.allshipSunk(p2.getShips())){
            while(!p1board.allshipSunk(p1.getShips()) && !p2board.allshipSunk(p2.getShips())){//all ships have not sunk
                p1board2.printBoard();
                System.out.println(p1.getName()+", enter the coordinates for an attack: ");
                String temp = scan.next();
                p1board2.parseCoordinates(temp);
                p2board.parseCoordinates(temp);
                //p2board.shipSunk(p2.getShips());
                if(p1board.allshipSunk(p1.getShips()) || p2board.allshipSunk(p2.getShips())){
                    break;
                }

                System.out.println("\n---------------------------------\n");

                p2board2.printBoard();
                System.out.println(p2.getName()+", enter the coordinates for an attack: ");
                temp = scan.next();
                p2board2.parseCoordinates(temp);
                p1board.parseCoordinates(temp);
                //p1board.shipSunk(p1.getShips());

                if(p1board.allshipSunk(p1.getShips()) || p2board.allshipSunk(p2.getShips())){
                    break;
                }
            }
        }

        System.out.println("\n----------------------------\n");
        if(p1board.allshipSunk(p1.getShips())){
            System.out.println(p2.getName()+ " is the winner!");
        }
        else if(p2board.allshipSunk(p2.getShips())){
            System.out.println(p1.getName()+ " is the winner!");
        }

        System.out.println("Play Again? (Y/N)");
        char c = scan.next().charAt(0);
        if(c== 'Y' || c== 'y'){
            resetVars();
            main(null);
        }
        else{
            System.exit(0);}
    }

    public void setCoordinates(String s){
        coordinates.put(((int) s.charAt(1)), (int) s.charAt(3));
    }

    public Map<Integer, Integer> getCoordinates(){
        return coordinates;
    }

    /*public static void shipSunk(ShipDerived[] s){
        for(int i=0;i<5;i++){
            if(shipSunk(s)){

            }
        }
    }*/

    public static void resetVars(){

    }

    public boolean getSunk(){
        return sunk;
    }

    public void setSunk(boolean b){
        sunk = b;
    }

}
