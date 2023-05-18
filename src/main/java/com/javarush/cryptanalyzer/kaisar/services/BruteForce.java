package main.java.com.javarush.cryptanalyzer.kaisar.services;
import main.java.com.javarush.cryptanalyzer.kaisar.services.Function;
import main.java.com.javarush.cryptanalyzer.kaisar.entity.Result;
import main.java.com.javarush.cryptanalyzer.kaisar.repository.ResultCode;

import java.io.*;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.net.URL;
import java.net.HttpURLConnection;


import static main.java.com.javarush.cryptanalyzer.kaisar.constants.FilePathes.BRUT_FORCE_OUTPUT;
import static main.java.com.javarush.cryptanalyzer.kaisar.constants.Rus_Alphabet.ALPHABET;
import static main.java.com.javarush.cryptanalyzer.kaisar.services.Decode.decode;

public class BruteForce implements Function {
    @Override
    public Result execute(HashMap<String, String> parameters) {
        String filePath = parameters.get("BrutForceFilePath");
        try (FileReader in = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(in);
             FileWriter writer = new FileWriter(BRUT_FORCE_OUTPUT)){
            String decodedText = bufferedReader.readLine();
            decodedText = decodedText.substring(0, 30);
            int key = bruteForceAttack(decodedText);
            System.out.println("\nI found key: "+ key);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                writer.write(decode(line, key));
                writer.write(System.lineSeparator());
            }
            bufferedReader.close();
            in.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }


    private static int bruteForceAttack(String encodedText) {
        int rightKey = -1;
        System.out.println("Brut Force in progress, please wait!\n");
        for (int key = 1; key < ALPHABET.length(); key++) {
            String decodedText = decode(encodedText, key);
            String[] words = decodedText.split(" ");
            if (words.length > 2){
                for (int i = 0; i < 3; i++){
                    if((words[i].length() > 2) && checkWordInWiktionary(words[i])){
                        rightKey = key;
                    }
                }
            }
            System.out.print("*");
        }
        return rightKey;
    }

    private static boolean checkWordInWiktionary(String word) {

        try  {
            URL url = new URL("https://ru.wiktionary.org/wiki/" + word);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            if (responseCode == 200){
                return true;
            }
        } catch (IOException e) {
            return false;
        }

        return false;
    }

  }
