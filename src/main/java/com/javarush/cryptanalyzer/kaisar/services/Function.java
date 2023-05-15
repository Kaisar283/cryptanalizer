package main.java.com.javarush.cryptanalyzer.kaisar.services;
import main.java.com.javarush.cryptanalyzer.kaisar.entity.Result;
import java.util.HashMap;

public interface Function {
    Result execute(HashMap<String, String> parameters);
}
