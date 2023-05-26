package ru.kottofey;

public final class Menu {
	//	private String cipherType;
	private Menu() {}

	public static void showHelloMenu() {
		System.out.print("\n------------------------------------\nThis is a Vigenere Cipher algorithm.\n");
	}

	public static void showModeMenu() {
		System.out.println("Current Code table shift: " + CodeTable.getShift());
		System.out.print("""
    
				Please choose an option:
				0) Exit
				1) Encrypt
				2) Decrypt
				3) Set code table shift
				4) Code table to screen
				
				Enter option >\s""");
	}

	public static void showEncryptMenu() {
		System.out.print("\n-= Encryption =-\n");
	}

	public static void showDecryptMenu() {
		System.out.print("\n-= Decryption =-\n");
	}

	public static void showSetShift() {
		System.out.print("\nEnter shift value for code table > ");
	}
}