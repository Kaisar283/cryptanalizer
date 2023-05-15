package main.java.com.javarush.cryptanalyzer.kaisar.repository;
import main.java.com.javarush.cryptanalyzer.kaisar.services.Encode;
import main.java.com.javarush.cryptanalyzer.kaisar.services.Decode;
import main.java.com.javarush.cryptanalyzer.kaisar.services.Function;

public enum FunctionCode {
    ENCODE(new Encode()), DECODE(new Decode());
    private Function function;
    FunctionCode(Function function) {this.function = function;}

    public Function getFunction() {
        return function;
    }
}
