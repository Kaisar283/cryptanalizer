package view;

import entity.Result;

import java.util.HashMap;

public interface View {
    HashMap<String, String> getParameters();

    void printResult(Result result);

}
