load("@io_bazel_rules_go//go:def.bzl", "go_binary", "go_library")

go_binary(
    name = "go_reading_oasis",
    embed = [":lib"],
    visibility = ["//visibility:public"],
)

go_library(
    name = "lib",
    srcs = ["server.go"],
    embedsrcs = glob(["views/*"]),
    importpath = "github.com/bwe/bwe/apps/api/go_reading_oasis",
    visibility = ["//visibility:private"],
    deps = [
        "//apps/api/go_reading_oasis/controllers",
        "//apps/api/go_reading_oasis/data",
        "@com_github_gin_gonic_gin//:gin",
    ],
)
