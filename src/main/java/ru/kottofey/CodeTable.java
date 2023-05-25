package ru.kottofey;

public final class CodeTable {
	private static final int enFirstLetter = 'A'; // utf 61
	private static final int enLastLetter = 'z';  // utf 122
	private static final int jump = 918 - 1; // distance between rus 'А' & en 'z'
	private static final int enLength = 'z' - 'A' + 1;
	private static final int ruLength = 'я' - 'А' + 1;
	private static final String additionalChars = " ,.!?-ёЁ"; // Additional allowed characters for input
	private static final String allowedPattern = "[^a-zA-Zа-яА-Я0-9" + additionalChars + "]"; // alphabets plus additional chars
	private static char currentChar = enFirstLetter;
	private static StringBuilder tempString = new StringBuilder();
	private static char tempChar;

	private CodeTable() {}
	// Line length without six UTF-8 symbols between latin (Z & a) plus ten digits
	private static int alphabetLength = enLength + ruLength + additionalChars.length() - 6 + 10;

	// The whole Code Table init
	private static StringBuilder[] codeTable = new StringBuilder[alphabetLength];

	public static void makeCodeTable() {
		// Creating first line
		codeTable[0] = new StringBuilder("1234567890"); // add digits first

		// add "en + ru chars", without additional chars and digits
		for (int i = 0; i < alphabetLength - additionalChars.length() - 10; i++) {
			if (currentChar == 'Z' + 1) {
				currentChar += 6; // skip extra symbols
			} else if (currentChar == enLastLetter + 1) {
				currentChar += jump; // jump to russian alphabet start
			}
			codeTable[0].append((char) (currentChar++));
		}
		codeTable[0].append(additionalChars); // finally add additional characters to first line here

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

	public static String getAllowedPattern() {
		return allowedPattern;
	}

	public static StringBuilder[] getCodeTable() {
		return codeTable;
	}
}