package ru.kottofey;

public class VizinerCipher {

	public static void main(String[] args) {

		CodeTable enTable = new CodeTable("en");
		System.out.println();
		CodeTable ruTable = new CodeTable("ru");

	System.out.println(enTable.getCodeTableLine(10).toString());
	}

}