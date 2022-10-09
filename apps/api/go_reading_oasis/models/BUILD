load("@io_bazel_rules_go//go:def.bzl", "go_library")

go_library(
    name = "models",
    srcs = [
        "api_error.go",
        "book.go",
        "create_book.go",
        "get_book.go",
        "list_books.go",
        "pagination.go",
        "update_book.go",
    ],
    importpath = "github.com/bwe/bwe/apps/api/go_reading_oasis/models",
    visibility = ["//visibility:public"],
    deps = ["@com_github_google_uuid//:uuid"],
)
