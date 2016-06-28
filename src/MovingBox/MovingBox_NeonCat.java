package MovingBox;



//import javaclass.ContentViewSolution;
//import javaclass.StudentWorkSolution;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

class StudentWorkSolution {
    
    // Used to set up my more complicated background.
    //final public static...

    int positionX, positionY, velocityX, velocityY, accerationX, accerationY;
    int sizeX, sizeY;
    Color characterColor, backgroundColor;

    /**
     * ******************************
     * This will be called at the beginning of the program
     * ******************************
     */
    public void initialize() {

    }

    /**
     * ******************************
     * These 4 methods will be called when you touch the arrow keys
     * ******************************
     */
    public void moveLeft() {
        positionX -= 2;

    }

    public void moveRight() {
        positionX += 2;

    }

    public void moveUp() {
        positionY -= 2;
    }

    public void moveDown() {
        positionY += 2;

    }

    /**
     * ******************************
     * These two will be called every time it draws on the screen.
     *
     * 60 frames per second.
     *
     * The array has 4 values. It will tell you if a key is being pressed.
     *
     * At position 0 if it is true then up is pressed 0 - Up 1 - Right 2 - Down
     * 3 - Left *****************************
     */
    public void update(boolean[] keyPressed) {
        if (keyPressed[0]) {
            moveUp();
        }
        if (keyPressed[1]) {
            moveRight();
        }
        if (keyPressed[2]) {
            moveDown();
        }
        if (keyPressed[3]) {
            moveLeft();
        }

        positionX = positionX + velocityX;
        positionY = positionY + velocityY;
        velocityX = velocityX + accerationX;
        velocityY = velocityY + accerationY;
    }

    /**
     * ***************************************
     * Do not edit this method **************************************
     */
    public void draw(Graphics g) {
        g.setColor(this.backgroundColor);
        g.fillRect(00, 00, 700, 700);
        
        /*** draw other background rectangles ***/
        g.setColor(new Color(255,0,0));
        for (int i=0; i<700; i+=50) {
            int start = 0;
            if (i%100 == 50)
                start = 50;
            for (int j=start; j<700; j+=100)
                g.fillRect(i, j, 50, 50);
        }

        g.setColor(this.characterColor);
        g.fillRect(positionX, positionY, sizeX, sizeY);
    }

    /**
     * ***************************************
     * Do not edit this method **************************************
     */
    public StudentWorkSolution() {
        positionX = 350;
        positionY = 350;
        velocityX = 0;
        velocityY = 0;
        accerationX = 0;
        accerationY = 0;
        sizeX = 50;
        sizeY = 50;
        characterColor = Color.black;
        backgroundColor = Color.white;
    }

}

/**
 * **************************************************
 *
 * STOP
 *
 * For this problems there is no reason to edit below this warning.
 *
 **************************************************
 */
public class MovingBox_NeonCat {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Homework Problem 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        ContentViewSolution view = new ContentViewSolution();
        frame.add(view);
        frame.addKeyListener(view);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}

class ContentViewSolution extends JComponent implements KeyListener, Runnable {

    StudentWorkSolution student;
    boolean[] keyMap = new boolean[4];

    public ContentViewSolution() {
        student = new StudentWorkSolution();
        student.initialize();
        for (int i = 0; i < keyMap.length; i++) {
            keyMap[i] = false;
        }
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            student.update(keyMap);
            repaint();
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.keyMap[0] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.keyMap[1] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.keyMap[2] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.keyMap[3] = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.keyMap[0] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.keyMap[1] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.keyMap[2] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.keyMap[3] = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void paintComponent(Graphics g) {
        student.draw(g);
    }

}