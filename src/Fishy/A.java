package Fishy;


import java.util.Random;

public class A {

    final static public int[] speeds = {20, 30, 30, 50, 50, 50, 50, 75, 75, 100};
    private int accX, posX, posY, size, speed;

    Random rand = new Random();

    public A() {
        this.speed = speeds[rand.nextInt(speeds.length)];
        switch (rand.nextInt(2) + 1) {
            case 1:
                this.posX = 0;
                break;
            case 2:
                this.posX = 750;
                accX = -accX;
                break;
        }
        size = 200 + rand.nextInt(600);
        posY = -rand.nextInt(750);
    }
}
