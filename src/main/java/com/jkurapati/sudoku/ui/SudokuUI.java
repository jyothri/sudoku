package com.jkurapati.sudoku.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuUI extends Application {

    private static final String FXML_FILE = "/com/jkurapati/sudoku/ui/SudokuController.fxml";
    private static final String CSS_FILE = "/com/jkurapati/sudoku/ui/sudoku.css";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                SudokuUI.class.getResource(FXML_FILE));
        AnchorPane page = loader.load();
        Scene scene = new Scene(page);

        scene.getStylesheets().add(CSS_FILE);

        primaryStage.setTitle("Sudoku Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
