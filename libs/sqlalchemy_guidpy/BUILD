load("@rules_python//python:defs.bzl", "py_library")

py_library(
    name = "sqlalchemy_guidpy",
    srcs = glob(
        ["*.py"],
        exclude = ["*_test.py"],
    ),
    visibility = ["//visibility:public"],
    deps = ["//third_party/python:sqlalchemy"],
)

py_test(
    name = "test",
    srcs = glob(["*_test.py"]),
    main = "guid_test.py",
    deps = [":sqlalchemy_guidpy"],
)
