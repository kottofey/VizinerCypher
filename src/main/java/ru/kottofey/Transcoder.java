package ru.kottofey;

public class Transcoder {
	private StringBuilder codedPhrase;
	private String lang;
	private String originalPhrase;
	private String keyPhrase;
	private String mode;
	private CodeTable codeTable;

	public Transcoder() {
		Menu menu = new Menu();
		codedPhrase = new StringBuilder();

		menu.showHelloMenu();

		menu.showLanguageMenu();
		setLang(menu.getLang());

		menu.showModeMenu();
		setMode(menu.getMode());

		switch (getMode()) {
			case "encrypt":
				menu.showEncryptMenu();
				break;
			case "decrypt":
				menu.showDecryptMenu();
				break;
		}
		setOriginalPhrase(menu.getOriginalPhrase());
		setKeyPhrase(menu.getKeyPhrase());

		codeTable = new CodeTable(menu.getLang());
	}

	public void doEncrypt() {
		// TODO: Implement encryption code
		System.out.println(this.codedPhrase.replace(0, codedPhrase.length(), "Returning decrypted phrase"));
		System.out.println("Code table used:\n" + codeTable.getCodeTable()[0].toString());
	}

	public void doDecrypt() {
		// TODO: Implement decryption code
		System.out.println(this.codedPhrase.replace(0, codedPhrase.length(), "Returning decrypted phrase"));
		System.out.println("Code table used:\n" + codeTable.getCodeTable()[1].toString());
	}

	public StringBuilder getCodedPhrase() {
		return codedPhrase;
	}

	public void setCodedPhrase(StringBuilder codedPhrase) {
		this.codedPhrase = codedPhrase;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getOriginalPhrase() {
		return originalPhrase;
	}

	public void setOriginalPhrase(String originalPhrase) {
		this.originalPhrase = originalPhrase;
	}

	public String getKeyPhrase() {
		return keyPhrase;
	}

	public void setKeyPhrase(String keyPhrase) {
		this.keyPhrase = keyPhrase;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
