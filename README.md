# Text Encrypting / Decrypting Algorithm

## Hello and welcome :slightly_smiling_face:

This is an application for encrypting and decrypting user text from console input.

## Requirements:

To run exe file minimum version of JRE or JDK is 15 is required to be installed.
You may run jar file with java.exe _(it's Java15)_ included in `bin` folder
or compile sources yourself. Again, minimum version of Java for compilation is `15`.

To run executable file you need to install minimum JDK 15.
You can download zip-archive from openJDK site [here](https://download.java.net/openjdk/jdk15/ri/openjdk-15+36_windows-x64_bin.zip).

Or download installer for your OS from Oracle website [here](https://www.oracle.com/java/technologies/downloads/)
in `Java Downloads` or `Java Archive` tab.
Installer is better as it has automated installation. You need Java SE. Also, 
to download from Oracle website you need to register. It's fast and easy so worth it.

Also you may download and unzip latest JRE [here](https://jdk.java.net/).
Which is actually preferable :slightly_smiling_face:

## How to start application:

If you have JRE/JDK installed just run exe file. Alternatively open `Start.cmd` script,
it will use `java.exe` of version 15, attached in source.

## How it works:

You need to put the **phrase** you want to encrypt/decrypt and a **key** phrase which is
sort of a password. Without knowing the key you will not be able to decrypt coded sequence
correctly.

There is an option to shift current coding table to the right. Made just for fun,
theoretically this adds additional security: to decrypt you must know a key **AND**
a shift value to get a correct coding table for algorithm.

So far there is only [Vigenère cipher](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher)
algorithm implemented. More ciphers will be added later.

Standard **Coding table** consists of characters allowed for input:
``
1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя ,.!?-ёЁ
``

## Things already done:

- Menu system
- Vigenère cipher implemented
- Coding table generating
- Coding table shift
- Additional characters in coding table such as punctuation and russian letter "Ёё"
  - It may be set in class CodeTable.java in ***additionalChars*** field. Need to recompile
  application after this change. So far this is a standard set of characters.

## Things I want to do:

- Add more ciphers
- Make input from and output to a text file
- Make an input and other options in command line arguments
- Create custom coding table by input of allowed characters by user
