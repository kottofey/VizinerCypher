package ru.kottofey;

public class Main {
	/*
	 TODO: Different offsets for code tables lines as option
	 TODO: (maybe?) Custom CodeTables char sets or orders
	 TODO: Add more different ciphers
	 TODO: Show cipher type in Hello Menu when various ciphers are implemented
	 TODO: Input from file and output to file
	 TODO: Make exe with cmd line arguments for phrase and key
	 TODO: Probably better with HashMap?
	 TODO: Wrap it into interface somehow...
	*/

	final static boolean DEBUG = true;

	public static void main(String[] args) {

		if (DEBUG) {
			System.out.println("---------========= DEBUG MODE !!!! =========---------\n" +
					"--=== SWITCH OFF IF RUNNING OUTSIDE OF IDEA !!! ===--");
		}

		VizinerCipher transcoder;
		CodeTable.makeCodeTable();

		do {
			transcoder = new VizinerCipher();
			switch (transcoder.getMode()) {
				case "encrypt":
					Menu.showEncryptMenu();
					transcoder.doEncrypt();
					transcoder.printCodedPhrase();
					break;
				case "decrypt":
					Menu.showDecryptMenu();
					transcoder.doDecrypt();
					transcoder.printCodedPhrase();
					break;
				case "exit":
					break;
			}
		} while (!transcoder.getMode().equals("exit"));

	}
}
