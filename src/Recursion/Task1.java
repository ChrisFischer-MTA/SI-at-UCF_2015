/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class Task1 {

    public static void main(String[] argsv) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter an integer.");
        System.out.println(sumDigits(stdin.nextInt()));

    }

    public static int sumDigits(int n) {
        if (n % 10 == 0) {
            return n;
        }
        int digit = n%10;
        int sum = digit + sumDigits(n/10);
        return sum;
        
    }
}