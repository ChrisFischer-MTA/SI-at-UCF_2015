/**
 *
 * @author Chris
 */
import java.util.*;
public class RNG {
   public static void Question1(String[] args){
   int Number;
   Random rand = new Random();
   for(int i = 0; i < 100; i++){
       Number = 10 + rand.nextInt(90);
       System.out.println(Number);
   }
   }
   public static void main(String[] args){
   int tcount;
   float  UINPUT;
   float condition;
   float passrate=0;
   Scanner stdin = new Scanner(System.in);
   Random rand = new Random();
   System.out.println("What percentage of runs should pass?");
   UINPUT = stdin.nextFloat() / 100;
   System.out.println("How many trials should I run?");
   tcount = stdin.nextInt();
   for(int i = 0; i < tcount; i++){
       condition = rand.nextInt();
       if(condition <= UINPUT){
           System.out.println("SUCCESS");
           passrate = passrate + 1;
       }
       else{
           System.out.println("FAIL");
       }
       
   }
   System.out.println(passrate / tcount);
   }
}
