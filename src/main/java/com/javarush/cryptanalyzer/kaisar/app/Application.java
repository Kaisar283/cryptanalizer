package app;

import controller.MainController;
import entity.Result;
import repository.FunctionCode;
import services.Function;

import java.util.HashMap;

import static constants.FunctionCodeConstants.DECODE;
import static constants.FunctionCodeConstants.ENCODE;

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
            default -> throw new IllegalStateException("Unexpected value: " + mode);
        };
    }
    public void printResult(Result result){
        mainController.getView().printResult(result);
    }

}
