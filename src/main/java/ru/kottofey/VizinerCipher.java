package ru.kottofey;

public class VizinerCipher {
	private static StringBuilder codedPhrase = new StringBuilder();

	public VizinerCipher(String mode) {
		switch (mode) {
			case "encrypt":
				System.out.println("\nCoded phrase: " + doEncrypt() + '\n');
				break;
			case "decrypt":
				System.out.println("\nDecoded phrase: " + doDecrypt() + '\n');
				break;
		}
		codedPhrase.delete(0, codedPhrase.length());
	}

	public String doEncrypt() {
		int keyCounter = 0;
		char currentKeyChar;
		char currentPhraseChar;

		// stripping heading and trailing spaces from phrase
		String strippedPhrase = Transcoder.getOriginalPhrase().strip();

		for (int i = 0; i < strippedPhrase.length(); i++) {
			char tableLineFirstChar = 0;
			currentKeyChar = Transcoder.getKeyPhrase().charAt(keyCounter);
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

			if (keyCounter == Transcoder.getKeyPhrase().length() - 1) {
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

		// stripping heading and trailing spaces from phrase
		String strippedPhrase = Transcoder.getOriginalPhrase().strip();
		int keyCounter = 0;
		int lineCounter = 0;
		int keyPsnIndex;
		char currentKeyChar;
		char currentPhraseChar;
		char lineCharAtPsn;

		// Iterating through chars of coded phrase
		for (int i = 0; i < strippedPhrase.length(); i++) {
			currentPhraseChar = strippedPhrase.charAt(i);
			currentKeyChar = Transcoder.getKeyPhrase().charAt(keyCounter);

			// Looking for keyPsnIndex in zero'th line
			keyPsnIndex = CodeTable.getCodeTable()[0].toString().indexOf(currentKeyChar);

			// Iterating through code table lines, looking for match of:
			// (code phrase char at keyPsnIndex) and (coded phrase current char)
			// zero'th char of found line is decoded char to append
			do {
				lineCharAtPsn = CodeTable.getCodeTable()[lineCounter].charAt(keyPsnIndex);
				lineCounter++;
			} while (lineCharAtPsn != currentPhraseChar);

			// Appending coded phrase
			codedPhrase.append(CodeTable.getCodeTable()[lineCounter - 1].charAt(0));
			lineCounter = 0;

			// If Key phrase is over, reset and start from beginning of key phrase
			if (keyCounter == Transcoder.getKeyPhrase().length() - 1) {
				keyCounter = 0;
			} else {
				keyCounter++;
			}
		}
		return this.codedPhrase.toString();
	}
}