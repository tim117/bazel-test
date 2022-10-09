load("@npm//@bazel/typescript:index.bzl", "ts_project")
load("@build_bazel_rules_nodejs//:index.bzl", "nodejs_binary")

ts_project(
    name = "lib",
    srcs = glob(
        [
            "*.ts",
            "**/*.ts",
        ],
    ),
    tsconfig = "//:tsconfig_base",
    deps = ["//libs/express_controllers"],
)

nodejs_binary(
    name = "ts_reading_oasis",
    data = [":lib"],
    entrypoint = ":server.ts",
)
