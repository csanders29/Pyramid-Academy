import java.util.*;
import java.lang.reflect.Array;

public class Land {
    public static Object[][] grid= new Object[10][10];
    public static Human h = new Human();
    public static Goblin g = new Goblin();
    public static boolean gameEnded = false;

    public static void main(String[] args){
        char play = 'Y';
        System.out.println("Humans vs Goblins! \n");

        System.out.println("HUMANS MOVE");
        fillGrid();
        printGrid();
        Scanner scan = new Scanner(System.in);

        while(!gameEnded){

            char hmove = scan.next().charAt(0);
            move(h,hmove,findIndices(h,grid)[0],findIndices(h,grid)[1]);

            System.out.println("GOBLINS MOVE");
            printGrid();

            if(checkAdjacent(g,h,grid)){
                combat();
                gameEnded=true;
                break;
            }

            char gmove = scan.next().charAt(0);
            move(g,gmove,findIndices(g,grid)[0],findIndices(g,grid)[1]);
            printGrid();

            if(checkAdjacent(h,g,grid)){
                combat();
                gameEnded=true;
                break;
            }

            System.out.println("HUMANS MOVE");
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

    public static boolean checkAdjacent(Object o1, Object o2, Object[][] g){
        if(findIndices(o1, g)[0]==findIndices(o2,g)[0]){
            if(findIndices(o1,g)[1]==findIndices(o2,g)[1]-1 || findIndices(o1, g)[1]==findIndices(o2,g)[1]+1){
                return true;
            }
        }
        else if(findIndices(o1, g)[1]==findIndices(o2,g)[1]){
            if(findIndices(o1, g)[0]==findIndices(o2,g)[0]-1 || findIndices(o1, g)[0]==findIndices(o2,g)[0]+1){
                return true;
            }
        }
        else if(findIndices(o2, g)[0]==findIndices(o1,g)[0]){
            if(findIndices(o2,g)[1]==findIndices(o1,g)[1]-1 || findIndices(o2, g)[1]==findIndices(o1,g)[1]+1){
                return true;
            }
        }
        else if(findIndices(o2, g)[1]==findIndices(o1,g)[1]){
            if(findIndices(o2, g)[0]==findIndices(o1,g)[0]-1 || findIndices(o2, g)[0]==findIndices(o1,g)[0]+1){
                return true;
            }
        }
        return false;
    }

    public static int[] findIndices(Object o, Object[][] g){
        int[] a = new int[2];
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid.length;j++){
                if(g[i][j]==o){
                    a[0] =i;
                    a[1] =j;
                }
            }
        }
        return a;
    }

    public static void fillGrid(){
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                grid[i][j] = '-';
            }
        }

        int hi = (int) (Math.random() * ( 9 - 0 ));
        int hj = (int) (Math.random() * ( 9 - 0 ));
        int gi = (int) (Math.random() * ( 9 - 0 ));
        int gj = (int) (Math.random() * ( 9 - 0 ));
        grid[hi][hj] = h;
        grid[gi][gj] = g;
    }

    public static void move(Object o, char c, int i, int j){
        grid[i][j] = '-';
        switch(c){
            case 'n':
                grid[i-1][j] = o;
                break;
            case 's':
                grid[i+1][j] = o;
                break;
            case 'e':
                grid[i][j+1] = o;
                break;
            case 'w':
                grid[i][j-1] = o;
                break;
            default:
                break;
        }

    }

    public static void combat(){
        int a = (int) (Math.random() * ( 5 - 1 ));

        System.out.println("FIGHT!!!");
        System.out.println("...");
        switch(a){
            case 1:
                System.out.println("Human kills Goblin! Human wins!");
                break;
            case 2:
                System.out.println("Goblin kills Human. Goblin wins!");
                break;
            case 3:
                System.out.println("Human injures Goblin! Goblin retreats! Human wins!");
                break;
            case 4:
                System.out.println("Goblin injures Human! Human retreats! Goblin wins!");
                break;
            case 5:
                System.out.println("Both Human and Goblin injured! Both bled out to death!");
                break;
        }

        //System.exit(0);
    }

    public static void printGrid(){
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                System.out.print(grid[i][j] + "\t");
            }
            System.out.print("\n");

        }
    }

    public static void resetVars() {
        grid= new Object[10][10];
        h = new Human();
        g = new Goblin();
        gameEnded = false;
    }

    @Override
    public String toString(){
        return "";
    }
}
