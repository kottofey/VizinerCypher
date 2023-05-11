package ru.kottofey;

public class VizinerCipher {

	/*
	 TODO: Different offsets for code tables
	 TODO: Different ciphers
	 TODO: Show cipher type in Hello Menu
	 TODO: Input from file and output to file
	 TODO: Move actions from Menu class somewhere. Menu must only show menu text.
	 TODO: Make exe with cmd line arguments for phrase and key
	 FIXME: Menu.setMode() сделать проверку на ввод режима "не цифры"
	 TODO: Возможно, сделать через HashMap
	 TODO: Зациклить и дополнить выходом, как отдельной опцией в меню
	 FIXME: В ехе при использовании кириллицы - падает
	  ("ЭТО ПРОБЛЕМА ТЕРМИНАЛА - НЕ ВИДИТ КИРИЛЛИЦУ!")
	  (Починил для консолей ОС, но не работает в консоли IDEA)
	*/


	public static void main(String[] args) {

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