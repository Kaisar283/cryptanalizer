package services;

import entity.Result;

import java.util.HashMap;

public interface Function {
    Result execute(HashMap<String, String> parameters);
}
