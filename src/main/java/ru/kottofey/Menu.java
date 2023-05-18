package ru.kottofey;

public class Menu {
	//	private String cipherType;

	void showHelloMenu() {
		System.out.print("\nThis is a Vigenere Cipher algorithm.\n");
	}

	public void showModeMenu() {
		System.out.print("""

				Please choose an option:
				1) Encrypt
				2) Decrypt
				3) Exit
				Enter option >\s""");
	}

	public void showEncryptMenu() {
		System.out.print("\n-= Encryption =-\n");
	}

	public void showDecryptMenu() {
		System.out.print("\n-= Decryption =-\n");
	}
}