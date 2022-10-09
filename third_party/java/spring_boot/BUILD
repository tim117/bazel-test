package(default_visibility = ["//visibility:public"])

java_library(
    name = "spring_boot",
    exports = [
        ":required_deps",
        ":starter_jetty",
        ":starter_web",
    ],
)

java_library(
    name = "required_deps",
    exports = [
        ":actuator",
        ":actuator_autoconfigure",
        ":aop",
        ":autoconfigure",
        ":beans",
        ":context",
        ":core",
        ":expression",
        ":lib",
        ":loader",
        ":starter",
        ":starter_logging",
        ":web",
    ],
)

java_library(
    name = "test",
    exports = [
        ":beans",
        ":framework_test_lib",
        ":test_lib",
    ],
)

java_library(
    name = "lib",
    exports = ["@maven//:org_springframework_boot_spring_boot"],
)

java_library(
    name = "actuator",
    exports = ["@maven//:org_springframework_boot_spring_boot_actuator"],
)

java_library(
    name = "actuator_autoconfigure",
    exports = ["@maven//:org_springframework_boot_spring_boot_actuator_autoconfigure"],
)

java_library(
    name = "autoconfigure",
    exports = ["@maven//:org_springframework_boot_spring_boot_autoconfigure"],
)

java_library(
    name = "loader",
    exports = ["@maven//:org_springframework_boot_spring_boot_loader"],
)

java_library(
    name = "jpa",
    exports = [
        ":data_jpa",
        "@maven//:jakarta_persistence_jakarta_persistence_api",
        "@maven//:org_springframework_boot_spring_boot_starter_data_jpa",
        "@maven//:org_springframework_boot_spring_boot_starter_jdbc",
    ],
)

java_library(
    name = "data_jpa",
    exports = [
        "@maven//:org_slf4j_slf4j_api",
        "@maven//:org_springframework_data_spring_data_commons",
        "@maven//:org_springframework_data_spring_data_jpa",
        "@maven//:org_springframework_spring_aop",
        "@maven//:org_springframework_spring_beans",
        "@maven//:org_springframework_spring_context",
        "@maven//:org_springframework_spring_core",
        "@maven//:org_springframework_spring_orm",
        "@maven//:org_springframework_spring_tx",
    ],
)

java_library(
    name = "starter",
    exports = ["@maven//:org_springframework_boot_spring_boot_starter"],
)

java_library(
    name = "starter_logging",
    exports = ["@maven//:org_springframework_boot_spring_boot_starter_logging"],
)

java_library(
    name = "aop",
    exports = ["@maven//:org_springframework_spring_aop"],
)

java_library(
    name = "beans",
    exports = ["@maven//:org_springframework_spring_beans"],
)

java_library(
    name = "context",
    exports = ["@maven//:org_springframework_spring_context"],
)

java_library(
    name = "core",
    exports = ["@maven//:org_springframework_spring_core"],
)

java_library(
    name = "expression",
    exports = ["@maven//:org_springframework_spring_expression"],
)

java_library(
    name = "web",
    exports = ["@maven//:org_springframework_spring_web"],
)

java_library(
    name = "webmvc",
    exports = ["@maven//:org_springframework_spring_webmvc"],
)

java_library(
    name = "starter_jetty",
    exports = ["@maven//:org_springframework_boot_spring_boot_starter_jetty"],
)

java_library(
    name = "starter_web",
    exports = ["@maven//:org_springframework_boot_spring_boot_starter_web"],
)

java_library(
    name = "test_lib",
    exports = [
        "@maven//:org_springframework_boot_spring_boot_test",
    ],
)

java_library(
    name = "framework_test_lib",
    exports = ["@maven//:org_springframework_spring_test"],
)
