package net.ajmichael.projecteuler.p054;

public class Card implements Comparable<Card> {

	final Suit suit;
	final int value;
	
	private Card(Suit suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	public static Card of(String inputChars) {
		String suit = inputChars.substring(1, 2);
		char valueChar = inputChars.charAt(0);
		int value = -1;
		if (Character.isDigit(valueChar)) {
			value = Character.getNumericValue(valueChar);
		} else if (valueChar == 'A') {
			value = 14;
		} else if (valueChar == 'T') {
			value = 10;
		} else if (valueChar == 'J') {
			value = 11;
		} else if (valueChar == 'Q') {
			value = 12;
		} else if (valueChar == 'K') {
			value = 13;
		}
		return new Card(Suit.valueOf(suit), value);
	}

	@Override
	public int compareTo(Card that) {
		return this.value - that.value;
	}
	
	@Override
	public String toString() {
		return "Card("+value+","+suit+")";
	}

}