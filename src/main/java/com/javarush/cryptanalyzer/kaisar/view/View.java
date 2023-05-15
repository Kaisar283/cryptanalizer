package main.java.com.javarush.cryptanalyzer.kaisar.view;

import main.java.com.javarush.cryptanalyzer.kaisar.entity.Result;

import java.util.HashMap;

public interface View {
    HashMap<String, String> getParameters();

    void printResult(Result result);

}
