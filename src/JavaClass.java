package javaclass;
import java.util.*;

public class JavaClass
{
  public static void main(String[] args)
  {
    // When variables are born :P
    int rooml;
    int roomw;
    int roomt;
    int cupr;
    int cuph;
    double v;
    double pi = 3.1415926535897931;
    
    System.out.println("What is the length of Ashley's room (in meters)?");
    Scanner stdin = new Scanner(System.in);
    rooml = stdin.nextInt();
    System.out.println("What is the width of Ashley's room (in meters)?");
    roomw = stdin.nextInt();
    System.out.println("Enter the radius of the cups used, in centimeters.");
    cupr = stdin.nextInt();
    System.out.println("Enter the height of the cups used, in centimeters?");
    cuph = stdin.nextInt();
    v = pi*(cupr^2)*cuph;
    roomt = rooml * roomw;
    System.out.println(((rooml*100)/(2*cupr))*(roomw*100)/(2*cupr));
    
    
    
    
    
  }
    // When variables are killed
  }
