load("@rules_spring//springboot:springboot.bzl", "springboot")

java_library(
    name = "lib",
    srcs = glob(["*.java"]),
    resources = glob(["resources/**"]),
    visibility = ["//javatests:__subpackages__"],
    deps = [
        "//java/com/bwe/hello/controller",
        "//third_party/java/spring_boot",
    ],
)

springboot(
    name = "app",
    boot_app_class = "com.bwe.hello.server.HelloApplication",
    java_library = ":lib",
)
