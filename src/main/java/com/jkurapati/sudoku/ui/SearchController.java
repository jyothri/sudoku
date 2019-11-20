package com.jkurapati.sudoku.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchController {
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;

    @FXML
    private void initialize() {
        // search panel
        searchButton.setText("Search");
//        searchButton.setOnAction(event -> loadData());
    }
}
