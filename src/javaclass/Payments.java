
import java.util.*;

// Christopher Fischer -  SI @ UCF - 6/14/16
public class Payments {

    public static void main(String[] args) {
        int oval;
        float ival;
        int mpay;
        int month = 0;
        float bal;
        int l = 0;

        Scanner stdin = new Scanner(System.in);
        System.out.println("What is the original value of the car you are buying?");
        oval = stdin.nextInt();
        System.out.println("What is the interest rate of the loan, in percent?");
        ival = (stdin.nextInt() / 12);
        System.out.println("What is the monthly payment?");
        mpay = stdin.nextInt();
        bal = oval;
        System.out.println("Month		Payment	Amount Owed");
        if (mpay > (bal * (ival / 100))) {
            while (bal >= mpay) {

                month = month + 1;
                System.out.println(ival);
                bal = (((bal * (ival / 100)) + bal) - mpay);
                l += mpay;
                System.out.println(month + "  " + mpay + "    " + "     " + bal);

            }
            while (bal < mpay && bal > 0) {
                month = month + 1;
                bal = (((bal * (ival / 100)) + bal));
                //mpay = bal
                System.out.println(month + "  " + bal + "    " + "0");
                bal = 0;
            }
        } else {
            System.out.println("Your montly payment will never be able to pay off your loan");
        }

        System.out.println(l);
        
    }

}
