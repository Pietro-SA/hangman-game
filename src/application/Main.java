package application;

import java.util.Scanner;

import entities.Hangman;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Type the word to be guessed: ");
		String word = sc.next();
		Hangman game = new Hangman(word);

		while (game.getLives() > -1) {
			if (!game.endGame()) {
				game.printClue();
				System.out.println("");
				char letter = sc.next().charAt(0);
				game.checkLetter(letter);	
			} else {
				System.out.println("Congratulations, you guessed it! The word was: " + word);
				break;
			}
		}
		sc.close();
	}
}
