/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 * 6/15/2016 // 3:46 (Revision 4)
 * @author Chris Fischer // SI @ UCF for HS.
 */
public class card{
    private char suit; //CDHS
    private int kind; //1-13
   // private int trashvar;        
    public card(Random r){
    int randvar = r.nextInt(4);
    switch(randvar){
        case 0:
            suit = 'C';
            break;
        case 1:
            suit = 'D';
            break;
        case 2:
            suit = 'H';
            break;
        case 3:
            suit = 'S';
            break;
        default:
            break;
    }
    kind = 1 + r.nextInt(13);
}
    public String toString(){
    String kand = "";
    char strang = this.suit;
    String actualstrang = " ";
    String rv = "";
    switch(strang){
        case 'C':
            actualstrang = "Clubs";
            break;
        case 'D':
            actualstrang = "Diamonds";
            break;
        case 'H':
            actualstrang = "Hearts";
            break;
        case 'S':
            actualstrang = "Spades";
            break;
        default:
            break;
    }
    switch(this.kind){
        case 11:
            kand = "Jack";
            break;
        case 12:
            kand = "Queen";
            break;
        case 13:
            kand = "King";
            break;
        default:
            break;
    }
    if(this.kind < 11)
        rv = actualstrang + " of " + this.kind;
    else
        rv = actualstrang + " of " + kand;
    return rv;
            }
    public boolean equals(card other){
    boolean isEqual = false;
        if(this.kind == other.kind && this.suit == other.suit){
        isEqual = true;}
    return isEqual;
    }
    public boolean beats(card other){
    boolean beats;
        if(this.kind > other.kind){
        beats = true;
        }
        else if(this.kind < other.kind){
        beats = false;
        }
        else
            if(this.suit > other.suit){
                beats = true;
            }
            else if(this.suit < other.suit){
                beats = false;
            }
            else{
                beats = false;
            }
        return beats;
        }           
    public static void main(String[] args){
    card Caden1 = new card(new Random());
    card Caden2 = new card(new Random());
    card Christopher1 = new card(new Random());
    card Christopher2 = new card(new Random());
    System.out.println("Player 1, your cards are " + Caden1.toString() + " and " + Caden2.toString());
    System.out.println("Player 2, your cards are " + Christopher1.toString() + " and " + Christopher2.toString());
    if(Caden1.beats(Caden2)){
        if(Christopher1.beats(Christopher2)){
            if(Caden1.beats(Christopher1)){
                System.out.println("Player 1, you win!");
            }
            else{
                System.out.println("Player 2, you win!");}
        }
        else{
            if(Caden1.beats(Christopher2))
                System.out.println("Player 1, you win!");
            else
                System.out.println("Player 2, you win!");}}
    else
        if(Christopher1.beats(Christopher2)){
            if(Caden2.beats(Christopher1)){
                System.out.println("Player 1, you win!");
            }
            else{
                System.out.println("Player 2, you win!");}
        }
        else
            if(Caden2.beats(Christopher2))
                System.out.println("Player 1, you win!");
            else
                System.out.println("Player 2, you win!");}
}
