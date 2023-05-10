package ru.kottofey;

public class VizinerCipher {

	// TODO: Different offsets for code tables
	// TODO: Different ciphers
	// TODO: Show cipher type in Hello Menu
	// TODO: Input from file and output to file
	// TODO: Move actions from Menu class somewhere. Menu must only show menu text.
	// TODO: Make exe with cmd line arguments for phrase and key
	// TODO: Menu.setMode() сделать проверку на ввод режима "не цифры"
	// TODO: Возможно, сделать через HashMap
	// TODO: Зациклить и дополнить выходом, как отдельной опцией в меню


	public static void main(String[] args) {
		System.out.println('z' - 'А');
		Transcoder transcoder = new Transcoder();

		switch (transcoder.getMode()) {
			case "encrypt":
				transcoder.doEncrypt();
				break;
			case "decrypt":
				transcoder.doDecrypt();
				break;
		}

	}

}