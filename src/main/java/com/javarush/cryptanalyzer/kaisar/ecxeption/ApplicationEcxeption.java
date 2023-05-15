package main.java.com.javarush.cryptanalyzer.kaisar.ecxeption;

public class ApplicationEcxeption extends RuntimeException{
    public ApplicationEcxeption(){
    }
    public ApplicationEcxeption(String message){
        super(message);
    }
    public ApplicationEcxeption(String message, Throwable cause){
        super(message, cause);
    }
    public ApplicationEcxeption(Throwable cause){
        super(cause);
    }
}
