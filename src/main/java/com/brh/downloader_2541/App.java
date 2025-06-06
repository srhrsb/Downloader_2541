package com.brh.downloader_2541;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Downloader 2541");
        stage.setScene(scene);
        stage.show();
        App.stage = stage;
    }

    public static Stage getStage(){
        return stage;
    }





















    public static void main(String[] args) {
        launch();
    }
}