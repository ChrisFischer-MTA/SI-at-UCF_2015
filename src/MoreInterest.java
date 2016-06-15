package javaclass;

import java.util.*;
public class MoreInterest {
    public static void main(String[] args)
  {
  Scanner stdin = new Scanner(System.in);
  double P;
  double E;
  double R;
  double T;
  double Time;
  System.out.println("Enter the amount of money invested.");
  P = stdin.nextDouble(); // gets the inital principle
  System.out.println("Enter the interest rate as a percentage.");
  R = (stdin.nextDouble() / 100);
  System.out.println("How much money do you want to accrue total?");
  T = (stdin.nextDouble());
  Time = (Math.log(T/P))/R;
  System.out.println("It will take you "+Time+" years to acure $"+T);
  }
}
