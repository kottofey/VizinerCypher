package ru.kottofey;

public class Transcoder {
	private StringBuilder codedPhrase;
	private String originalPhrase;
	private String keyPhrase;
	private String mode;
	static CodeTable codeTable = new CodeTable();

	public Transcoder() {
		Menu menu = new Menu();
		codedPhrase = new StringBuilder();

		menu.showHelloMenu();

		menu.showModeMenu();
		setMode(menu.getMode());

		switch (getMode()) {
			case "encrypt":
				menu.showEncryptMenu();
				break;
			case "decrypt":
				menu.showDecryptMenu();
				break;
		}
		setOriginalPhrase(menu.getOriginalPhrase());
		setKeyPhrase(menu.getKeyPhrase());

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

			if (keyCounter == getKeyPhrase().length() - 1) {
				keyCounter = 0;
			} else {
				keyCounter++;
			}
		}

		System.out.println("Decrypted phrase: " + getCodedPhrase());
	}

	public StringBuilder getCodedPhrase() {
		return codedPhrase;
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
