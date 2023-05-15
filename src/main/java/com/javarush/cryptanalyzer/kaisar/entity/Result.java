package main.java.com.javarush.cryptanalyzer.kaisar.entity;

import main.java.com.javarush.cryptanalyzer.kaisar.ecxeption.ApplicationEcxeption;
import main.java.com.javarush.cryptanalyzer.kaisar.repository.ResultCode;


public class Result {
    private ResultCode resultCode;
    private ApplicationEcxeption applicationEcxeption;
    public Result(ResultCode resultCode){this.resultCode = resultCode;}
    public Result(ResultCode resultCode, ApplicationEcxeption applicationEcxeption){
        this.resultCode = resultCode;
        this.applicationEcxeption = applicationEcxeption;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
    public ApplicationEcxeption getApplicationEcxeption(){
        return applicationEcxeption;
    }
}
