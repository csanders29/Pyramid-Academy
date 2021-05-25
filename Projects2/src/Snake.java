package Java;

import java.util.ArrayList;

public class Snake {
    public static ArrayList<Integer> snakePos = new ArrayList<>();
    public static ArrayList<Integer> snakeBody = new ArrayList<>();
    public static String direct = "";
    public static String changeToDirect = "";
    private int speed = 2;
    private int score = 0;
    // private int flag = 0;

    // public FPS control(){
    // }
    public Snake() {
        ArrayList<Integer> head = new ArrayList<>();
        head.add(5);// x-asix
        head.add(5);// y=asix
        ArrayList<Integer> body = new ArrayList<>();
        body.add(5);
        body.add(6);

        body.add(5);
        body.add(7);

        body.add(5);
        body.add(8);

        body.add(5);
        body.add(9);

        this.snakePos = head;
        this.snakeBody = body;
        this.direct = "up";
        this.changeToDirect = "up";
        this.speed = 2;
        this.score = 0;
        // this.flag = flag;
    }

    public int getScore() {
        return this.score;
    }

    public void checkDirect() {
        if (changeToDirect.equals("up") && !direct.equals("down")) {
            direct = "up";
        }
        if (changeToDirect.equals("down") && !direct.equals("up")) {
            direct = "down";
        }
        if (changeToDirect.equals("left") && !direct.equals("right")) {
            direct = "left";
        }
        if (changeToDirect.equals("right") && !direct.equals("left")) {
            direct = "right";
        }
    }

    public void accelerate() {
        if (this.speed <= 5) {
            this.speed++;
            // flag = 0;
        }
    }

    public static void move() {
        String food = "";
        int foodSize = 2;
        int slowFoodSize = 1;
        int speedFoodSize = 3;
        while (food == "") {

            if (direct.equals("up")) {
                snakePos.set(1, snakePos.get(1) - foodSize);
            }
            if (direct.equals("down")) {
                snakePos.set(1, snakePos.get(1) + foodSize);
            }
            if (direct.equals("left")) {
                snakePos.set(0, snakePos.get(0) - foodSize);
            }
            if (direct.equals("right")) {
                snakePos.set(0, snakePos.get(0) + foodSize);
            }
        }
        while (food == "speed") {
            if (direct.equals("up")) {
                snakePos.set(1, snakePos.get(1) - speedFoodSize);
            }
            if (direct.equals("down")) {
                snakePos.set(1, snakePos.get(1) + speedFoodSize);
            }
            if (direct.equals("left")) {
                snakePos.set(0, snakePos.get(0) - speedFoodSize);
            }
            if (direct.equals("right")) {
                snakePos.set(0, snakePos.get(0) + speedFoodSize);
            }
        }
        while (food == "slow") {
            if (direct.equals("up")) {
                snakePos.set(1, snakePos.get(1) - slowFoodSize);
            }
            if (direct.equals("down")) {
                snakePos.set(1, snakePos.get(1) + slowFoodSize);
            }
            if (direct.equals("left")) {
                snakePos.set(0, snakePos.get(0) - slowFoodSize);
            }
            if (direct.equals("right")) {
                snakePos.set(0, snakePos.get(0) + slowFoodSize);
            }
        }
    }

    public void snakeDie() {
        // for (int i = 0; i < snakeBody.size() - 1; i += 2) {
        //   if (snakePos.get(0).equals(snakeBody.get(i)) && snakePos.get(1).equals(snakeBody.get(i + 1))) {
        //     System.out.println("end game ");
        //     // endgame();
        //   }
        // }
        if (snakePos.get(0)< 0 ||snakePos.get(0)>10||snakePos.get(1)<0
                ||snakePos.get(1)> 10){
            System.out.println("!! hit wall !!");
            //endgame();
        }

    }
}

