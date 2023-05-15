package view;

import constants.ConsoleDialogeConstants;
import entity.Result;

import javax.swing.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleView implements View{
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
        }
        return null;
    }

    @Override
    public void printResult(Result result) {

    }

    private HashMap<String, String> encodeDialogue(){
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("Mode", "1");
        System.out.println(ConsoleDialogeConstants.PATH_FOR_ENCRYPTION);
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        parameters.put("FilePath", filePath);
        System.out.println(ConsoleDialogeConstants.ENCRYPTED_PATH_MESSAGE);
        String encryptedFilePath = scanner.nextLine();
        if (encryptedFilePath.equals("D") || encryptedFilePath.equals("d")){
            parameters.put("PathForEncryptedFile", "Default");
        }else{
            parameters.put("PathForEncryptedFile", encryptedFilePath);
        }
        System.out.println(ConsoleDialogeConstants.SECRET_KEY_MESSAGE);
        String key = scanner.nextLine();
        parameters.put("SecretKey", key);
        return parameters;
    }

    private HashMap<String, String> decodeDialogue(){
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("Mode", "2");
        System.out.println(ConsoleDialogeConstants.PATH_FOR_DECRYPTION);
        Scanner scanner = new Scanner(System.in);
        String pathToDecrypt = scanner.nextLine();
        System.out.println(ConsoleDialogeConstants.KEY_FOR_DECRYPTION_MESSAGE);
        String key = scanner.nextLine();
        parameters.put("PathToDecrypt", pathToDecrypt);
        parameters.put("SecretKey", key);
        return parameters;
    }

}
