load("@io_bazel_rules_go//go:def.bzl", "go_library")

go_library(
    name = "controllers",
    srcs = ["books.go"],
    importpath = "github.com/bwe/bwe/apps/api/go_reading_oasis/controllers",
    visibility = ["//visibility:public"],
    deps = [
        "//apps/api/go_reading_oasis/middlewares",
        "//apps/api/go_reading_oasis/models",
        "//apps/api/go_reading_oasis/services",
        "@com_github_gin_gonic_gin//:gin",
    ],
)
