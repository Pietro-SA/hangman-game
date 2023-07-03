package entities;

public class Hangman {

	private int lives = 5;
	private char[] word;
	private char[] guessing;
	private boolean isCoincidence;
	private int charsLeft;
	
	/*
	 * Constructor for Hangman class. It also builds the 'word' char array, which contains all the letters that have to be guessed.
	 */
	
	public Hangman(String word) {
		this.word = new char[word.length()];
		guessing = new char[word.length()];
		charsLeft = word.length();
		for (int i = 0; i < word.length(); i++) {
			this.word[i] = word.charAt(i);
			guessing[i] = ' ';
		}
	}
	
	public Integer getLives() {
		return lives;
	}
	
	public char[] getWord() {
		return word;
	}
	
	/*
	 * NEW SYSTEM: Uses a 'for' loop to go through the 'word' array and look for any coincidences with the provided letter/char.
	 * If there aren't any coincidences, subtract 'lives' by 1 and prints the remaining lives. In case the value is lower than 0, print "you lost!", but always calls 'printHangman()' method.
	 */
	
	public void checkLetter(char letter) {
		isCoincidence = false;
		for (int i = 0; i < word.length; i++) {
			if (guessing[i] == letter) {
				System.out.println("Please choose a different letter.");
				isCoincidence = true;
				break;
			} else if (word[i] == letter) {
				isCoincidence = true;
				guessing[i] = letter;
				charsLeft--;
			}
		}
		if (!isCoincidence) {
			if (lives > 0) {
				lives--;
				System.out.println("Wrong answer! you have " + lives + " extra attempts left.");
			} else {
				System.out.println("Game over!");
			}
			printHangman();
			
		}
	}
	
	/*
	 * DEPRECATED: Old letter verification system
	 * It can only check one char at a time!
	 
	public void checkLetter(char letter) {
		if (word[currentPosition] == letter ) {
			currentPosition++;
			printHangman();
		} else {
			lives--;
			if (lives >= 0) {
				System.out.println("You have " + lives + " extra attempts left!");
			} else {
				System.out.println("You lost!");
			}
			printHangman();
		}
	}
	*/
	
	public boolean endGame() {
		return charsLeft == 0;
	}
	
	public void printClue() {
			for(int i = 0; i < word.length; i++) {
				if (guessing[i] != ' ') {
					System.out.print(word[i]);	
				} else {
					System.out.print("_");
			}
		}
	}
	
	public void printHangman() {
		switch (lives) {
		case 4:
			System.out.println("(º-º)");
			break;
		case 3:
			System.out.println("(º-º)");
			System.out.println("  |");
			System.out.println("  |");
			break;
		case 2:
			System.out.println("(º-º)");
			System.out.println(" /|");
			System.out.println("  |");
			break;
		case 1:
			System.out.println("(º-º)");
			System.out.println(" /|\\");
			System.out.println("  |");
			break;
		case 0:
			System.out.println("(º-º)");
			System.out.println(" /|\\");
			System.out.println("  |");
			System.out.println(" /");
			break;
		case -1:
			System.out.println("(º-º)");
			System.out.println(" /|\\");
			System.out.println("  |");
			System.out.println(" / \\");
			break;
		}
	}
}
