package javaclass;
import java.util.*;
public class MinimumDistance {
    public static void main(String[] args){
        // Declare variables & generate points with a proper offset
        Random rand = new Random();
        int i;
        double AX = 100 - rand.nextInt(200);
        double AY = 100 - rand.nextInt(200);    
        double BX = 100 - rand.nextInt(200);
        double BY = 100 - rand.nextInt(200);  
        double CX = 100 - rand.nextInt(200);
        double CY = 100 - rand.nextInt(200); 
        // Print out variables with proper syntax
        System.out.println("Point A ("+AX+", "+AX+")");
        System.out.println("Point B ("+BX+", "+BY+")");
        System.out.println("Point C ("+CX+", "+CY+")");
        //Determain which is the lowest point and then spit it out.
            if(Math.hypot(CX, CY) < Math.hypot(BX, BY) && (Math.hypot(CX, CY) < Math.hypot(AX, AY))){
                System.out.println("The smallest distance between any two points is "+Math.hypot(CX, CY));
            }
            else if(Math.hypot(BX, BY) < Math.hypot(AX, AY) && (Math.hypot(BX, BY) < Math.hypot(CX, CY))){
                System.out.println("The smallest distance between any two points is "+Math.hypot(BX, BY));
            }
            else {
                System.out.println("The smallest distance between any two points is "+Math.hypot(AX, AY));
    }
    }
}
