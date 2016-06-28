/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class Task2 {

    public static void main(String[] argv) {
        Scanner stdin = new Scanner(System.in);
        stars(stdin.nextInt(), stdin.nextInt());
        System.out.println("");
    }

    public static int stars(int n, int spaces) {
        int e = (n * 2) + 1;
        
        if (n == 0) {
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            System.out.print("*");
            return n;
        }

        System.out.println("");
        //System.out.print((e - 1) / 2);
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < e; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
       // System.out.print((e - 1) / 2);
        System.out.println("");
        stars(n - 1, spaces+1);
        return n - 1;
    }

}
