package ru.kottofey;

import java.util.regex.Pattern;

public final class Transcoder {
	private static String originalPhrase;
	private static String keyPhrase;
	private static String cipher;

	private Transcoder() {}

	public static String getOriginalPhrase() {
		return originalPhrase;
	}

	public static String getKeyPhrase() {
		return keyPhrase;
	}

	public static String getCipher() {
		return cipher;
	}

	public static Pattern getAllowedPattern() {
		return Pattern.compile(CodeTable.getAllowedPatternString());
	}

	public static void setOriginalPhrase(String originalPhrase) {
		Transcoder.originalPhrase = originalPhrase;
	}

	public static void setKeyPhrase(String keyPhrase) {
		Transcoder.keyPhrase = keyPhrase;
	}

	public static void setCipher(String cipher) {
		Transcoder.cipher = cipher;
	}
}
