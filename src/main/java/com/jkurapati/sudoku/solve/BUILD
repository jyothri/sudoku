package(default_visibility = ["//src/test/java/com/jkurapati/sudoku/solve:__pkg__"])

java_library(
    name = "Solution",
    srcs = ["Solution.java"],
    deps = [
        "@maven//:org_apache_commons_commons_lang3",
        ":Board",
    ]
)

java_library(
    name = "Board",
    srcs = ["Board.java"],
    deps = [
        ":Observable",
    ]
)

java_library(
    name = "Observable",
    srcs = ["Observable.java"],
    deps = [
    ]
)