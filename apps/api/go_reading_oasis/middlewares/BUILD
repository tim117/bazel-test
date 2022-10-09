load("@io_bazel_rules_go//go:def.bzl", "go_library")

go_library(
    name = "middlewares",
    srcs = ["book_middlewares.go"],
    importpath = "github.com/bwe/bwe/apps/api/go_reading_oasis/middlewares",
    visibility = ["//visibility:public"],
    deps = [
        "//apps/api/go_reading_oasis/validations",
        "@com_github_gin_gonic_gin//:gin",
    ],
)
