package ru.kottofey;

public class CaesarCipher {

    private static StringBuilder codedPhrase = new StringBuilder("123 dummy coded phrase 456");

    public CaesarCipher(String mode) {
        switch (mode) {
            case "encrypt":
                System.out.println(doEncrypt());
                break;
            case "decrypt":
                System.out.println(doDecrypt());
                break;
        }
        codedPhrase.delete(0, codedPhrase.length());
    }

    public String doEncrypt() {

        return codedPhrase.toString();
    }

    public String doDecrypt() {

        return codedPhrase.toString();
    }

}
