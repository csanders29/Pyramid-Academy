package Java;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Map;



public class Board {
    private char[][] grid = new char[10][10];
    // private int[] coordinates;
    private Multimap<Integer, Integer> coordinates;

    public Board(){
        this.grid = grid;
        this.coordinates = coordinates;
    }

    //public Multimap<Integer, Integer> getCoordinates(){
     //   return coordinates;
   // }

    public char[][] getGrid(){
        return grid;
    }

    //public void setCoordinates(int i, int j){
     //   coordinates.put(i,j);
    //}

    public void arrangeShips(String s, char c, ShipDerived sd){
        int i = Integer.parseInt(String.valueOf(s.charAt(1)));
        int j = Integer.parseInt(String.valueOf(s.charAt(3)));

        if(c == 'v'){
            for(int a=0;a<sd.getLength();a++){
                if(grid[i+a][j]=='@'){
                    System.out.println("You cannot place a ship here");
                    a--;
                }
                else{
                    grid[i+a][j] = '@';
                    sd.setCoordinates(i+a,j);
                    Object g = sd.getCoordinates().entries();
                }
            }
        }
        else if(c== 'h'){
            for(int a=0;a<sd.getLength();a++){
                if(grid[i][j+a]=='@'){
                    System.out.println("You cannot place a ship here");
                    a--;
                }
                else{
                    grid[i][j+a] = '@';
                    sd.setCoordinates(i,j+a);
                    Object g=sd.getCoordinates().entries();
                }

            }
        }
        printBoard();
    }

    public void callShot(int i, int j){
        //int count =0;
        if(grid[i][j]=='@'){
            System.out.println("Hit!");
            count++;
            if(count == 2 || count == 5 || count == 8 || count == 12 || count == 17){// || count == 5 || count = 8 || count = 12 || count == 17){
                System.out.println("Ship has been sunk!");
            }
        }
        grid[i][j] = 'x';
        //shipSunk();
        //printBoard();
    }

    public void parseCoordinates(String s){
        int i = Integer.parseInt(String.valueOf(s.charAt(1)));
        int j = Integer.parseInt(String.valueOf(s.charAt(3)));
        callShot(i,j);
    }

    public boolean shipSunk(ShipDerived[] s){
        ArrayListMultimap<Integer, Integer> temp;
        ArrayList<Integer> temp2 = new ArrayList<>();
        boolean sunk = false;
        for(int i=s.length-1; i>=0;i--){
            Ship st = s[i];
            temp = s[i].getCoordinates();
            temp2 = s[i].getCoordinatesList();

           /* for(int j=0; j< temp2.size(); j+=2){
                if(grid[j][j+1]=='x'){
                    sunk = true;
                }
                else{
                    sunk = false;
                }
            }*/

            for (Map.Entry<Integer, Integer> entry : temp.entries()){
                //System.out.println(entry.getKey() + ", " + entry.getValue());
                if(grid[entry.getKey()][entry.getValue()]=='x'){
                    sunk = true;
                }
                else{
                    sunk = false;
                }
            }

            if(sunk==true){
                System.out.println("Ship has been sunk!");
            }
        temp.clear();
        }
        return sunk;
    }

    public boolean allshipSunk(ShipDerived[] s){
      if(count == 17){
          return true;
      }
      return false;
    }

    public void printBoard(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(grid[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    //setter
    public char[][] fillBoard(){

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                char i2 = Character.forDigit(i, 10);
                char j2 = Character.forDigit(j, 10);

                if(i==0 && j==0){
                    grid[i][j] = ' ';
                }
                else if(i==0 && j!=0){
                    grid[i][j] = j2;
                }
                else if(j==0 && i!=0){
                    grid[i][j] = i2;
                }
                else
                    grid[i][j] = '~';
            }
        }
        return grid;
    }

    public int count;
}
