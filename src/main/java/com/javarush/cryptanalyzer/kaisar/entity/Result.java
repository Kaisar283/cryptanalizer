package entity;

import ecxeption.ApplicationEcxeption;
import repository.ResultCode;

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
