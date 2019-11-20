package com.jkurapati.sudoku.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SearchController {
    private static final int SUDOKU_DIMENSION = 3;

    @FXML
    private Button solveButton;

    @FXML
    private GridPane outerGridPane;

    @FXML
    private void initialize() {
        populateSudokuCells();

        solveButton.setOnAction(event -> System.out.println("Got event:" + event));
    }

    private void populateSudokuCells() {
        outerGridPane.getStyleClass().add("outerGridPane");
        for (int i = 0; i < SUDOKU_DIMENSION; i++) {
            for (int j = 0; j < SUDOKU_DIMENSION; j++) {
                GridPane innerGridPane = new GridPane();
                innerGridPane.getStyleClass().add("innerGridPane");
                int block = i * SUDOKU_DIMENSION + j;
                outerGridPane.add(innerGridPane, j, i, 1, 1);
                populateBlock(block, innerGridPane);
            }
        }
    }

    private void populateBlock(int block, GridPane gridPane) {
        for (int i = 0; i < SUDOKU_DIMENSION; i++) {
            for (int j = 0; j < SUDOKU_DIMENSION; j++) {
                TextField textField = new TextField();
                String cellId = String.format("block%d-row%d-col%d", block, i, j);
                textField.setId(cellId);
                textField.setText("X");
                textField.getStyleClass().add("cell");
                gridPane.add(textField, j, i, 1, 1);
            }
        }
    }
}
