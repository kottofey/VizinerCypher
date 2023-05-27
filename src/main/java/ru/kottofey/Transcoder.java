package ru.kottofey;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transcoder {
	private String originalPhrase;
	private String keyPhrase;
	private String mode;
	Pattern allowedPattern;
	Scanner scanner = new Scanner(System.in, getCharSet());

	public Transcoder() {
		allowedPattern = Pattern.compile(CodeTable.getAllowedPattern());
		Menu.showHelloMenu();
		Menu.showModeMenu();
		setMode();
		doMode();
	}



	private void setOriginalPhrase() {
		System.out.print("Enter phrase to transcode > ");
		do {
			this.originalPhrase = scanner.nextLine();
			Matcher matcher = allowedPattern.matcher(this.originalPhrase);

			if (this.originalPhrase.equals("")) {
				System.out.print("Phrase for transcoding must not be empty.\n" +
						"Enter phrase to transcode > ");
			} else if (matcher.find()) {
				System.out.print("There allowed only following characters:\n" +
						CodeTable.getAllowedPattern() + "\nTry again.\n" +
						"Enter phrase to transcode > ");
				this.originalPhrase = "";
			}
		} while (this.originalPhrase.equals(""));
	}

	public String getOriginalPhrase() {
		return originalPhrase;
	}

	private void setKeyPhrase() {
		System.out.print("Enter key phrase > ");
		do {
			this.keyPhrase = scanner.nextLine();
			Matcher matcher = allowedPattern.matcher(this.keyPhrase);

			if (this.keyPhrase.equals("")) {
				System.out.print("Key phrase must not be empty.\n" +
						"Enter key phrase > ");
			} else if (matcher.find()) {
				System.out.print("There allowed only following characters:\n" +
						CodeTable.getAllowedPattern() + "\nTry again.\n" +
						"Enter phrase to transcode > ");
				this.keyPhrase = "";
			}
		} while (this.keyPhrase.equals(""));
	}

	public String getKeyPhrase() {
		return keyPhrase;
	}

	private void setMode() {
		do {
			switch (scanner.nextLine()) {
				case "0":
					mode = "exit";
					break;
				case "1":
					mode = "encrypt";
					break;
				case "2":
					mode = "decrypt";
					break;
				case "3":
					mode = "shift";
					break;
				case "4":
					mode = "tableOutput";
					break;
				default:
					System.out.println("\nError, select one of options");
					System.out.print("Enter option > ");
					mode = "";
			}
		} while (mode.equals(""));
	}

	private void doMode() {
		switch (mode) {
			case "encrypt":
				Menu.showEncryptMenu();
				setOriginalPhrase();
				setKeyPhrase();
				break;
			case "decrypt":
				Menu.showDecryptMenu();
				setOriginalPhrase();
				setKeyPhrase();
				break;
			case "exit":
				break;
			case "shift":
				setTableShift();
				break;
			case "tableOutput":
				CodeTable.tableOuptput();
				break;
		}
	}
	public String getMode() {
		return mode;
	}

	private String getCharSet() {
		String osName = System.getProperty("os.name").toLowerCase();
//		System.out.println(osName);
		if (osName.contains("win") && !Main.DEBUG) {
//			System.out.println("codepage in use: ibm866");
			return "ibm866";
		} else {
//			System.out.println("codepage in use: UTF-8");
			return "UTF-8";
		}
	}

	public void setTableShift() {
		String str;
		Pattern allowed = Pattern.compile("[^0-9]");
		do {
			Menu.showSetShift();
			str = scanner.nextLine();
			Matcher matcher = allowed.matcher(str);
			if (matcher.find() || Integer.parseInt(str) > 134) {
				System.out.println("There must be a positive integer from 0 to " + CodeTable.getCodeTable().length);
				str = "";
			}
		} while (str.equals(""));
		CodeTable.setShift(Integer.parseInt(str));
		CodeTable.flushCodeTable();
	}
}
