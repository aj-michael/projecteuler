package net.ajmichael.projecteuler.p054;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HandTests {
	
	@Test
	public void testTwoPairs() {
		List<Card> cards = Arrays.asList(
				Card.of("3S"),
				Card.of("3C"),
				Card.of("TH"),
				Card.of("6D"),
				Card.of("TC"));
		Hand hand = Hand.of(cards);
		assertTrue(hand.isTwoPairs());
	}
	
	@Test
	public void testOnePair() {
		List<Card> cards = Arrays.asList(
				Card.of("3S"),
				Card.of("3C"),
				Card.of("KH"),
				Card.of("6D"),
				Card.of("TC"));
		Hand hand = Hand.of(cards);
		assertTrue(hand.isOnePair());
	}

	@Test
	public void testThreeOfAKind() {
		List<Card> cards = Arrays.asList(
				Card.of("3S"),
				Card.of("5C"),
				Card.of("KH"),
				Card.of("KD"),
				Card.of("KC"));
		Hand hand = Hand.of(cards);
		assertTrue(hand.isThreeOfAKind());
	}

	@Test
	public void testStraight() {
		List<Card> cards = Arrays.asList(
				Card.of("3S"),
				Card.of("5C"),
				Card.of("4H"),
				Card.of("2D"),
				Card.of("6C"));
		Hand hand = Hand.of(cards);
		assertTrue(hand.isStraight());
	}
	
	@Test
	public void testFlush() {
		List<Card> cards = Arrays.asList(
				Card.of("3C"),
				Card.of("5C"),
				Card.of("TC"),
				Card.of("2C"),
				Card.of("3C"));
		Hand hand = Hand.of(cards);
		assertTrue(hand.isFlush());
	}
	
	@Test
	public void testFullHouse() {
		List<Card> cards = Arrays.asList(
				Card.of("3C"),
				Card.of("AD"),
				Card.of("3H"),
				Card.of("AS"),
				Card.of("AH"));
		Hand hand = Hand.of(cards);
		assertTrue(hand.isFullHouse());
	}
	
	@Test
	public void testFourOfAKind() {
		List<Card> cards = Arrays.asList(
				Card.of("3C"),
				Card.of("AD"),
				Card.of("3H"),
				Card.of("3D"),
				Card.of("3S"));
		Hand hand = Hand.of(cards);
		assertTrue(hand.isFourOfAKind());
	}
	
	@Test
	public void testStraightFlush() {
		List<Card> cards = Arrays.asList(
				Card.of("8H"),
				Card.of("TH"),
				Card.of("9H"),
				Card.of("7H"),
				Card.of("6H"));
		Hand hand = Hand.of(cards);
		assertTrue(hand.isStraightFlush());
	}
	
	@Test
	public void testRoyalFlush() {
		List<Card> cards = Arrays.asList(
				Card.of("TD"),
				Card.of("QD"),
				Card.of("KD"),
				Card.of("JD"),
				Card.of("AD"));
		Hand hand = Hand.of(cards);
		assertTrue(hand.isRoyalFlush());
	}
}
