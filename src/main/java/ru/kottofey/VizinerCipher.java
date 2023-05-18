package ru.kottofey;

public class VizinerCipher {

	/*
	 TODO: Different offsets for code tables lines as option
	 TODO: (maybe?) Custom CodeTables char sets or orders
	 TODO: Add more different ciphers
	 TODO: Show cipher type in Hello Menu when various ciphers are implemented
	 TODO: Input from file and output to file
	 TODO: Make exe with cmd line arguments for phrase and key
	 TODO: Probably better with HashMap?
	 TODO: Wrap it into interface somehow...
	 TODO: Move logic from Transcoder constructor
	 FIXME: РАЗОБРАТЬСЯ С МАТЬ ЕГО ГИТОМ!!!
	*/


	public static void main(String[] args) {
		boolean DEBUG = true;

		if (DEBUG) {
			System.out.println("---------========= DEBUG MODE !!!! =========---------\n" +
					"--=== SWITCH OFF IF RUNNING OUTSIDE OF IDEA !!! ===--");
		}

		Transcoder transcoder = new Transcoder(DEBUG);


	}
}