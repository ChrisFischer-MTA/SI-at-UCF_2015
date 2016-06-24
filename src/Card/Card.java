package Card;

// Arup Guha
// 6/6/2016
// Part of Solution for SI@UCF Program: High Card

import java.util.*;

public class Card {

	private char suit;
	private int kind;

	public Card(Random r) {
		int suitNum = r.nextInt(4);
		if (suitNum == 0)
			suit = 'C';
		else if (suitNum == 1)
			suit = 'D';
		else if (suitNum == 2)
			suit = 'H';
		else
			suit = 'S';
		kind = 1 + r.nextInt(13);
	}

	public Card(char mySuit, int myKind) {
		suit = mySuit;
		kind = myKind;
	}

	// Simple function that returns the String specified in the Sample Output.
	public String toString() {
		return ""+kind+suit;
	}

	// Returns true if this and other are identical cards.
	public boolean equals(Card other) {
		return this.suit == other.suit && this.kind == other.kind;
	}

	public boolean equalsForWar(Card other) {
		return this.kind == other.kind;
	}

	public boolean beats(Card other) {

		// First break ties by kind.
		if (this.kind > other.kind) return true;
		if (this.kind < other.kind) return false;

		// Then suit. A tie isn't a win...
		if (this.suit > other.suit) return true;
		return false;
	}
}