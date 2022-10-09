load("@rules_spring//springboot:springboot.bzl", "springboot")

java_library(
    name = "lib",
    srcs = glob(["*.java"]),
    resource_strip_prefix = "java/com/bwe/readingoasis/resources/",
    resources = ["//java/com/bwe/readingoasis/resources"],
    visibility = ["//javatests:__subpackages__"],
    deps = [
        "//java/com/bwe/readingoasis/controller",
        "//java/com/bwe/readingoasis/exception/handler",
        "//java/com/bwe/sqlite:dialect",
        "//third_party/java/database:sqlite",
        "//third_party/java/hibernate",
        "//third_party/java/slf4j",
        "//third_party/java/spring_boot",
        "//third_party/java/spring_boot:aop",
        "//third_party/java/spring_boot:jpa",
    ],
)

springboot(
    name = "app",
    boot_app_class = "com.bwe.readingoasis.BooksApplication",
    java_library = ":lib",
)
