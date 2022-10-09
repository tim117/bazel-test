load("@rules_python//python:defs.bzl", "py_binary", "py_library")

py_library(
    name = "lib",
    srcs = glob(["*.py"]),
    deps = [
        "//apps/api/py_reading_oasis/app",
        "//apps/api/py_reading_oasis/controllers",
        "//apps/api/py_reading_oasis/database",
    ],
)

py_binary(
    name = "py_reading_oasis",
    srcs = ["server.py"],
    main = "server.py",
    deps = [":lib"],
)
