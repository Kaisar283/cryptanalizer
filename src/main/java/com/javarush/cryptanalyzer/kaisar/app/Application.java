package main.java.com.javarush.cryptanalyzer.kaisar.app;
import main.java.com.javarush.cryptanalyzer.kaisar.controller.MainController;
import main.java.com.javarush.cryptanalyzer.kaisar.entity.Result;
import main.java.com.javarush.cryptanalyzer.kaisar.repository.FunctionCode;
import main.java.com.javarush.cryptanalyzer.kaisar.services.Function;

import java.util.HashMap;

import static main.java.com.javarush.cryptanalyzer.kaisar.constants.FunctionCodeConstants.*;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController){
        this.mainController = mainController;
    }

    public Result run(){
        HashMap<String, String> parameters = mainController.getView().getParameters();
        String mode = parameters.get("Mode");
        Function function = getFunction(mode);
        return function.execute(parameters);
    }
    private  Function getFunction(String mode){
        return switch (mode){
            case "1" -> FunctionCode.valueOf(ENCODE).getFunction();
            case "2" -> FunctionCode.valueOf(DECODE).getFunction();
            case "3" -> FunctionCode.valueOf(BRUTEFORCE).getFunction();
            default -> throw new IllegalStateException("Unexpected value: " + mode);
        };
    }
    public void printResult(Result result){
        mainController.getView().printResult(result);
    }

}
