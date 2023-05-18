package main.java.com.javarush.cryptanalyzer.kaisar.services;

import main.java.com.javarush.cryptanalyzer.kaisar.services.Function;
import main.java.com.javarush.cryptanalyzer.kaisar.constants.FilePathes;
import main.java.com.javarush.cryptanalyzer.kaisar.ecxeption.ApplicationEcxeption;
import main.java.com.javarush.cryptanalyzer.kaisar.entity.Result;
import main.java.com.javarush.cryptanalyzer.kaisar.repository.ResultCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import static main.java.com.javarush.cryptanalyzer.kaisar.constants.Rus_Alphabet.ALPHABET;


public class Encode implements Function {
    @Override
    public Result execute(HashMap<String, String> parameters) {
        String pathToEncrypt = parameters.get("FilePath");
        int keyForEncrypt = Integer.parseInt(parameters.get("SecretKey"));
        String pathForEncryptedFile = parameters.get("PathForEncryptedFile");
        if (pathForEncryptedFile.equals("Default")) {
            pathForEncryptedFile = FilePathes.DEFAULT_ENCRYPTED_PATH;
        }

        try (FileReader in = new FileReader(pathToEncrypt);
             BufferedReader bufferedReader = new BufferedReader(in);
             FileWriter writer = new FileWriter(pathForEncryptedFile)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder encryptedLine = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char letter = line.charAt(i);
                    char encodedLetter = encodeLetter(letter, keyForEncrypt);
                    encryptedLine.append(encodedLetter);
                }
                writer.write(encryptedLine.toString());
                writer.write(System.lineSeparator());
            }
            bufferedReader.close();
            in.close();
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationEcxeption(
                    "Decode operation has finished with exception ", e));
        }
        return new Result(ResultCode.OK);
    }

    private static char encodeLetter(char letter, int key){
        int index = ALPHABET.indexOf(letter);
        if (index != -1) {
            int newIndex = (index + key) % ALPHABET.length();
            return ALPHABET.charAt(newIndex);
        } else {
            return letter;
        }
    }
}