package main.java.com.javarush.cryptanalyzer.kaisar.view;

import main.java.com.javarush.cryptanalyzer.kaisar.constants.ConsoleDialogeConstants;
import main.java.com.javarush.cryptanalyzer.kaisar.entity.Result;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

import static main.java.com.javarush.cryptanalyzer.kaisar.constants.ConsoleDialogeConstants.REPORT_KEY;
import static main.java.com.javarush.cryptanalyzer.kaisar.constants.FilePathes.DEFAULT_ENCRYPTED_PATH;
import static main.java.com.javarush.cryptanalyzer.kaisar.constants.FilePathes.DEFAULT_INPUT_PATH;
import static main.java.com.javarush.cryptanalyzer.kaisar.constants.Rus_Alphabet.ALPHABET;

public class ConsoleView implements View {
    @Override
    public HashMap<String, String> getParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleDialogeConstants.GREETING_MESSAGE);
        System.out.println(ConsoleDialogeConstants.CHOOSE_MODE_MESSAGE);
        String mode = scanner.nextLine();
        if (Integer.parseInt(mode) == 1){
             return encodeDialogue();
        }else if(Integer.parseInt(mode) == 2) {
            return decodeDialogue();
        } else if (Integer.parseInt(mode) == 3) {
            return brutForceDialog();
        } else {
            System.out.println(ConsoleDialogeConstants.INCORRECT_MODE_MESSAGE);
            getParameters();
        }
        return null;
    }

    @Override
    public void printResult(Result result) {

    }

    private HashMap<String, String> encodeDialogue(){
        HashMap<String, String> parameters = new HashMap<>();
        Random random = new Random();

        System.out.println(ConsoleDialogeConstants.PATH_FOR_ENCRYPTION);
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        if (filePath.isEmpty()){
            filePath = DEFAULT_INPUT_PATH;
        }

        System.out.println(ConsoleDialogeConstants.ENCRYPTED_PATH_MESSAGE);
        String encryptedFilePath = scanner.nextLine();
        if (encryptedFilePath.equals("D") || encryptedFilePath.equals("d")){
            parameters.put("PathForEncryptedFile", "Default");
        }else{
            parameters.put("PathForEncryptedFile", encryptedFilePath);
        }

        System.out.println(ConsoleDialogeConstants.SECRET_KEY_MESSAGE);
        String key = scanner.nextLine();
        if (key.isEmpty() || key.isBlank()){
            key = String.valueOf(random.nextInt(ALPHABET.length()));
        }
        System.out.println(REPORT_KEY + key);

        parameters.put("Mode", "1");
        parameters.put("FilePath", filePath);
        parameters.put("SecretKey", key);
        return parameters;
    }

    private HashMap<String, String> decodeDialogue(){
        HashMap<String, String> parameters = new HashMap<>();

        System.out.println(ConsoleDialogeConstants.PATH_FOR_DECRYPTION);
        Scanner scanner = new Scanner(System.in);
        String pathToDecrypt = scanner.nextLine();
        System.out.println(ConsoleDialogeConstants.KEY_FOR_DECRYPTION_MESSAGE);
        String key = scanner.nextLine();

        parameters.put("Mode", "2");
        parameters.put("PathToDecrypt", pathToDecrypt);
        parameters.put("SecretKey", key);
        return parameters;
    }

    private HashMap<String, String> brutForceDialog(){
        HashMap<String,String> parameters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleDialogeConstants.BRUTE_FORCE_MESSAGE);
        String filePath = scanner.nextLine();
        if (filePath.equals("")) filePath = DEFAULT_ENCRYPTED_PATH;
        System.out.println(ConsoleDialogeConstants.BF_OUTPUT_MESSAGE);

        parameters.put("Mode", "3");
        parameters.put("BrutForceFilePath", filePath);
        return parameters;
    }


}
