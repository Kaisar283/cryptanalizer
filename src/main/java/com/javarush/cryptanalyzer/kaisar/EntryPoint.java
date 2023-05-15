package main.java.com.javarush.cryptanalyzer.kaisar;
import main.java.com.javarush.cryptanalyzer.kaisar.app.Application;
import main.java.com.javarush.cryptanalyzer.kaisar.controller.MainController;
import main.java.com.javarush.cryptanalyzer.kaisar.entity.Result;
import main.java.com.javarush.cryptanalyzer.kaisar.view.ConsoleView;
import main.java.com.javarush.cryptanalyzer.kaisar.view.View;

public class EntryPoint {

    public static void main(String[] args) {
        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        Result result = application.run();
        application.printResult(result);
    }

}
