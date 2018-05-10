import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
      Spect spect = new Spect();
        spect.work();
    }

    public static void main(String[] args){launch(args);}
}