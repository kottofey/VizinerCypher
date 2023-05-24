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
		if (getMode().equals("exit")) {
			return;
		}
		setOriginalPhrase();
		setKeyPhrase();
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
				case "1":
					this.mode = "encrypt";
					break;
				case "2":
					this.mode = "decrypt";
					break;
				case "3":
					this.mode = "exit";
					break;
				default:
					System.out.println("\nError, select one of options");
					System.out.print("Enter option > ");
					this.mode = "";
			}
		} while (this.mode.equals(""));
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


}
