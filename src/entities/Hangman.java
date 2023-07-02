package entities;

public class Hangman {

	private int lives = 5;
	private char[] word;
	private int currentPosition = 0;
	
	public Hangman(String word) {
		this.word = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			this.word[i] = word.charAt(i);
		}
	}
	
	public Integer getLives() {
		return lives;
	}
	
	public char[] getWord() {
		return word;
	}
	
	public void checkLetter(char letra) {
		if (word[currentPosition] == letra ) {
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
	
	public boolean endGame() {
		return currentPosition == word.length;
	}
	
	public void printClue() {
		if (currentPosition > 0) {
			for(int i = 0; i < currentPosition; i++) {
				System.out.print(word[i]);
			}
			for(int i = 0; i < word.length - currentPosition; i++) {
				System.out.print("_");
			}
		} else {
			for(int i = 0; i < word.length; i++) {
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
