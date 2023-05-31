package ru.kottofey;

public final class Menu {
	//	private String cipherType;
	private Menu() {}

	public static void showHelloMenu() {
		System.out.print("""

				------------------------------------
				This is a Vigenere Cipher algorithm.
				""");
		System.out.println("Current Code table shift: " + CodeTable.getShift());
	}

	public static void showModeMenu() {
		System.out.print("""
    
				Please choose an option:
				00) Help
				 0) Exit
				 1) Encrypt
				 2) Decrypt
				 3) Set code table shift
				 4) Allowed chars list to screen
				 5) Code table to screen
				
				Enter option >\s""");
	}

	public static void showHelp() {
		System.out.println("Help will be here later");
	}

	public static void showEncryptMenu() {
		System.out.print("""

				-= Encryption =-
				Choose cipher type:
				1) Viziner Cipher
				2) Caesar's Cipher
				
				Enter Option >\s""");
	}

	public static void showDecryptMenu() {
		System.out.print("""

				-= Decryption =-
				Choose cipher type:
				1) Viziner Cipher
				2) Caesar's Cipher
				
				Enter Option >\s""");
	}

	public static void showSetShift() {
		System.out.print("\nEnter shift value for code table > ");
	}
}