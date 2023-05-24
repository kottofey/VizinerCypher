package ru.kottofey;

public final class Menu {
	//	private String cipherType;
	private Menu() {}

	public static void showHelloMenu() {
		System.out.print("\nThis is a Vigenere Cipher algorithm.\n");
	}

	public static void showModeMenu() {
		System.out.print("""

				Please choose an option:
				1) Encrypt
				2) Decrypt
				3) Exit
				Enter option >\s""");
	}

	public static void showEncryptMenu() {
		System.out.print("\n-= Encryption =-\n");
	}

	public static void showDecryptMenu() {
		System.out.print("\n-= Decryption =-\n");
	}
}