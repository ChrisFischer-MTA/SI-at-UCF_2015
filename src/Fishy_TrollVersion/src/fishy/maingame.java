package Fishy;

// Framework for SI@UCF Program: Pong
// Fill in your header comment here.
import static Fishy.maingame.student;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

class StudentWorkSolution extends JComponent {

    int frame = 0;
    int i = 0;
    public int eyePosX = 3, eyePosY = 1;
    public fish[] fishyList = new fish[100];
    public fish playerFish = new fish(true);

    public StudentWorkSolution() {
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Fishy is a game where you avoid bigger fishes and eat smaller fishes by bumping into them.\n Use arrow keys to move, and press OK once you're ready.", "Good luck!", dialogButton);
        Sound sound = new Sound();
        sound.music();
        for (int i = 0; i < fishyList.length; i++) {
            fishyList[i] = new fish();
            fishyList[i].getSpeed();
            for (int j = 0; j < 500; j++) {
                fishyList[i].delete();
            }
        }
    }

    public void update(boolean[] keyMap) {

        //Quick Reference Sheet:
        // up key      keyMap[0] = true;
        // down key keyMap[1] = true;
        // right  keyMap[2] = true;
        // left key keyMap[3] = true;
        //    System.out.println("Before if"+i);
        if (i >= fishyList.length - 1) {
            // System.out.println("Resetting list.");
            i = 0;
        }

        if (frame >= 20) {
            i++;
          // System.out.println("Executing.");
            fishyList[i] = new fish();
            fishyList[i].getSpeed();
            frame = 0;
        }

        frame++;
        for (int i = 0; i < fishyList.length; i++) {
            fishyList[i].upX();
        }
        if (keyMap[2] == true) {
            eyePosX = playerFish.sizeX - playerFish.sizeX / 3;
        }
        if (keyMap[3] == true) {
            eyePosX = 2;
        }
        playerFish.update(keyMap);
        for (int i = 0; i < fishyList.length; i++) {
            // START COLLISON DETECT -- ALL CODE FOUND BELOW THIS STATEMENT IS AIDENS FAULT;
            if (playerFish.getX() + playerFish.sizeX > fishyList[i].getX() && playerFish.getX() < fishyList[i].getX() + fishyList[i].getSizeX() && playerFish.getY() + playerFish.sizeY > fishyList[i].getY() && playerFish.getY() < fishyList[i].getY() + fishyList[i].getSizeY()) {
                if (playerFish.sizeX >= 460) {
                    int dialogButton = JOptionPane.DEFAULT_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "You have won, with a final score of: " + (((playerFish.sizeX * 10) - 400)) + "", "Gratz hommie g now go outsidez and fuck a bitch.", dialogButton);
                    System.exit(1);

                }

                if (fishyList[i].getSizeY() <= playerFish.sizeY) {
            //        System.out.println("Frack");

                    fishyList[i].sizeX = 0;
                    playerFish.sizeX += (fishyList[i].getSizeX() / 10);
                    playerFish.sizeY += (fishyList[i].getSizeY() / 10);
                    for (int j = 0; j < 5000; j++) {
                        fishyList[i].upX();
                    }
                } else if (fishyList[i].getSizeY() > playerFish.sizeY) {
                    System.out.println(playerFish.getSizeY() + " " + fishyList[i].getSizeY());
                    System.out.println(playerFish.sizeX + playerFish.sizeY - 50);
                    for (int y = 0; y <= 50; y++) {
                        playerFish.upX();
                    //    System.out.println("Coverup!");
                    }
                    int dialogButton = JOptionPane.DEFAULT_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "You have died, with a final score of: " + (((playerFish.sizeX * 10) - 400)) + "", "RIP", dialogButton);
                    System.exit(1);

                }

            }
            // STOP COLLISON DETECT -- ALL CODE FOUND ABOVE THIS STATEMENT IS AIDENS FAULT;
        }
    }

    public void draw(Graphics g) {
      //  System.out.println("Hello.");
        try {
            g.drawImage(ImageIO.read(new File("bround.jpg")), 0, 0, this);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        //System.out.println("Goodbye.");
        int score = playerFish.sizeX * 10;
        g.setColor(new Color(100, 100, 255));
        // g.fillRect(0, 0, 750, 750);
        g.setColor(Color.green);
        g.fillRect(50, 600, 20, 150);
        g.fillRect(90, 640, 15, 150);
        g.fillRect(550, 570, 20, 200);
        g.fillRect(490, 660, 14, 200);
        g.fillRect(520, 540, 17, 200);
        g.setColor(new Color(0, 89, 63));
        g.fillRect(0, 700, 750, 100);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS", 72, 30));

        g.drawString("Score: " + (score - 400), 300, 40);
        Random rand = new Random();
        int red = rand.nextInt(256);
        int grn = rand.nextInt(256);
        int blu = rand.nextInt(256);
        for (int i = 0; i < fishyList.length; i++) {
            g.setColor(fishyList[i].getColor());
            g.fillOval(fishyList[i].getX(), fishyList[i].getY(), fishyList[i].getSizeX(), fishyList[i].getSizeY());
            g.setColor(Color.BLACK);
            if (!fishyList[i].isEye()) {
                g.fillOval((fishyList[i]).getX() + fishyList[i].getSizeX() - fishyList[i].getSizeX() / 3, fishyList[i].getY(), fishyList[i].getSizeX() / 4, fishyList[i].getSizeX() / 4);

            } else {
                g.fillOval((fishyList[i]).getX() + fishyList[i].getSizeX() / 10, fishyList[i].getY() + fishyList[i].getSizeY() / 10, (fishyList[i].getSizeX() / 4), fishyList[i].getSizeX() / 4);
            }
        }

        g.setColor(Color.MAGENTA);
        g.fillOval(playerFish.getX(), playerFish.getY(), playerFish.sizeX, playerFish.sizeY);
        g.setColor(Color.BLACK);
        g.fillOval(playerFish.getX() + eyePosX, playerFish.getY() + eyePosY, playerFish.sizeX / 3, playerFish.sizeX / 3);

    }

    public boolean collides(char type) {
        return false;
    }

    public void paintComponent(Graphics g) {
        this.draw(g);
    }
}

