package ru.kottofey;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Actions {
    private static Scanner scanner = new Scanner(System.in, getCharSet());
    private static String mode;

    private Actions() {}

    public static void setMode() {
        do {
            mode = scanner.nextLine();
            switch (mode) {
                case "00":
                    mode = "help";
                    break;
                case "0":
                    mode = "exit";
                    break;
                case "1":
                    mode = "encrypt";
                    break;
                case "2":
                    mode = "decrypt";
                    break;
                case "3":
                    mode = "shift";
                    break;
                case "4":
                    mode = "tableOutput";
                    break;
                default:
                    System.out.println("\nError, select one of options");
                    Menu.showModeMenu();
                    mode = "";
                    break;
            }
        } while (mode.isEmpty());
    }

    public static String getMode() {
        return mode;
    }

    public static void doMode(String mode) {
        switch (mode) {
            case "help":
                Menu.showHelp();
                break;
            case "exit":
                break;
            case "encrypt":
                Menu.showEncryptMenu();
                setCipher();
                setOriginalPhrase();
                setKeyPhrase();
                doCipher();
                break;
            case "decrypt":
                Menu.showDecryptMenu();
                setCipher();
                setOriginalPhrase();
                setKeyPhrase();
                doCipher();
                break;
            case "shift":
                setTableShift();
                break;
            case "tableOutput":
                CodeTable.tableOuptput();
                break;
        }
    }

    public static void setOriginalPhrase() {
        System.out.print("Enter phrase to transcode > ");
        do {
            Transcoder.setOriginalPhrase(scanner.nextLine());
            Matcher matcher = Transcoder.getAllowedPattern().matcher(Transcoder.getOriginalPhrase());

            if (Transcoder.getOriginalPhrase().equals("")) {
                System.out.print("Phrase for transcoding must not be empty.\n" +
                        "Enter phrase to transcode > ");
            } else if (matcher.find()) {
                System.out.print("There allowed only following characters:\n" +
                        CodeTable.getAllowedPatternString() + "\nTry again.\n" +
                        "Enter phrase to transcode > ");
                Transcoder.setOriginalPhrase("");
            }
        } while (Transcoder.getOriginalPhrase().equals(""));
    }

    public static void setKeyPhrase() {
        System.out.print("Enter key phrase > ");
        do {
            Transcoder.setKeyPhrase(scanner.nextLine());
            Matcher matcher = Transcoder.getAllowedPattern().matcher(Transcoder.getKeyPhrase());

            if (Transcoder.getKeyPhrase().equals("")) {
                System.out.print("Key phrase must not be empty.\n" +
                        "Enter key phrase > ");
            } else if (matcher.find()) {
                System.out.print("There allowed only following characters:\n" +
                        CodeTable.getAllowedPatternString() + "\nTry again.\n" +
                        "Enter phrase to transcode > ");
                Transcoder.setKeyPhrase("");
            }
        } while (Transcoder.getKeyPhrase().equals(""));
    }

    public static void setTableShift() {
        String str;
        Pattern allowed = Pattern.compile("[^0-9]");
        do {
            Menu.showSetShift();
            str = scanner.nextLine();
            Matcher matcher = allowed.matcher(str);
            if (matcher.find() || Integer.parseInt(str) > 134) {
                System.out.println("There must be a positive integer from 0 to " + CodeTable.getCodeTable().length);
                str = "";
            }
        } while (str.equals(""));
        CodeTable.setShift(Integer.parseInt(str));
        CodeTable.flushCodeTable();
    }

    public static void setCipher() {
        do {
            switch (scanner.nextLine()) {
                case "1":
                    Transcoder.setCipher("viziner");
                    break;
                case "2":
                    Transcoder.setCipher("caesar");
                    break;
                default:
                    System.out.println("\nError, select one of options");
                    System.out.print("Enter option > ");
                    Transcoder.setCipher("");
            }
        } while (Transcoder.getCipher().equals(""));
    }

    public static void doCipher() {
        switch (Transcoder.getCipher()) {
            case "viziner":
                new VizinerCipher(getMode());
                break;
            case "caesar":
                new CaesarCipher(getMode());
                break;
        }
    }

    public static String getCharSet() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win") && !Main.DEBUG) {
            return "ibm866";
        } else {
            return "UTF-8";
        }
    }
}