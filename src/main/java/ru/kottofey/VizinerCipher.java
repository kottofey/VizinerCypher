package ru.kottofey;

public class VizinerCipher extends Transcoder {
	private static StringBuilder codedPhrase = new StringBuilder();

	public VizinerCipher() {
		switch (getMode()) {
			case "encrypt":
				System.out.println(doEncrypt());
				break;
			case "decrypt":
				System.out.println(doDecrypt());
				break;
		}
	}

	public String doEncrypt() {
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
			int currentKeyCharPsn = CodeTable.getCodeTable()[0].toString().indexOf(currentKeyChar);

			char iterator = 0;

			// Looking for CodeTable line with first letter equals to letter of a phrase, its number = iterator
			while (currentPhraseChar != tableLineFirstChar) {
				tableLineFirstChar = CodeTable.getCodeTable()[iterator].charAt(0);
				iterator++;
			}

			// Appending coded phrase
			codedPhrase.append(CodeTable.getCodeTable()[iterator - 1].charAt(currentKeyCharPsn));

			if (keyCounter == getKeyPhrase().length() - 1) {
				keyCounter = 0;
			} else {
				keyCounter++;
			}
		}
		return this.codedPhrase.toString();
	}

	public String doDecrypt() {
		/*
			Decryption pattern:
			- looking for a letter from a key in first row - this is a line needed
			- looking for a letter position in a found line
			- adding a character from zero'th line at found position
		*/

		int keyCounter = 0;
		char currentKeyChar;
		char currentPhraseChar;

		// stripping heading and trailing spaces from phrase
		String strippedPhrase = getOriginalPhrase().strip();
		char tableLineFirstChar = 0;

		for (int i = 0; i < strippedPhrase.length(); i++) {
			currentPhraseChar = strippedPhrase.charAt(i);
			currentKeyChar = getKeyPhrase().charAt(keyCounter);

			// Looking for CodeTable line with first letter equals to letter of a key, its number = iterator
			char iterator = 0;
			while (currentKeyChar != tableLineFirstChar) {
				tableLineFirstChar = CodeTable.getCodeTable()[iterator].charAt(0);
				iterator++;
			}

			// Looking for letter position in [iterator] CodeTable line and use it for coded letter position
			int currentPhraseCharPsn = CodeTable.getCodeTable()[iterator - 1].toString().indexOf(currentPhraseChar);

			// Appending coded phrase
			codedPhrase.append(CodeTable.getCodeTable()[0].charAt(currentPhraseCharPsn));

			// If Key phrase is over, reset and start from beginning of key phrase
			if (keyCounter == getKeyPhrase().length() - 1) {
				keyCounter = 0;
			} else {
				keyCounter++;
			}
		}
		return this.codedPhrase.toString();
	}
}