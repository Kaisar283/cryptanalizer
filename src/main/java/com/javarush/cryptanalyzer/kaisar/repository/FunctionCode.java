package repository;

import services.Decode;
import services.Encode;
import services.Function;

public enum FunctionCode {
    ENCODE(new Encode()), DECODE(new Decode());
    private Function function;
    FunctionCode(Function function) {this.function = function;}

    public Function getFunction() {
        return function;
    }
}
