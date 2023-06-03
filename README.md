<div align="center">
<img src="https://freesvg.org/img/Bill_Cipher.png" width="250" alt=""/>

# Text Encrypting / Decrypting Algorithm
</div>

This is an application for encrypting and decrypting user text from console input.

## Requirements:

To run executable file you need to install minimum JDK 15.
You can download zip-archive from openJDK site for Windows [here](https://download.java.net/openjdk/jdk15/ri/openjdk-15+36_windows-x64_bin.zip).

Or download installer for your OS from Oracle website [here](https://www.oracle.com/java/technologies/downloads/)
in `Java Downloads` or `Java Archive` tab. You need Java SE.
Oracle installer is preferable as it has automated installation.

Also you may download and unzip latest JDK [here](https://jdk.java.net/).

## How to start application:

If you are on Windows and have proper JRE/JDK installed to a **standard location** just run exe file.
Alternatively open terminal (Windows or Linux or MacOS does not matter), type in the following:
```
java -jar ...
```
Where `...` is a path to your `VizinerCipher-[version].jar`

## How it works:

You need to put the **phrase** you want to encrypt/decrypt and a **key** phrase which is
sort of a password. Without knowing the key you will not be able to decrypt coded sequence
correctly.

There is an option to shift current coding table to the right. Made just for fun,
theoretically this adds additional security: to decrypt you must know a key **AND**
a shift value to get a correct coding table for algorithm.

So far there is only [Vigenère cipher](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher)
algorithm implemented. More ciphers will be added later.

Standard **Coding table** consists of characters allowed for input and may be put to screen via application menu.

## Things already done:

- Menu system
- Vigenère cipher implemented
- Coding table generating
- Coding table shift
- Additional characters in coding table such as punctuation and russian letter "Ёё"
    - They are hardcoded and may be set in class CodeTable.java in ***additionalChars*** field
      (Need to recompile application after this change.)

## Things I want to do:

- Add more ciphers
- Make input from and output to a text file
- Make an input and other options in command line arguments
- Create custom coding table by input of allowed characters by user
