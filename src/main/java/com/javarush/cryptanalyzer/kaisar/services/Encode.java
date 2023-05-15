package services;

import ecxeption.ApplicationEcxeption;
import entity.Result;
import repository.ResultCode;
import constants.AlphabetMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import constants.FilePathes;

public class Encode implements Function{
    @Override
    public Result execute(HashMap<String, String> parameters) {
        String pathToEncrypt = parameters.get("FilePath");
        int keyForEncrypt = Integer.parseInt(parameters.get("SecretKey"));
        String pathForEncryptedFile = parameters.get("PathForEncryptedFile");
        if (pathForEncryptedFile.equals("Default")){
            pathForEncryptedFile = FilePathes.DEFAULT_ENCRYPTED_PATH;
        }

        try (FileReader in = new FileReader(pathToEncrypt);
             BufferedReader bufferedReader = new BufferedReader(in);
             FileWriter writer = new FileWriter(pathForEncryptedFile)){

            while (bufferedReader.ready()){
                char letter = (char) bufferedReader.read();
                if (AlphabetMap.alphabetMap.containsKey(letter)){
                    int key = AlphabetMap.alphabetMap.get(letter);
                    int cryptedValue = (key + keyForEncrypt) % AlphabetMap.alphabetMap.size();
                    writer.write(cryptedValue);
                }
            }
        }catch (Exception e){
            return new Result(ResultCode.ERROR, new ApplicationEcxeption("Decode operation has finished with exception ", e));
        }
        return new Result(ResultCode.OK);
    }
}