public class maingame {

    static StudentWorkSolution student;

    public static void main(String[] args) {
        gameDriver();
        //student.Wrekt();
    }

    public static void gameDriver() {
        JFrame frame = new JFrame("Fishy :)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        student = new StudentWorkSolution();
        frame.add(student);
        frame.addKeyListener(new KeyboardListener());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    static class KeyboardListener implements Runnable, KeyListener {

        boolean[] keyMap = new boolean[6];

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
            if (e.getKeyCode() == 37) { // S key
                keyMap[3] = false;
            }
            if (e.getKeyCode() == 32) { // Space bar
                keyMap[4] = false;
            }
        }

        public void keyTyped(KeyEvent e) {

        }
    }
}

class fish {

    final static public int[] speeds = {3, 3, 3, 4, 4, 4, 4, 8, 9, 10};
    //final static public int[] speeds = {10, 10, 10, 10, 10, 1999999991, 1999999991, 1999999991, 1999999991, 1999999991};
    private int posX, posY, size, speed, eyePosX, eyePosY;
    private double volX, volY;
    private boolean player;
    private Color color;
    public int frame;
    int sizeX;
    int sizeY;
    public int score = sizeX * 10;
    Random rand = new Random();
    private boolean eye;

 
    public fish() {

        this.volX = speeds[rand.nextInt(speeds.length)];
        switch (rand.nextInt(2) + 1) {
            case 1:
                this.posX = -400 - sizeX;
                this.eye = false;
                break;
            case 2:
                this.posX = 800 + sizeX;
                volX = -volX;
                this.eye = true;
                break;
        }
        size = rand.nextInt(450) + 10;
        posY = rand.nextInt(750);

        switch (rand.nextInt(4)) {
            case 1:
                this.color = Color.RED;
                break;
            case 2:
                this.color = Color.green;
                break;
            case 3:
                this.color = Color.blue;
                break;
            default:
                this.color = Color.orange;
                break;
        }
    }

    public fish(boolean player) {
        // Constructor for player fish! :)
        posX = 375;
        posY = 375;
        volX = 0;
        volY = 0;
        sizeX = 40;
        sizeY = 20;
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
        //System.out.println(this.speed);
    }

    public int getX() {
        return this.posX;
    }

    public int getY() {
        return this.posY;
    }

    public void delete() {
        this.posX = 90000;
    }

    public void upX() {
        this.posX = posX + (int) volX;
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

    public boolean isEye() {
        return this.eye;
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

        this.posX += (int) volX;
        this.posY += (int) volY;
        /*  if((frame >= 60) || Math.abs(volX) > 10 || Math.abs(volY) > 10){
            System.out.println("Resetting"+volX+"    "+volY);
           
            frame = 0;
        }*/

        volX *= .97;
        volY *= .97;
        if (this.posX < -sizeX) {
            posX = 750 + sizeX;
        }
        if (this.posX > 750 + sizeX) {
            posX = -sizeX;
        }
        if (this.posY > 750 + sizeY) {
            posY = -sizeY;
        }
        if (this.posY < -sizeY) {
            posY = 750 + sizeY;
        }
        frame++;
    }

    public Color getColor() {
        return this.color;
    }

    public void sizeUp(int ret) {

    }
}

class Sound {

    public void music() {

        AudioStream backgroundMusic;
        AudioData musicData;
        AudioPlayer musicPlayer = AudioPlayer.player;
        ContinuousAudioDataStream loop = null;
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        try {
            InputStream test = new FileInputStream("music.wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);

        } catch (FileNotFoundException e) {
            System.out.print(e.toString());
        } catch (IOException error) {
            System.out.print(error.toString());
        }
        MGP.start(loop);

    }
}

