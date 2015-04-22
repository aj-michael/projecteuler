package net.ajmichael.projecteuler.p054;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {
	
	private final List<Card> cards;
	private int cachedScore = -1; 
	
	private Hand(List<Card> cards) {
		this.cards = cards;
	}
	
	public static Hand of(List<Card> cards) {
		Collections.sort(cards);
		return new Hand(cards);
	}
	
	public int getCachedScore() {
		if (cachedScore == -1) {
			cachedScore = getScore();
		}
		return cachedScore;
	}

	int getScore() {
		if (isRoyalFlush()) {
			return 100;
		} else if (isStraightFlush()) {
			return 99;
		} else if (isFourOfAKind()) {
			return 98;
		} else if (isFullHouse()) {
			return 97;
		} else if (isFlush()) {
			return 96;
		} else if (isStraight()) {
			return 95;
		} else if (isThreeOfAKind()) {
			return 94;
		} else if (isTwoPairs()) {
			return 93;
		} else if (isOnePair()) {
			return 92;
		} else {
			return getHighestCard();
		}
	}
	
	int onePairValue() {
		for (Map.Entry<Integer, List<Integer>> e : cards.stream().map(o -> o.value).collect(Collectors.groupingBy(o -> o)).entrySet()) {
			if (e.getValue().size() == 2) return e.getKey();
		}
		throw new NullPointerException();
	}
	
	boolean isOnePair() {
		return cards.stream().map(o -> o.value).collect(Collectors.groupingBy(o -> o)).size() < 5;
	}

	boolean isTwoPairs() {
		List<Integer> counts = cards.stream().map(o -> o.value).collect(Collectors.groupingBy(o -> o)).values().stream().map(o -> o.size()).collect(Collectors.toList());
		return counts.contains(2) && counts.contains(1) && counts.size() == 3;
	}

	boolean isThreeOfAKind() {
		return Collections.max(cards.stream().map(o -> o.value).collect(Collectors.groupingBy(o -> o)).values().stream().map(l -> l.size()).collect(Collectors.toList())) == 3;
	}

	boolean isStraight() {
		int start = cards.get(0).value;
		return cards.get(0).value == start
			&& cards.get(1).value == start + 1
			&& cards.get(2).value == start + 2
			&& cards.get(3).value == start + 3
			&& cards.get(4).value == start + 4;
	}

	boolean isFlush() {
		Suit s = cards.get(0).suit;
		for (Card c : cards) {
			if (c.suit != s) {
				return false;
			}
		}
		return true;
	}

	boolean isFullHouse() {
		List<Integer> counts = cards.stream().map(o -> o.value).collect(Collectors.groupingBy(o -> o)).values().stream().map(o -> o.size()).collect(Collectors.toList());
		return counts.contains(2) && counts.contains(3) && counts.size() == 2;
	}

	boolean isFourOfAKind() {
		List<Integer> counts = cards.stream().map(o -> o.value).collect(Collectors.groupingBy(o -> o)).values().stream().map(o -> o.size()).collect(Collectors.toList());
		return counts.contains(4) && counts.contains(1) && counts.size() == 2;
	}

	boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	boolean isRoyalFlush() {
		return cards.get(0).value == 10 && isStraightFlush();
	}
	
	int highestValue() {
		return cards.get(4).value;
	}

	@Override
	public int compareTo(Hand that) {
		if (this.isRoyalFlush() && that.isRoyalFlush()) {
			throw new RuntimeException("A");
		} else if (this.isRoyalFlush()) {
			return 1;
		} else if (that.isRoyalFlush()) {
			return -1;
		} else if (this.isStraightFlush() && that.isStraightFlush()) {
			throw new RuntimeException("B");
		} else if (this.isStraightFlush()) {
			return 1;
		} else if (that.isStraightFlush()) {
			return -1;
		} else if (this.isFourOfAKind() && that.isFourOfAKind()) {
			throw new RuntimeException("C");
		} else if (this.isFourOfAKind()) {
			return 1;
		} else if (that.isFourOfAKind()) {
			return -1;
		} else if (this.isFullHouse() && that.isFullHouse()) {
			throw new RuntimeException("D");
		} else if (this.isFullHouse()) {
			return 1;
		} else if (that.isFullHouse()) {
			return -1;
		} else if (this.isFlush() && that.isFlush()) {
			throw new RuntimeException("E");
		} else if (this.isFlush()) {
			return 1;
		} else if (that.isFlush()) {
			return -1;
		} else if (this.isStraight() && that.isStraight()) {
			throw new RuntimeException("F");
		} else if (this.isStraight()) {
			return 1;
		} else if (that.isStraight()) {
			return -1;
		} else if (this.isThreeOfAKind() && that.isThreeOfAKind()) {
			throw new RuntimeException("G");
		} else if (this.isThreeOfAKind()) {
			return 1;
		} else if (that.isThreeOfAKind()) {
			return -1;
		} else if (this.isTwoPairs() && that.isTwoPairs()) {
			throw new RuntimeException("H");
		} else if (this.isTwoPairs()) {
			return 1;
		} else if (that.isTwoPairs()) {
			return -1;
		} else if (this.isOnePair() && that.isOnePair()) {
			if (this.onePairValue() == that.onePairValue()) {
				return this.getHighestCard() - that.getHighestCard();
			} else {
				return this.onePairValue() - that.onePairValue();
			}
		} else if (this.isOnePair()) {
			return 1;
		} else if (that.isOnePair()) {
			return -1;
		} else if (this.cards.get(4).value != that.cards.get(4).value) {
			return this.cards.get(4).value - that.cards.get(4).value;
		} else if (this.cards.get(3).value != that.cards.get(3).value) {
			return this.cards.get(3).value - that.cards.get(3).value;
		} else if (this.cards.get(2).value != that.cards.get(2).value) {
			return this.cards.get(2).value - that.cards.get(2).value;
		} else if (this.cards.get(1).value != that.cards.get(1).value) {
			//return this.cards.get(1).value - that.cards.get(1).value;
			throw new RuntimeException("Y");
		} else {
			throw new RuntimeException("Z");
			//return this.cards.get(0).value - that.cards.get(0).value;
		}
	}
	
	@Override
	public String toString() {
		return "Hand["+cards+"]";
	}
	
	int getHighestCard() {
		return cards.get(4).value;
	}
	
}