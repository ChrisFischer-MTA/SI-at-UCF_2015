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
public class Recursion {

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        digSum(stdin.nextInt());
    
    }
    static int digSum(int n){
        if(n==0){
            return 0;
        }
    int ans = n % 10 + digSum(n/10);
    return ans < 10 ? ans : digSum(ans);
    }
}
