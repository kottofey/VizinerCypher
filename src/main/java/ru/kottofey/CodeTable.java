package ru.kottofey;

public class CodeTable {
	private int firstLetter;
	private int lastLetter;
	private int alphabetLength;
	private int currentChar;
	public StringBuilder[] codeTable;
	CodeTable(String lang) {
		switch (lang) {
			case "en":
				firstLetter = 'a';
				lastLetter = 'z';
				break;
			case "ru":
				firstLetter = 'а';
				lastLetter = 'я';
				break;
			default:
				System.out.println("Unsupported language, please choose Russian or English");
				break;
		}

		alphabetLength = lastLetter - firstLetter + 1;
		codeTable = new StringBuilder[alphabetLength];
		currentChar = firstLetter;

		for (int i = 0; i < alphabetLength; i++) {
			codeTable[i] = new StringBuilder();
			for (int j = 0; j < alphabetLength; j++) {
				if (currentChar > lastLetter) {
					currentChar = firstLetter;
				}
				codeTable[i].append((char) (currentChar++));
			}
			currentChar = firstLetter + i + 1;
		}
	} // end of constructor

	public StringBuilder getCodeTableLine(int lineNum) {
		return codeTable[lineNum];
	}
}