package(default_visibility = ["//src/test/java/com/jkurapati/sudoku/solve:__pkg__"])

java_binary(
    name = "SudokuUI",
    srcs = ["SudokuUI.java"],
    main_class = "com.jkurapati.sudoku.ui.SudokuUI",
    jvm_flags = [
        "--add-modules=javafx.controls,javafx.fxml",
        "--module-path /Users/jyothri/work/javafx-sdk-11.0.2/lib",
    ],
    deps = [
        "@maven//:org_apache_commons_commons_lang3",
        "@maven//:org_openjfx_javafx_controls_mac",
        "@maven//:org_openjfx_javafx_graphics_mac",
        "@maven//:org_openjfx_javafx_base_mac",
        "@maven//:org_openjfx_javafx_fxml_mac",
        ":SearchController",
    ],
    resources = ["SearchController.fxml", "search.css"],
)

java_library(
    name = "SearchController",
    srcs = ["SearchController.java"],
    deps = [
        "@maven//:org_apache_commons_commons_lang3",
        "@maven//:org_openjfx_javafx_controls_mac",
        "@maven//:org_openjfx_javafx_graphics_mac",
        "@maven//:org_openjfx_javafx_base_mac",
        "@maven//:org_openjfx_javafx_fxml_mac",
    ],
)