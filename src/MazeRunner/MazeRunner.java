/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeRunner;

import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Seminar
 */
public class MazeRunner {

    public static void main(String[] args) {
        int startr = 0;
        int startc = 0;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("maze.png"));
            System.out.println("Maze found.");
        } catch (IOException e) {
            System.out.println("I can't find shit.");
            System.out.println(e);
        }
        System.out.println("One.");
        //System.out.println(img.getRGB(214,6));
        //int[][] array = new int[img.getHeight()][img.getWidth()];
        char[][] array = new char[img.getHeight()][img.getWidth()];
        FastRGB maze = new FastRGB(img);
        System.out.println("Two.");
        System.out.println(img.getHeight() + " - " + img.getWidth());
        for (int i = 0; i < img.getHeight(); i++) {
            //System.out.println("i -" + i);
            for (int j = 0; j < img.getWidth(); j++) {
              //  System.out.println("j -" + j);
                if (img.getRGB(i, j) == -1) {
                    array[i][j] = '.';
                }
                if (img.getRGB(i, j) == -6075996) {
                    array[i][j] = 'E';
                }
                if (img.getRGB(j, j) == -1237980) {
                    array[i][j] = 'S';
                    startr = i;
                    startc = j;
                    System.out.print("Start found!");
                } else {
                    array[i][j] = 'X';
                }/*
                else{
                    array[i][j] = img.getRGB(i, j);
                }
                 */
            }
        }

        System.out.println(array[347][493]);
        DFS meh = new DFS(array, startr, startc);

    }

}
