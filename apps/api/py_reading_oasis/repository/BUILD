load("@rules_python//python:defs.bzl", "py_library")

py_library(
    name = "repository",
    srcs = glob(["*.py"]),
    visibility = ["//apps/api/py_reading_oasis:__subpackages__"],
    deps = [
        "//apps/api/py_reading_oasis/database",
    ],
)
