package ru.kottofey;

public class Main {

	static boolean DEBUG = false;

	public static void main(String[] args) {
		isDebug(args);

		VizinerCipher transcoder;
		CodeTable.makeCodeTable();

		do {
			transcoder = new VizinerCipher();
		} while (!transcoder.getMode().equals("exit"));
	}

	private static void isDebug(String[] args) {
		if (args.length != 0 && (args[0].equals("--debug") || args[0].equals("-d"))) {
			DEBUG = true;
			System.out.println("---------========= DEBUG MODE !!!! =========---------\n" +
					"--=== SWITCH OFF IF RUNNING OUTSIDE OF IDEA !!! ===--");
		}
	}
}
