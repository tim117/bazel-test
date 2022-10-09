load("@io_bazel_rules_go//go:def.bzl", "go_library")

go_library(
    name = "data",
    srcs = [
        "books.go",
        "db_connection.go",
    ],
    importpath = "github.com/bwe/bwe/apps/api/go_reading_oasis/data",
    visibility = ["//visibility:public"],
    deps = [
        "//apps/api/go_reading_oasis/models",
        "@io_gorm_driver_sqlite//:sqlite",
        "@io_gorm_gorm//:gorm",
    ],
)
