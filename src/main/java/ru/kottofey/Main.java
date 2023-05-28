package ru.kottofey;

public class Main {

	static boolean DEBUG = false;

	public static void main(String[] args) {
		Debug(args);

		CodeTable.makeCodeTable();

		do {
			Menu.showHelloMenu();
			Menu.showModeMenu();
			Actions.setMode();
			Actions.doMode(Actions.getMode());
		} while (!Actions.getMode().equals("exit"));
	}

	private static void Debug(String[] args) {
		if (args.length != 0 && (args[0].equals("--debug") || args[0].equals("-d"))) {
			DEBUG = true;
			System.out.println("---------========= DEBUG MODE !!!! =========---------\n" +
					"--=== SWITCH OFF IF RUNNING OUTSIDE OF IDEA !!! ===--");
		}
	}
}
