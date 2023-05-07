package ru.kottofey;

import java.util.Scanner;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private String lang;
	private String mode;
	private String originalPhrase;
	private String keyPhrase;
	private String cipherType;

	void showHelloMenu() {
		// TODO: Show cipher type in Hello Menu
		System.out.print("\nThis is a Vigenere Cipher algorithm.\n\n");
	}

	public void showLanguageMenu() {
		System.out.print("\nWhat alphabet will be used?\n" +
				"1) Latin\n" +
				"2) Cyrillic\n" +
				"Enter option > ");
		setLang();
	}

	public void showModeMenu() {
		System.out.print("\nPlease cipher mode:\n" +
				"1) Encrypt\n" +
				"2) Decrypt\n" +
				"Enter option > ");
		setMode();
	}

	public void showEncryptMenu() {
		System.out.print("\n\n-= Encryption =-\n" +
				"Only selected language letters and spaces are allowed,\n" +
				"all punctuation and other symbols will be truncated.\n");
		setOriginalPhrase();
		setKeyPhrase();
	}

	public void showDecryptMenu() {
		System.out.print("\n\n-= Decryption =-\n" +
				"Only selected language letters are allowed,\n" +
				"all punctuation, spaces and other symbols will be truncated.\n");
		setOriginalPhrase();
		setKeyPhrase();
	}


	private void setLang() {
		do {
			switch (scanner.nextInt()) {
				case 1:
					this.lang = "en";
					break;
				case 2:
					this.lang = "ru";
					break;
				default:
					System.out.println("\nError, select one of options\n");
					showLanguageMenu();
			}
		} while (this.lang.equals(""));
		scanner.nextLine();
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
		System.out.print("Enter phrase to transcode > ");
		do {
			this.originalPhrase = scanner.nextLine();
			if (this.originalPhrase.equals("")) {
				System.out.print("Phrase for transcoding must not be empty.\n" +
						"Enter phrase to transcode > ");
			}
		} while (this.originalPhrase.equals(""));
	}

	private void setKeyPhrase() {
		System.out.print("Enter key phrase > ");
		do {
			this.keyPhrase = scanner.nextLine();
			if (this.keyPhrase.equals("")) {
				System.out.print("Key phrase must not be empty.\n" +
						"Enter key phrase > ");
			}
		} while (this.keyPhrase.equals(""));
	}

	public String getLang() {
		return lang;
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
