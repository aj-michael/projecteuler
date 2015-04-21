package net.ajmichael.projecteuler.p054;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) throws IOException {
		//String filename = "p054_poker.txt";
		String filename = "shit.txt";
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = null;
		int p1wins = 0;
		int p2wins = 0;
		while ((line = br.readLine()) != null) {
			System.out.println("Now processing\t" + line);
			String[] tokens = line.split(" ");
			Hand p1 = Hand.of(Arrays.stream(tokens).map(o -> Card.of(o)).limit(5).collect(toList()));
			Hand p2 = Hand.of(Arrays.stream(tokens).map(o -> Card.of(o)).skip(5).limit(5).collect(toList()));
			//System.out.println(p1.getCachedScore());
			//System.out.println(p2.getCachedScore());
			if (p1.compareTo(p2) == 0) System.out.println("WTF");
			System.out.println(p1.compareTo(p2) > 0);
			p1wins += p1.compareTo(p2) > 0 ? 1 : 0;
			p2wins += p2.compareTo(p1) > 0 ? 1 : 0;
		}
		br.close();
		System.out.println("Player 1 won " + p1wins + " hands.");
		System.out.println("Player 2 won " + p2wins + " hands.");
	}
	
}
