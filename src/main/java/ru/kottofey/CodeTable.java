package ru.kottofey;

class CodeTable {
	private final int enFirstLetter = 'A'; // utf 61
	private final int enLastLetter = 'z';  // utf 122
	private final int jump = 918 - 1; // distance between rus 'А' & en 'z'
	private final int enLength = 'z' - 'A' + 1;
	private final int ruLength = 'я' - 'А' + 1;
	private final String additionalChars = " ,.!?-";
	private int currentChar = enFirstLetter;
	private StringBuilder tempString;
	private int tempChar;

	private int alphabetLength = enLength + ruLength + additionalChars.length();
	private StringBuilder[] codeTable = new StringBuilder[alphabetLength];

	CodeTable() {
		setCodeTable();
	}

	private void setCodeTable() {
		codeTable[0] = new StringBuilder();

		// building first "en + ru + add chars" string
		for (int i = 0; i < alphabetLength - additionalChars.length(); i++) {
			if (currentChar == enLastLetter + 1) {
				currentChar += jump;
			}
			codeTable[0].append((char) (currentChar++));
		}
		codeTable[0].append(additionalChars); // adding other characters to table here

		for (int i = 1; i < alphabetLength; i++) {
			codeTable[i] = new StringBuilder();
			tempString = new StringBuilder(codeTable[i-1]);
			tempChar = tempString.charAt(0);

			tempString.deleteCharAt(0).append((char) tempChar);
			codeTable[i].append(tempString);
		}
	}

	public String getAdditionalChars() {
		return additionalChars;
	}

	public StringBuilder[] getCodeTable() {
		return codeTable;
	}



}