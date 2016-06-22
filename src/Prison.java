
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Christopher Fischer
// Created as a practice for SI @ UCF;
// 6/17/16
// All code is original
public class Prison {

    int temporaryNumber;
    int totaldays;
    ArrayList masterList;
    public ArrayList prisonerDatabase;
    private int days;
    private int pNumber;
    private boolean misconduct;
    private String cell;
    //private String name; Prisoners don't deserve names!

    public Prison() {
        // Generate our Prisoner Number
        Random rnd = new Random();
        temporaryNumber = rnd.nextInt(10000);
        //while (prisonerDatabase.contains(temporaryNumber)) {
        //    temporaryNumber = rnd.nextInt(10000);
       // }
        // Generate our Prisoner's cell (having multiple in the same cell is permitted.
        pNumber = temporaryNumber;
        prisonerDatabase.add(pNumber);
        days = rnd.nextInt(10000);
        switch (rnd.nextInt(5)) {
            case 0:
                cell.concat("A-");
                break;
            case 1:
                cell.concat("B-");
                break;
            case 2:
                cell.concat("C-");
                break;
            case 3:
                cell.concat("D-");
                break;
            case 4:
                cell.concat("ProtSec-");
                break;
        }
        cell.concat("" + rnd.nextInt(300));
        // Generates if misconduct is true.
        this.misconduct = rnd.nextBoolean();
        masterList.add(this);
        prisonerInfo();
    }

    public void prisonerInfo() {
        System.out.println("Printing information for prisoner number - " + this.pNumber);
        System.out.println("Prisoner's inital sentence: " + this.days);
        if (days < totaldays) {
            System.out.println("Prisoner's remaining sentence " + this.totaldays);
        } else if (days >= totaldays) {
            System.out.println("Prisoner has been out of our custody for " + (this.totaldays - this.days) + " days");
        }
        System.out.println("Prisoner can be found in cell -" + this.cell);
        System.out.println("It is infact " + this.misconduct + " that this prisoner has commited some form of policy violation");

    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("How many days do you wish to run your prison?");
        int daysRan = stdin.nextInt();
        Prison Chris = new Prison();
        Prison Bob = new Prison();
        Prison Snitch = new Prison();
        Prison William = new Prison();
        Prison Terry = new Prison();
        Prison Marry = new Prison();

            }
        }
  
