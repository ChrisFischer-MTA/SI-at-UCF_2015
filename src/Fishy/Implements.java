package Fishy;

// Framework for SI@UCF Program: Pong
// Fill in your header comment here.
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import javax.swing.JFrame;

class StudentWorkSolution extends JComponent {

    public fish[] fishyList = new fish[100];
    public fish playerFish = new fish(true);

    public StudentWorkSolution() {
        for (int i = 0; i < fishyList.length; i++) {
            fishyList[i] = new fish();
            fishyList[i].getSpeed();
        }
    }

    public void update(boolean[] keyMap) {
        //Quick Reference Sheet:
        // up key      keyMap[0] = true;
        // down key keyMap[1] = true;
        // right  keyMap[2] = true;
        // left key keyMap[3] = true;
        for (int i = 0; i < fishyList.length; i++) {
            fishyList[i].upX();
        }
        playerFish.update(keyMap);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < fishyList.length; i++) {
            g.drawRect(fishyList[i].getX(), fishyList[i].getY(), fishyList[i].getSizeX(), fishyList[i].getSizeY());
        }
        g.setColor(Color.RED);
        g.fillRect(playerFish.getX(), playerFish.getY(), 10, 10);
        
    }

    public boolean collides(char type) {
        return false;
    }

    private void reset(char won) {
    }

    public void paintComponent(Graphics g) {
        this.draw(g);
    }
}

public class Implements {

    static StudentWorkSolution student;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fishy :)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        student = new StudentWorkSolution();
        frame.add(student);
        frame.addKeyListener(new KeyboardListener());
        frame.setResizable(false);
        frame.setVisible(true);
        //student.Wrekt();
    }

    static class KeyboardListener implements Runnable, KeyListener {

        boolean[] keyMap = new boolean[5];

        public KeyboardListener() {
            for (int i = 0; i < keyMap.length; i++) {
                keyMap[i] = false;
            }

            Thread t = new Thread(this);
            t.start();
        }

        public void run() {
            while (true) {
                student.update(keyMap);
                student.repaint();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 38) { // up key
                keyMap[0] = true;
            }
            if (e.getKeyCode() == 40) { // down key
                keyMap[1] = true;
            }
            if (e.getKeyCode() == 39) { // W key
                keyMap[2] = true;
            }
            if (e.getKeyCode() == 37) { // S key
                keyMap[3] = true;
            }
            if (e.getKeyCode() == 32) { // Space bar
                keyMap[4] = true;
            }
        }

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == 38) {
                keyMap[0] = false;
            }
            if (e.getKeyCode() == 40) { // down key
                keyMap[1] = false;
            }
            if (e.getKeyCode() == 39) { // W key
                keyMap[2] = false;
            }
            if (e.getKeyCode() == 40) { // S key
                keyMap[3] = false;
            }
        }

        public void keyTyped(KeyEvent e) {

        }
    }
}

class fish {

    final static public int[] speeds = {20, 30, 30, 50, 50, 50, 50, 75, 75, 100};
    private int posX, posY, size, speed;
    private double volX, volY;
    private boolean player;
    public int frame;
    Random rand = new Random();

    public fish() {
        this.volX = speeds[rand.nextInt(speeds.length)];
        switch (rand.nextInt(2) + 1) {
            case 1:
                this.posX = 0;
                break;
            case 2:
                this.posX = 720;
                volX = -volX;
                break;
        }
        size = 20 + rand.nextInt(60);
        posY = rand.nextInt(750);
    }

    public fish(boolean player) {
        // Constructor for player fish! :)
        posX = 375;
        posY = 375;
        volX = 0;
        volY = 0;
    }

    public void up() {
        volY -= 1; 
    }

    public void down() {
        volY += 1;
    }

    public void right() {
        volX += 1;
    }

    public void left() {
        volX -= 1;
    }

    public void getSpeed() {
        System.out.println(this.speed);
    }

    public int getX() {
        return this.posX;
    }

    public int getY() {
        return this.posY;
    }

    public void upX() {
        this.posX = posX + (int)volX;
    }

    public int getSizeX() {
        return this.size / 2;
    }

    public int getSizeY() {
        return this.size / 4;
    }

    public boolean isOffsceen() {
        return (posY > 800 || posY < 800) && (posX > 800 || posX < 800);
    }

    public void update(boolean[] keyMap) {
 
        if (keyMap[0] == true) {
            this.up();
        }
        if (keyMap[1] == true) {
            this.down();
        }
        if (keyMap[2] == true) {
            this.right();
        }
        if (keyMap[3] == true) {
            this.left();
        }
        this.posX += (int)volX;
        this.posY += (int)volY;
      /*  if((frame >= 60) || Math.abs(volX) > 10 || Math.abs(volY) > 10){
            System.out.println("Resetting"+volX+"    "+volY);
           
            frame = 0;
        }*/
        volX *= .97;
        volY *= .97;
        if(this.posX < 0)
            posX = 750;
        if(this.posX > 750)
            posX = 0;
        if(this.posY > 750)
            posY = 0;
        if(this.posY < 0)
            posY = 750;
        frame++;
    }
}
