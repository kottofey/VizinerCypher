package ru.kottofey;

class CodeTable {
	private final int enFirstLetter = 'A'; // utf 61
	private final int enLastLetter = 'z';  // utf 122
	private final int jump = 918 - 1; // distance between rus 'А' & en 'z'
	private final int enLength = 'z' - 'A' + 1;
	private final int ruLength = 'я' - 'А' + 1;
	private final String additionalChars = " ,.!?-"; // Additional allowed characters for input
	private final String allowedPattern = "[^a-zA-Zа-яА-Я0-9" + additionalChars + "]"; // alphabets plus additional chars
	private char currentChar = enFirstLetter;
	private StringBuilder tempString = new StringBuilder();
	private char tempChar;

	// Line length without six UTF-8 symbols between latin (Z & a) plus ten digits
	private int alphabetLength = enLength + ruLength + additionalChars.length() - 6;

	private StringBuilder[] codeTable = new StringBuilder[alphabetLength];

	CodeTable() {
		codeTable[0] = new StringBuilder("1234567890"); // add digits first

		// add "en + ru + additional chars" string
		for (int i = 0; i < alphabetLength - additionalChars.length(); i++) {
			if (currentChar == 'Z' + 1) {
				currentChar += 6;
			} else if (currentChar == enLastLetter + 1) {
				currentChar += jump;
			}
			codeTable[0].append((char) (currentChar++));
		}
		codeTable[0].append(additionalChars); // add additional characters and digits to table here

		// Building the rest of CodeTable based on first line, shifting one char at time
		for (int i = 1; i < alphabetLength; i++) {
			codeTable[i] = new StringBuilder(codeTable[i-1]);		// copy previous line to new string
			tempChar = codeTable[i].charAt(0);	// copy first char of previous line
			codeTable[i].deleteCharAt(0).append(tempChar);	// remove first char and append it to end of new line
		}

		/*for (StringBuilder str : codeTable) {
			System.out.println(str.toString());
		}*/
	}

	public String getAllowedPattern() {
		return this.allowedPattern;
	}

	public StringBuilder[] getCodeTable() {
		return codeTable;
	}
}