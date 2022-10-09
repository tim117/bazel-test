load("@bazel_gazelle//:def.bzl", "gazelle")
load("@npm//@bazel/typescript:index.bzl", "ts_config")

# gazelle:prefix github.com/bwe/bwe
gazelle(name = "gazelle")

gazelle(
    name = "gazelle-update-repos",
    args = [
        "-from_file=go.mod",
        "-to_macro=third_party/go/go_deps.bzl%go_dependencies",
        "-prune",
        "-build_file_proto_mode=disable_global",
    ],
    command = "update-repos",
)

ts_config(
    name = "tsconfig_base",
    src = "tsconfig.base.json",
    visibility = ["//visibility:public"],
)
