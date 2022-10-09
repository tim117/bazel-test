load("@npm//@bazel/typescript:index.bzl", "ts_project")

ts_project(
    name = "express_controllers",
    srcs = glob(["*.ts"]),
    source_map = True,
    tsconfig = "//:tsconfig_base",
    visibility = ["//visibility:public"],
    deps = [
        "@npm//@types",
        "@npm//@types/express",
        "@npm//express",
    ],
)
