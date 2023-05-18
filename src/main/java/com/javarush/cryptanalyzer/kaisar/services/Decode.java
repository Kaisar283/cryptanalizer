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

public class Decode implements Function {
    @Override
    public Result execute(HashMap<String, String> parameters) {
        String pathToDecrypt = parameters.get("PathToDecrypt");
        String patForDecryptedFile = FilePathes.DEFAULT_PATH_FOR_DECRYPTED_FILE;
        int keyForDecryptFile = Integer.parseInt(parameters.get("SecretKey"));
        try (FileReader in = new FileReader(pathToDecrypt);
             BufferedReader bufferedReader = new BufferedReader(in);
             FileWriter writer = new FileWriter(patForDecryptedFile)){

            String line;
            while ((line = bufferedReader.readLine()) != null){
                writer.write(decode(line, keyForDecryptFile));
                writer.write(System.lineSeparator());
            }
            bufferedReader.close();
            in.close();
        }catch (Exception e){
            return new Result(ResultCode.ERROR, new ApplicationEcxeption("Decode operation has finished with exception ", e));
        }
        return new Result(ResultCode.OK);
    }

    public static String decode(String encodedText, int key) {
        StringBuilder decryptedLine = new StringBuilder();
        for (int i = 0; i < encodedText.length(); i++) {
            char letter = encodedText.charAt(i);
            char decodedLetter = decodeLetter(letter, key);
            decryptedLine.append(decodedLetter);
        }
        return decryptedLine.toString();
    }

    public static char decodeLetter(char letter, int key) {
        int index = ALPHABET.indexOf(letter);
        if (index != -1) {
            int newIndex = (index - key + ALPHABET.length()) % ALPHABET.length();
            return ALPHABET.charAt(newIndex);
        } else {
            return letter;
        }
    }
}
