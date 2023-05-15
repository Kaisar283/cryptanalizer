package main.java.com.javarush.cryptanalyzer.kaisar.services;


import main.java.com.javarush.cryptanalyzer.kaisar.constants.AlphabetMap;
import main.java.com.javarush.cryptanalyzer.kaisar.constants.FilePathes;
import main.java.com.javarush.cryptanalyzer.kaisar.ecxeption.ApplicationEcxeption;
import main.java.com.javarush.cryptanalyzer.kaisar.entity.Result;
import main.java.com.javarush.cryptanalyzer.kaisar.repository.ResultCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Decode implements Function {
    @Override
    public Result execute(HashMap<String, String> parameters) {
        String pathToDecrypt = parameters.get("PathToDecrypt");
        String patForDecryptedFile = FilePathes.DEFAULT_PATH_FOR_DECRYPTED_FILE;
        int keyForDecryptFile = Integer.parseInt(parameters.get("SecretKey"));
        try (FileReader in = new FileReader(pathToDecrypt);
             BufferedReader bufferedReader = new BufferedReader(in);
             FileWriter writer = new FileWriter(patForDecryptedFile)){

            while (bufferedReader.ready()){
                int letter =  bufferedReader.read();

                if (AlphabetMap.alphabetMap.containsValue(letter)){
                    Integer decryptedValue = (letter - keyForDecryptFile) % AlphabetMap.alphabetMap.size();

                    char value = getKeyByValue(AlphabetMap.alphabetMap, decryptedValue);
                    writer.write(value);

                }
            }
        }catch (Exception e){
            return new Result(ResultCode.ERROR, new ApplicationEcxeption("Decode operation has finished with exception ", e));
        }
        return new Result(ResultCode.OK);
    }

    public static Character getKeyByValue(Map<Character, Integer> map, Integer value) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())){
                return entry.getKey();
            }
        }
        return '\n';
    }
}
