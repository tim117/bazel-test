load("@rules_python//python:defs.bzl", "py_library")

py_library(
    name = "services",
    srcs = glob(["*.py"]),
    visibility = ["//apps/api/py_reading_oasis:__subpackages__"],
    deps = [
        "//apps/api/py_reading_oasis/exceptions",
        "//apps/api/py_reading_oasis/models",
        "//apps/api/py_reading_oasis/repository",
    ],
)
