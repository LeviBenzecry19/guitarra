package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        Quiz quiz = new Quiz();
        primaryStage.setScene(quiz.getScene());
        primaryStage.setTitle("Perfil de Investidor");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        
    }
}
