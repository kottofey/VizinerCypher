package ru.kottofey;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
	private Scanner scanner = new Scanner(System.in, setCharSet());
	private String mode;
	private String originalPhrase;
	private String keyPhrase;
	private String cipherType;

	private String setCharSet() {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("win")) {
			return "ibm866";
		} else {
			return "UTF-8";
		}
	}

	void showHelloMenu() {
		System.out.print("\nThis is a Vigenere Cipher algorithm.\n");
	}

	public void showModeMenu() {
		System.out.print("""

				Please choose a cipher mode:
				1) Encrypt
				2) Decrypt
				Enter option >\s""");
		setMode();
	}

	public void showEncryptMenu() {
		System.out.print("""

				-= Encryption =-
				Only letters and spaces are allowed, all punctuation
				and spaces will be truncated after transcode.
				""");
		setOriginalPhrase();
		setKeyPhrase();
	}

	public void showDecryptMenu() {
		System.out.print("""

				-= Decryption =-
				Only letters and spaces are allowed, all punctuation
				and spaces will be truncated after transcode.
				""");
		setOriginalPhrase();
		setKeyPhrase();
	}

	private void setMode() {
		do {
			switch (scanner.nextInt()) {
				case 1:
					this.mode = "encrypt";
					break;
				case 2:
					this.mode = "decrypt";
					break;
				default:
					System.out.println("\nError, select one of options\n");
			}
		} while (this.mode.equals(""));
		scanner.nextLine();
	}

	private void setOriginalPhrase() {
		Pattern allowedRange = Pattern.compile("[^a-zA-Zа-яА-Я]" + Transcoder.codeTable.getAdditionalChars());
		System.out.print("Enter phrase to transcode > ");
		do {
			this.originalPhrase = scanner.nextLine();
			Matcher matcher = allowedRange.matcher(this.originalPhrase);

			if (this.originalPhrase.equals("")) {
				System.out.print("Phrase for transcoding must not be empty.\n" +
						"Enter phrase to transcode > ");
			} else if (matcher.find()) {
				System.out.print("There allowed only letters and spaces. Try again.\n" +
						"Enter phrase to transcode > ");
				this.originalPhrase = "";
			}
		} while (this.originalPhrase.equals(""));
	}

	private void setKeyPhrase() {
		Pattern allowedRange = Pattern.compile("[^a-zA-Zа-яА-Я]" + Transcoder.codeTable.getAdditionalChars());

		System.out.print("""
					Spaces, punctuation, numbers and other symbols are not allowed.
					Enter key phrase >\s""");
		do {
			this.keyPhrase = scanner.nextLine();
			Matcher matcher = allowedRange.matcher(this.keyPhrase);

			if (this.keyPhrase.equals("")) {
				System.out.print("Key phrase must not be empty.\n" +
						"Enter key phrase > ");
			} else if (matcher.find()) {
				System.out.print("""
						There allowed only letters.
						Try again.
						Enter key phrase >\s""");
				this.keyPhrase = "";
			}
		} while (this.keyPhrase.equals(""));
	}

	public String getMode() {
		return mode;
	}

	public String getOriginalPhrase() {
		return originalPhrase;
	}

	public String getKeyPhrase() {
		return keyPhrase;
	}
}
