workspace(name = "bwe")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

#####################################
############## Sky Lib ##############
#####################################
# bazel-skylib 0.8.0 released 2019.03.20 (https://github.com/bazelbuild/bazel-skylib/releases/tag/0.8.0)
http_archive(
    name = "bazel_skylib",
    sha256 = "af87959afe497dc8dfd4c6cb66e1279cb98ccc84284619ebfec27d9c09a903de",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/1.2.0/bazel-skylib-1.2.0.tar.gz",
        "https://github.com/bazelbuild/bazel-skylib/releases/download/1.2.0/bazel-skylib-1.2.0.tar.gz",
    ],
)

load("@bazel_skylib//:workspace.bzl", "bazel_skylib_workspace")

bazel_skylib_workspace()

##################################
############## Java ##############
##################################
# Spring boot rules for Java APIs
http_archive(
    name = "rules_spring",
    sha256 = "9385652bb92d365675d1ca7c963672a8091dc5940a9e307104d3c92e7a789c8e",
    urls = [
        "https://github.com/salesforce/rules_spring/releases/download/2.1.4/rules-spring-2.1.4.zip",
    ],
)

# Maven dependencies
http_archive(
    name = "rules_jvm_external",
    sha256 = "cd1a77b7b02e8e008439ca76fd34f5b07aecb8c752961f9640dea15e9e5ba1ca",
    strip_prefix = "rules_jvm_external-4.2",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.2.zip",
)

load("//third_party/maven:dependencies.bzl", "maven_dependencies")

maven_dependencies(maven_servers = ["https://repo1.maven.org/maven2/"])

####################################
################ GO ################
####################################
http_archive(
    name = "io_bazel_rules_go",
    sha256 = "d6b2513456fe2229811da7eb67a444be7785f5323c6708b38d851d2b51e54d83",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_go/releases/download/v0.30.0/rules_go-v0.30.0.zip",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.30.0/rules_go-v0.30.0.zip",
    ],
)

http_archive(
    name = "bazel_gazelle",
    sha256 = "de69a09dc70417580aabf20a28619bb3ef60d038470c7cf8442fafcf627c21cb",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-gazelle/releases/download/v0.24.0/bazel-gazelle-v0.24.0.tar.gz",
        "https://github.com/bazelbuild/bazel-gazelle/releases/download/v0.24.0/bazel-gazelle-v0.24.0.tar.gz",
    ],
)

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")
load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies")
load("//:third_party/go/go_deps.bzl", "go_dependencies")

# gazelle:repository_macro third_party/go/go_deps.bzl%go_dependencies
go_dependencies()

go_rules_dependencies()

go_register_toolchains(version = "1.18")

gazelle_dependencies()

####################################
############## Python ##############
####################################
# Load in Python configuration for the workspace.
rules_python_version = "740825b7f74930c62f44af95c9a4c1bd428d2c53"  # Latest @ 2021-06-23

http_archive(
    name = "rules_python",
    sha256 = "09a3c4791c61b62c2cbc5b2cbea4ccc32487b38c7a2cc8f87a794d7a659cc742",
    strip_prefix = "rules_python-{}".format(rules_python_version),
    url = "https://github.com/bazelbuild/rules_python/archive/{}.zip".format(rules_python_version),
)

load("@rules_python//python:pip.bzl", "pip_install")

# Create a central external repo, @python_deps, that contains Bazel targets for all the
# third-party packages specified in the requirements.txt file.
pip_install(
    name = "python_deps",
    python_interpreter = "python",
    requirements = "//third_party/python:requirements.txt",
)

####################################
############## NodeJS ##############
####################################
http_archive(
    name = "build_bazel_rules_nodejs",
    sha256 = "3ceb1e5b5dcad5fa2ad8870a20201cfbb9c9c63cac4055c9ab370034c765297f",
    urls = ["https://github.com/bazelbuild/rules_nodejs/releases/download/5.3.0/rules_nodejs-5.3.0.tar.gz"],
)

load("@build_bazel_rules_nodejs//:repositories.bzl", "build_bazel_rules_nodejs_dependencies")

build_bazel_rules_nodejs_dependencies()

# Fetches nodejs, npm, and yarn.
load("@build_bazel_rules_nodejs//:index.bzl", "node_repositories", "npm_install")

node_repositories(node_version = "17.7.2")

npm_install(
    name = "npm",
    package_json = "//:package.json",
    package_lock_json = "//:package-lock.json",
)
