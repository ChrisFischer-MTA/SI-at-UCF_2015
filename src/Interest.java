package javaclass;
import java.util.*;
public class Interest {
    public static void main(String[] args)
  {
      Scanner stdin = new Scanner(System.in); // Creation of the scanner object
      float p; // Amount of money initally
      double r; // Rate of increase
      int t; // time in years :)
      double finalamount; // final amount of money
      System.out.println("Enter the amount of money invested.");
      p = stdin.nextFloat(); // gets the inital principle
      System.out.println("Enter the interest rate as a percentage.");
      r = (stdin.nextFloat() / 100);
      System.out.println("How many years will your money be invested?");
      t = stdin.nextInt();// User input gained :)
      finalamount = p*Math.pow(Math.E, r*t);
      System.out.println("You will have $"+finalamount+" after "+t+"years.");
  }
}
