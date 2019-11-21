load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "2.10"

RULES_JVM_EXTERNAL_SHA = "1bbf2e48d07686707dd85357e9a94da775e1dbd7c464272b3664283c9c716d26"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "junit:junit:4.12",
        "org.apache.commons:commons-lang3:3.9",
        "org.openjfx:javafx-controls:mac:11.0.1",
        "org.openjfx:javafx-graphics:mac:11.0.1",
        "org.openjfx:javafx-base:mac:11.0.1",
        "org.openjfx:javafx-fxml:mac:11.0.1",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)
