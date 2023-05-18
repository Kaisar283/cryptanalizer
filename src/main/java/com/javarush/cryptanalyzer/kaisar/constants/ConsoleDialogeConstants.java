package main.java.com.javarush.cryptanalyzer.kaisar.constants;

import javax.swing.plaf.PanelUI;

public class ConsoleDialogeConstants {
    public static final String GREETING_MESSAGE = "Welcome to the cryptanalyzer.\n The program allows you to encrypt or decrypt your messages.\n ";
    public static final String CHOOSE_MODE_MESSAGE = "Please press \"1\" to encrypt, press \"2\" to decrypt, press \"3\" to start brut force : ";
    public static final  String PATH_FOR_ENCRYPTION = "Please enter the file path for encryption or press \"Enter\" to set default path: ";
    public static final String ENCRYPTED_PATH_MESSAGE = "Please specify the path to save the encrypted file or press \"D\" for save the default file.\n"+
                                                        "or enter file path manually";
    public static final String SECRET_KEY_MESSAGE = "Please enter the encryption key or press \"Enter\" to set random key: ";
    public static final String PATH_FOR_DECRYPTION = "Please enter the file path for decryption: ";
    public static final String INCORRECT_MODE_MESSAGE = "Incorrect mode chosen!!!";
    public static final String KEY_FOR_DECRYPTION_MESSAGE = "Please enter the encryption key: ";
    public static final String CYCLE_MESSAGE = "If you want to finish working further, enter \"exit\""+
            "or just press \"Enter\" to continue working ... ";
    public static final String BRUTE_FORCE_MESSAGE = "specify the path to the file for brute force, or just press \"Enter\" to demonstrate";
    public static final String BF_OUTPUT_MESSAGE = "The decrypted file will save in \"output.txt\"";
    public static final String EMPTY_FILE_PATH = "Please enter file path: ";

    public static final String REPORT_KEY = "Your encryption key is: ";

}
