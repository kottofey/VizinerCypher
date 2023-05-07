package ru.kottofey;

import java.util.Scanner;

public class Transcoder {
	private String lang;
	private String mode;
	private String originalPhrase;
	private String keyPhrase;
	private String codedPhrase;
	CodeTable codeTable;
	Scanner scanner = new Scanner(System.in);

	class Menu {
		public void showLanguageMenu() {
			System.out.print("\nThis is a Vigenere Cipher algorithm.\n\n" +
					"What alphabet will be used?\n" +
					"1) Latin\n" +
					"2) Cyrillic\n" +
					"Enter option > ");
			switch (scanner.nextInt()) {
				case 1:
					setLang("en");
					break;
				case 2:
					setLang("ru");
					break;
				default:
					setLang("unknown");
					break;
			}
			codeTable = new CodeTable(getLang());
			scanner.nextLine();
		}

		public void showModeMenu() {
			System.out.print("\nPlease choose an option:\n" +
					"1) Encrypt\n" +
					"2) Decrypt\n" +
					"3) Exit application\n" +
					"Enter option > ");
			switch (scanner.nextInt()) {
				case 1:
					setMode("encrypt");
					break;
				case 2:
					setMode("decrypt");
					break;
				case 3:
					setMode("exit");
				default:
					setMode("unknown");
					break;
			}
			scanner.nextLine();
		}

		public void showEncryptMenu() {
			System.out.printf("\n\n-= Encryption =-\n" +
					"Enter phrase for encryption. Only selected language letters and\n" +
					"spaces are allowed, all punctuation and other symbols will be truncated\n" +
					"-> Selected language is: %s\n" +
					"Enter original phrase to encrypt > ", lang);

			setOriginalPhrase(scanner.nextLine());

			System.out.print("Enter Key Phrase > ");
			setKeyPhrase(scanner.nextLine());
		}

		public void showDecryptMenu() {
			System.out.printf("\n\n-= Decryption =-\n" +
					"Enter sequence for decryption. Only selected language letters\n" +
					"are allowed, all punctuation, spaces and other symbols will be truncated\n" +
					"-> Selected language is: %s\n" +
					"Enter original phrase to decrypt > ", lang);
			setOriginalPhrase(scanner.nextLine());

			System.out.print("Enter Key Phrase > ");
			setKeyPhrase(scanner.nextLine());
		}
	}


	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getOriginalPhrase() {
		return originalPhrase;
	}

	public void setOriginalPhrase(String originalPhrase) {
		this.originalPhrase = originalPhrase;
	}

	public String getKeyPhrase() {
		return keyPhrase;
	}

	public void setKeyPhrase(String keyPhrase) {
		this.keyPhrase = keyPhrase;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
