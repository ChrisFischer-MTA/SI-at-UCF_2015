package RainPack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

class StudentWorkSolution {

    int positionX, positionY, velocityX, velocityY, accerationX, accerationY;
    int sizeX, sizeY;
    Color characterColor, backgroundColor;
    ArrayList<raindrop> rain;

    public void initialize() {
        rain = new ArrayList<raindrop>();

    }

    public void update(boolean[] keyPressed) {
        if (true) {
            for (int i = 0; i < 4; i++) {
                rain.add(new raindrop());
            }
        }
        for(int i = rain.size() -1; i >= 0; i--){
            rain.get(i).posupdate(rain);
        }
    }

    public void draw(Graphics g) {
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, 500, 500);
        g.setColor(this.characterColor);

        for (int i = 0; i < rain.size(); i++) {
            rain.get(i).draw(g);
        } 
    }

    public StudentWorkSolution() {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
        accerationX = 0;
        accerationY = 0;
        sizeX = 2;
        sizeY = 2;
        characterColor = Color.black;
        backgroundColor = Color.white;
    }

}

public class RainSim {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rainstuff");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        ContentViewSolution view = new ContentViewSolution();
        frame.add(view);
        frame.addKeyListener(view);
        frame.setResizable(false);
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.keyMap[0] = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.keyMap[0] = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void paintComponent(Graphics g) {
        student.draw(g);
    }

}

class raindrop {

    final public int sy = 3, sx = 3;
    int x, y, vx, vy;

    public raindrop() {
        Random Random = new Random();
        x = Random.nextInt(498);
        y = 0;
        vy = 1;
        vx = 0;
    }

    public void posupdate(ArrayList<raindrop> name) {
        x = x + vx;
        y = y + vy;
        if(x > 500)
            x = 0;
    }

    public void draw(Graphics g) {
        g.drawRect(x, y, sy, sy);
    }
}
