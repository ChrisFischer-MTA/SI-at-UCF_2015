/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPractice;

import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class Recursion2 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        tri(stdin.nextInt(), stdin.nextInt());
    }

    static void tri(int n, int spaces) {
        System.out.println("");
        if(n==0)
            return;
        for (int i = 0; i < spaces + 1; i++) {
            System.out.print(" ");
        }
        tri(n-1, spaces+1);
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        for(int i =0; i < 2*n-1; i++){
            System.out.print("*");
        }
        System.out.println("");
    }
}
