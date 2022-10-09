load("@io_bazel_rules_go//go:def.bzl", "go_library")

go_library(
    name = "validations",
    srcs = ["validations.go"],
    importpath = "github.com/bwe/bwe/apps/api/go_reading_oasis/validations",
    visibility = ["//visibility:public"],
    deps = [
        "//apps/api/go_reading_oasis/models",
        "@com_github_gin_gonic_gin//:gin",
    ],
)
