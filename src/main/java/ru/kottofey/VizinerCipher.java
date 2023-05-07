package ru.kottofey;

public class VizinerCipher {

	// TODO: Input from file and output to file
	// TODO: Different ciphers
	// TODO: Different offsets for code tables

	public static void main(String[] args) {
		Transcoder transcoder = new Transcoder();
		System.out.println("End of program.");
		System.out.println("Language: " + transcoder.getLang());
		System.out.println("Mode: " + transcoder.getMode());
		System.out.println("Phrase: " + transcoder.getOriginalPhrase());
		System.out.println("Key: " + transcoder.getKeyPhrase());
		transcoder.doEncrypt();
		transcoder.doDecrypt();
	}

}