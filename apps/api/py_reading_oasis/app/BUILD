load("@rules_python//python:defs.bzl", "py_library")

py_library(
    name = "app",
    srcs = glob(["*.py"]),
    data = glob(["templates/*"]),
    visibility = ["//apps/api/py_reading_oasis:__subpackages__"],
    deps = [
        "//apps/api/py_reading_oasis/controllers",
        "//apps/api/py_reading_oasis/database",
        "//apps/api/py_reading_oasis/exceptions",
        "//third_party/python:flask",
    ],
)
