load("@rules_python//python:defs.bzl", "py_library")
load("@python_deps//:requirements.bzl", "requirement")

py_library(
    name = "flask",
    visibility = ["//visibility:public"],
    deps = [requirement("flask")],
)

py_library(
    name = "sqlalchemy",
    visibility = ["//visibility:public"],
    deps = [requirement("flask-sqlalchemy")],
)
