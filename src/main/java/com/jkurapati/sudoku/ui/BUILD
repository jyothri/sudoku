package(default_visibility = ["//src/test/java/com/jkurapati/sudoku/solve:__pkg__"])

java_binary(
    name = "SudokuUI",
    srcs = ["SudokuUI.java"],
    jvm_flags = [
        "--add-modules=javafx.controls,javafx.fxml",
        "--module-path /Users/jyothri/work/javafx-sdk-11.0.2/lib",
    ],
    main_class = "com.jkurapati.sudoku.ui.SudokuUI",
    resources = [
        "SudokuController.fxml",
        "sudoku.css",
    ],
    deps = [
        "@maven//:org_openjfx_javafx_fxml_mac",
        "@maven//:org_openjfx_javafx_graphics_mac",
    ],
)

java_library(
    name = "SearchController",
    srcs = ["SearchController.java"],
    deps = [
        "@maven//:org_openjfx_javafx_controls_mac",
        "@maven//:org_openjfx_javafx_fxml_mac",
        "@maven//:org_openjfx_javafx_graphics_mac",
    ],
)
