package(default_visibility = ["//src/test/java/com/jkurapati/sudoku/solve:__pkg__"])

java_library(
    name = "Solution",
    srcs = ["Solution.java"],
    deps = [
        ":Board",
        "@maven//:org_apache_commons_commons_lang3",
    ],
)

java_library(
    name = "Board",
    srcs = ["Board.java"],
    deps = [
        ":Observable",
    ],
)

java_library(
    name = "Observable",
    srcs = ["Observable.java"],
    deps = [
    ],
)
