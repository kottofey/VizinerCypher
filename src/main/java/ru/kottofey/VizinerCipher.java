package ru.kottofey;

public class VizinerCipher {

	public static void main(String[] args) {

		CodeTable enTable = new CodeTable("en");

		System.out.println(enTable.codeTable[0].toString());

	}

}