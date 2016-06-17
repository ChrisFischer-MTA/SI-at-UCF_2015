/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pong;

/**
 *
 * @author Seminar
 */
// Framework for SI@UCF Program: Pong
// Fill in your header comment here.
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import javax.swing.JFrame;

class pong extends JComponent {

    // Initial settings for the game, ball starts in middle.
    int ballX = 250, ballY = 220, ballVX = 3, ballVY = 2;
    int greenY = 200, magY = 200, greenHeight = 75, magHeight = 75;
    int greenWin = 0, magWin = 0;
    boolean greenWon = false;
    boolean magentaWon = false;
    int greenScore = 0;
    int magentaScore = 0;
    public boolean gameStarted = false;
    int i; // Chris Var

    /**
     * * Please fill in this method. **
     */
    public void update(boolean[] keyPressed) {
        if (keyPressed[4] != false) {
            ballX = ballVX + ballX;
            ballY = ballVY + ballY;
            // System.out.println(ballX +"   "+ ballY);
            System.out.println(greenY + "   " + magY);
            if (((ballY - 75) <= magY) && (ballY >= magY) && ballX == 469)//|| magY <= ballY + 34) {
            {
                ballVX = -ballVX;
            }
            if (((ballY - 75) <= greenY) && (ballY >= greenY) && ballX == 25)//|| magY <= ballY + 34) {
            {
                ballVX = -ballVX;
            }
            if (ballX >= 490) {

                reset('g');
            }
            if (ballX <= 20) {
                magentaWon = true;
                reset('m');
            }
            if (ballY <= 0) {
                ballVY = -ballVY;
            }
            if (ballY >= 500) {
                ballVY = -ballVY;
            }
            if (magY <= 0) {
                magY = 0;
            }
            if (magY >= 440) {
                magY = 440;
            }
            if (greenY <= 0) {
                greenY = 0;
            }
            if (greenY >= 440) {
                greenY = 440;
            }

        }
        //  if (magY <= ballY + 34) {
        //    System.out.println(i + " Rub");
        //    i += 1;
        //   }

        //    if (ballX % 100 != 0)  {
        // System.out.println("ballX ballY ballVX ballVY greenY magY greenHeight magHeight greenWin magWin greenWon magentaWon greenScore magentaScore gameStarted ");
        //        System.out.println(" _ " +ballX+ " _ " +ballY+ " _ " +ballVX+ " _ " +ballVY+ " _ " +greenY+ " _ " +magY+ " _ " +greenHeight+ " _ " +magHeight+ " _ " +greenWin+ " _ " +magWin+ " _ " +greenWon+ " _ " +magentaWon+ " _ " +greenScore+ " _ " +magentaScore+ " _ " +gameStarted+ " _ " + " _ ");
        //   }      
        if (keyPressed[0] != false) {
            magY -= 4;
            gameStarted = true;
        }
        if (keyPressed[1] != false) {
            magY += 4;
        }
        if (keyPressed[2] != false) {
            greenY -= 4;
        }
        if (keyPressed[3] != false) {
            greenY += 4;
        }

        // If necessary, move the magenta paddle
        // If necessary, move the green paddle
        // Check if magenta won
        // Check if green won
        // Check if the ball hit a horizontal boundary, flipping direction if necessary.
        // Check if the ball hit one of the paddles, flipping direction if necessary.
    }

    // Just sets up the initial screen.
    public void draw(Graphics g) {
        //g.drawRect(ballX, ballY, 10, 10);
        g.drawRect(10, greenY, 10, greenHeight);
        g.drawRect(480, magY, 10, magHeight);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        g.setColor(Color.black);
        g.drawString("Current Score:", 100, 20);
        g.drawString("Green: " + greenScore, 250, 20);
        g.drawString("Magenta: " + magentaScore, 350, 20);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
        g.setColor(Color.cyan);
        g.fillOval(ballX, ballY, 10, 10);
        g.setColor(Color.green);
        g.fillRect(10, greenY, 10, 75);
        g.setColor(Color.magenta);
        g.fillRect(480, magY, 10, 75);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        if (greenWon) {
            g.setColor(Color.GREEN);
            g.drawString("Green won! Resetting...", 0, 60);

        } else if (magentaWon) {
            g.setColor(Color.MAGENTA);
            g.drawString("Magenta won! Resetting...", 0, 60);
        } else if (!gameStarted) {
            g.setColor(Color.WHITE);
            g.drawString("Get Ready & Press Space", 0, 60);
        }
    }

    // Returns true iff the ball collides with the paddle of the color indicated by
    // type, 'g' = green, 'm' = magenta.
    /**
     * * Fill this in **
     */
    public boolean collides(char type) {

        int xCoord;
        int yCoord;

        // Assign xCoord and yCoord to be the x and y coordinates of top part
        // of the paddle that will make contact with the ball first.
        // Checks to see if the ball occupies the space the paddle does.
        // Basically both the x of the ball and the y of the ball have to be
        // within a tolerance of the paddle position.
        // If we get here, no collision between ball and paddle.
        return false;
    }

    private void reset(char won) {
        ballX = 250;
        ballY = 250;
        if (won == 'g') {
            greenWon = true;
            greenScore += 1;
        } else if (won == 'm') {
            magentaWon = true;
            magentaScore += 1;
        }
        greenY = 200;
        magY = 200;
        this.repaint();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
        greenWon = false;
        magentaWon = false;
    }

    public void paintComponent(Graphics g) {
        this.draw(g);
    }
}

public class pongFramework {

    static pong student;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PONG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 540);
        student = new pong();

        frame.add(student);
        frame.addKeyListener(new KeyboardListener());
        frame.setResizable(false);
        frame.setVisible(true);
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
            if (e.getKeyCode() == 87) { // W key
                keyMap[2] = true;
            }
            if (e.getKeyCode() == 83) { // S key
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
            if (e.getKeyCode() == 87) { // W key
                keyMap[2] = false;
            }
            if (e.getKeyCode() == 83) { // S key
                keyMap[3] = false;
            }
        }

        public void keyTyped(KeyEvent e) {
        }
    }
}
