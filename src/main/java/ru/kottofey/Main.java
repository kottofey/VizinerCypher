package ru.kottofey;

public class Main {
	/*
	 TODO: Custom CodeTable with user entering first line of table,
	 		i.e. allowed characters. Need to check against user
	 		input of phrase and key for correct input
	 TODO: Add more different ciphers
	 TODO: Show cipher type in Hello Menu when various ciphers are implemented
	 TODO: Input from file and output to file
	 TODO: Make exe with cmd line arguments for phrase and key
	 TODO: Probably better with HashMap?
	 TODO: Wrap it into interface somehow...
	 TODO: Change menu logic, must be all in one place
	*/

	static boolean DEBUG = false;

	public static void main(String[] args) {

		if (args.length != 0 && (args[0].equals("--debug") || args[0].equals("-d"))) {
			DEBUG = true;
			System.out.println("---------========= DEBUG MODE !!!! =========---------\n" +
					"--=== SWITCH OFF IF RUNNING OUTSIDE OF IDEA !!! ===--");
		}

		VizinerCipher transcoder;
		CodeTable.makeCodeTable();

		do {
			transcoder = new VizinerCipher();
		} while (!transcoder.getMode().equals("exit"));

	}
}
