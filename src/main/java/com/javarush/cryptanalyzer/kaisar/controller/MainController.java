package main.java.com.javarush.cryptanalyzer.kaisar.controller;
import main.java.com.javarush.cryptanalyzer.kaisar.view.View;

public class MainController {
    private View view;
    public MainController(View view){
        this.view = view;
    }

    public View getView(){
        return view;
    }

}
