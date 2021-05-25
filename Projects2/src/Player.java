package Java;

import java.lang.reflect.Array;
public class Player {
    private String name;
    private ShipDerived[] ships = new ShipDerived[5];

    public Player(){
        this.name = name;
        this.ships = ships;
    }

    public String getName(){
        return name;
    }

    public void setName(String x){
        name = x;
    }

    public void setShips(){
        int a = 0;
        for(int i=5; i>=1;i--){
            ShipDerived s = new ShipDerived("null", 0);
            Array.set(ships, a, s);
            a++;
        }
        ships[0].setType("carrier");
        ships[0].setLength(5);
        ships[1].setType("battleship");
        ships[1].setLength(4);
        ships[2].setType("destroyer");
        ships[2].setLength(3);
        ships[3].setType("submarine");
        ships[3].setLength(3);
        ships[4].setType("patrol boat");
        ships[4].setLength(2);
    }

    public ShipDerived[] getShips(){
        return ships;
    }

    public void setShip(String type, int length){
        for(int i=0; i<5;i++){
            ships[i] = new ShipDerived(type, length);
        }
    }

    public ShipDerived getShip(String type){
        ShipDerived temp = null;
        switch(type){
            case "carrier":
                temp = ships[0];
                break;
            case "battleship":
                temp= ships[1];
                break;
            case "destroyer":
                temp= ships[2];
                break;
            case "submarine":
                temp= ships[3];
                break;
            case "patrol boat":
                temp= ships[4];
                break;
        }
        return temp;
    }

    public ShipDerived getShip(int n){
        ShipDerived temp = null;
        switch(n){
            case 5:
                temp = ships[0];
                break;
            case 4:
                temp= ships[1];
                break;
            case 3:
                temp= ships[2];
                break;
            case 2:
                temp= ships[3];
                break;
            case 1:
                temp= ships[4];
                break;
        }
        return temp;
    }

}
