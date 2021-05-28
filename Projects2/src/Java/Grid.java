package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Grid extends JFrame implements ActionListener {
    // public static char[][] map = new char[10][10];
    CardLayout cardLayout;
    JPanel cards;
    int fruitX;
    int fruitY;
    int score;
    final  int row = 10;
    final int col = 10;
    JLabel[][] grid = new JLabel[row][col];
    Snake snake = new Snake();
    private Timer timer;
    private final int delay = 175;
    boolean gameplay = false;

    public Grid() {
        score=0;
        this.setSize(500, 600);

        JPanel start = new JPanel();
        JPanel panel = new JPanel();
        start.setBackground(Color.black);
        start.setForeground(Color.white);
        JButton sbutton = new JButton("START");
        JLabel slabel = new JLabel("SNAKE");
        JLabel sname = new JLabel("Enter your name: ");
        JTextField text = new JTextField(16);

        Main.name = text.getText();


        slabel.setFont(new Font("Verdana", Font.BOLD, 40));
        slabel.setForeground(Color.white);
        slabel.setHorizontalAlignment(JLabel.CENTER);
        start.add(slabel);
        sname.setFont(new Font("Verdana", Font.PLAIN, 30));
        sname.setForeground(Color.white);
        sname.setHorizontalAlignment(JLabel.CENTER);
        start.add(sname);
        start.add(text);
        start.add(sbutton);

        cards = new JPanel(new CardLayout());
        cardLayout = (CardLayout) cards.getLayout();
        cards.add(start, "Card 1");
        cards.add(panel, "Card 2");

        this.add(cards);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        //this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        panel.setLayout(new GridLayout(row+1, col));
        //panel.setMaximumSize(new Dimension(10, 10));
        this.setBackground(Color.black);
        panel.setForeground(Color.white);
        sbutton.addActionListener(this);

        /*JLabel stats = new JLabel("Name: " + Main.name + " Score: " + score);
        stats.setLayout(new GridLayout(3,1));
        JLabel border = new JLabel("____________________________");
        stats.setVerticalAlignment(JLabel.NORTH);
        border.setVerticalAlignment(JLabel.NORTH);
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        panel.add(stats);
        panel.add(s);*/

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = new JLabel("+");
                grid[i][j].setHorizontalAlignment(JLabel.CENTER);
                grid[i][j].setBackground(Color.black);
                grid[i][j].setForeground(Color.white);
                grid[i][j].setOpaque(true);
                panel.add(grid[i][j]);
            }
        }
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void drawSnake() {
        grid[snake.snakePos.get(0)][snake.snakePos.get(1)].setText(new JLabel("@").getText());
        grid[snake.snakePos.get((0))][snake.snakePos.get(1)].setForeground(Color.green);
        grid[snake.snakePos.get(0)][snake.snakePos.get(1)].setFont(new Font("Verdana", Font.PLAIN, 40));
        for (int i = 0; i < snake.snakeBody.size() - 1; i += 2) {
            grid[snake.snakeBody.get(i)][snake.snakeBody.get(i + 1)].setText(new JLabel("^").getText());
            grid[snake.snakeBody.get(i)][snake.snakeBody.get(i + 1)].setForeground(new Color(30, 180, 0));
            grid[snake.snakeBody.get(i)][snake.snakeBody.get(i + 1)].setFont(new Font("Verdana", Font.PLAIN, 40));
        }
    }

    public void startGame() {
        timer = new Timer(delay, this);
        timer.start();
        gameplay=true;
        newFruit();
    }

    public void newFruit() {
        fruitX = (int) (Math.random() * (9 - 0));
        fruitY = (int) (Math.random() * (9 - 0));
        int z = (int) (Math.random() * (3 - 0));

        switch (z) {
            case 0:
                grid[fruitX][fruitY].setText(new Fruit("speed", new JLabel("O")).jl.getText());
                grid[fruitX][fruitY].setForeground(Color.blue);
                break;
            case 1:
                grid[fruitX][fruitY].setText(new Fruit("slow", new JLabel("O")).jl.getText());
                grid[fruitX][fruitY].setForeground(Color.red);
                break;
            default:
                grid[fruitX][fruitY].setText(new Fruit("normal", new JLabel("O")).jl.getText());
                grid[fruitX][fruitY].setForeground(Color.yellow);
                break;
        }
        grid[fruitX][fruitY].setFont(new Font("Verdana", Font.PLAIN, 40));
    }

    public void updateFruit() {
        if (grid[fruitX][fruitY].getText().isEmpty()) {
            newFruit();
        }
    }

    //@Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawString("Name: " + Main.name + " Score: " + score, 300, 0);
        drawSnake();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(e.getActionCommand().equalsIgnoreCase("START")){
            cardLayout.next(cards);
            drawSnake();
            //Snake.move();

        }*/
        if(gameplay == true){
            while (gameplay == true) {
                Snake.move();
                drawSnake();
                System.out.print("game play is "+gameplay);
            }
            drawSnake();
        }

            // if (gameplay){
            //   snakeInc();
            //   snake.snakeDie();
            //   snake.move();
            //   snake.checkDirect();
            // }repaint();

        //Snake.move();
    }

    public void move(){

        if (Snake.direct.equals("up")) {
            Snake.snakePos.set(1, Snake.snakePos.get(1) - 2);
        }
        if (Snake.direct.equals("down")) {
            Snake.snakePos.set(1, Snake.snakePos.get(1) + 2);
        }
        if (Snake.direct.equals("left")) {
            Snake.snakePos.set(0, Snake.snakePos.get(0) - 2);
        }
        if (Snake.direct.equals("right")) {
            Snake.snakePos.set(0, Snake.snakePos.get(0) + 2);
        }

    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT)  {
                snake.changeToDirect = "left";
            }

            if (key == KeyEvent.VK_RIGHT)  {
                snake.changeToDirect = "right";
            }

            if (key == KeyEvent.VK_UP)  {
                snake.changeToDirect = "up";
            }

            if (key == KeyEvent.VK_DOWN)  {
                snake.changeToDirect = "down";
            }
        }
    }

    public void snakeInc() {
        snake.snakeBody.addAll(0, snake.snakePos);

        if (snake.snakePos.get(0) == fruitX && snake.snakePos.get(1) == fruitY) {
            score++;

            // foodSet = False;
        } else {
            snake.snakeBody.remove(snake.snakeBody.size() - 1);
            snake.snakeBody.remove(snake.snakeBody.size() - 1);
        }
    }
}

