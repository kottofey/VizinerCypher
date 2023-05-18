package ru.kottofey;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transcoder {
	private StringBuilder codedPhrase;
	private String originalPhrase;
	private String keyPhrase;
	private String mode;
	private static CodeTable codeTable = new CodeTable();
	private boolean DEBUG;
	Scanner scanner;
	Pattern allowedRange = Pattern.compile(Transcoder.codeTable.getAllowedPattern());

	public Transcoder(boolean DEBUG) {
		setDEBUG(DEBUG);
		scanner = new Scanner(System.in, getCharSet());
		Menu menu = new Menu();
		codedPhrase = new StringBuilder();

		menu.showHelloMenu();

		do {
			menu.showModeMenu();
			setMode();

			switch (getMode()) {
				case "encrypt":
					menu.showEncryptMenu();
					setOriginalPhrase();
					setKeyPhrase();
					doEncrypt();
					break;
				case "decrypt":
					menu.showDecryptMenu();
					setOriginalPhrase();
					setKeyPhrase();
					doDecrypt();
					break;
				case "exit":
					break;
			}
		} while (!getMode().equals("exit"));
	}

	public void doEncrypt() {
		int keyCounter = 0;
		char currentKeyChar;
		char currentPhraseChar;

		// stripping heading and trailing spaces from phrase
		String strippedPhrase = getOriginalPhrase().strip();

		for (int i = 0; i < strippedPhrase.length(); i++) {
			char tableLineFirstChar = 0;
			currentKeyChar = getKeyPhrase().charAt(keyCounter);
			currentPhraseChar = strippedPhrase.charAt(i);

			// Looking for key letter position in first CodeTable line and use it for coded letter position
			int currentKeyCharPsn = codeTable.getCodeTable()[0].toString().indexOf(currentKeyChar);

			char iterator = 0;

			// Looking for CodeTable line with first letter equals to letter of a phrase, its number = iterator
			while (currentPhraseChar != tableLineFirstChar) {
				tableLineFirstChar = codeTable.getCodeTable()[iterator].charAt(0);
				iterator++;
			}

			// Appending coded phrase
			codedPhrase.append(codeTable.getCodeTable()[iterator - 1].charAt(currentKeyCharPsn));

			if (keyCounter == getKeyPhrase().length() - 1) {
				keyCounter = 0;
			} else {
				keyCounter++;
			}
		}

		System.out.println("Encrypted phrase: " + this.codedPhrase);
		this.codedPhrase.delete(0, this.codedPhrase.length());
	}

	public void doDecrypt() {
		int keyCounter = 0;
		char currentKeyChar;
		char currentPhraseChar;

		// stripping heading and trailing spaces from phrase
		String strippedPhrase = getOriginalPhrase().strip();
		char tableLineFirstChar = 0;

		// ищем букву из ключа в первом столбце
		// в найденной строчке находим позицию буквы из ключа
		// из нулевой строки таблицы по этой позиции добавляем в результат букву
		for (int i = 0; i < strippedPhrase.length(); i++) {
			currentPhraseChar = strippedPhrase.charAt(i);
			currentKeyChar = getKeyPhrase().charAt(keyCounter);

			// Looking for CodeTable line with first letter equals to letter of a key, its number = iterator
			char iterator = 0;
			while (currentKeyChar != tableLineFirstChar) {
				tableLineFirstChar = codeTable.getCodeTable()[iterator].charAt(0);
				iterator++;
			}

			// Looking for letter position in [iterator] CodeTable line and use it for coded letter position
			int currentPhraseCharPsn = codeTable.getCodeTable()[iterator - 1].toString().indexOf(currentPhraseChar);

			// Appending coded phrase
			codedPhrase.append(codeTable.getCodeTable()[0].charAt(currentPhraseCharPsn));

			// If Key phrase is over, reset and start from beginning of key phrase
			if (keyCounter == getKeyPhrase().length() - 1) {
				keyCounter = 0;
			} else {
				keyCounter++;
			}
		}

		System.out.println("Decrypted phrase: " + getCodedPhrase());
		this.codedPhrase.delete(0, this.codedPhrase.length());
	}

	private void setOriginalPhrase() {
		System.out.print("Enter phrase to transcode > ");
		do {
			this.originalPhrase = scanner.nextLine();
			Matcher matcher = allowedRange.matcher(this.originalPhrase);

			if (this.originalPhrase.equals("")) {
				System.out.print("Phrase for transcoding must not be empty.\n" +
						"Enter phrase to transcode > ");
			} else if (matcher.find()) {
				System.out.print("There allowed only following characters:\n" +
						Transcoder.codeTable.getAllowedPattern() + "\nTry again.\n" +
						"Enter phrase to transcode > ");
				this.originalPhrase = "";
			}
		} while (this.originalPhrase.equals(""));
	}

	private void setKeyPhrase() {
		System.out.print("Enter key phrase > ");
		do {
			this.keyPhrase = scanner.nextLine();
			Matcher matcher = allowedRange.matcher(this.keyPhrase);

			if (this.keyPhrase.equals("")) {
				System.out.print("Key phrase must not be empty.\n" +
						"Enter key phrase > ");
			} else if (matcher.find()) {
				System.out.print("There allowed only following characters:\n" +
						Transcoder.codeTable.getAllowedPattern() + "\nTry again.\n" +
						"Enter phrase to transcode > ");
				this.keyPhrase = "";
			}
		} while (this.keyPhrase.equals(""));
	}

	private void setMode() {
		do {
			switch (scanner.nextLine()) {
				case "1":
					this.mode = "encrypt";
					break;
				case "2":
					this.mode = "decrypt";
					break;
				case "3":
					this.mode = "exit";
					break;
				default:
					System.out.println("\nError, select one of options");
					System.out.print("Enter option > ");
					this.mode = "";
			}
		} while (this.mode.equals(""));
	}

	private String getCharSet() {
		String osName = System.getProperty("os.name").toLowerCase();
		System.out.println(osName);
		if (osName.contains("win") && !getDEBUG()) {
			System.out.println("codepage in use: ibm866");
			return "ibm866";
		} else {
			System.out.println("codepage in use: UTF-8");
			return "UTF-8";
		}
	}

	public boolean getDEBUG() {
		return DEBUG;
	}

	public void setDEBUG(boolean DEBUG) {
		this.DEBUG = DEBUG;
	}

	public StringBuilder getCodedPhrase() {
		return codedPhrase;
	}

	public String getOriginalPhrase() {
		return originalPhrase;
	}

	public String getKeyPhrase() {
		return keyPhrase;
	}

	public String getMode() {
		return mode;
	}
}
