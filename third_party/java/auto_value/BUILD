java_plugin(
    name = "auto_annotation_plugin",
    processor_class = "com.google.auto.value.processor.AutoAnnotationProcessor",
    deps = [":lib"],
)

java_plugin(
    name = "auto_oneof_plugin",
    processor_class = "com.google.auto.value.processor.AutoOneOfProcessor",
    deps = [":lib"],
)

java_plugin(
    name = "auto_value_plugin",
    processor_class = "com.google.auto.value.processor.AutoValueProcessor",
    visibility = ["//visibility:public"],  # FastBuildCompilerFactoryImplTest uses this
    deps = [":lib"],
)

# provides both the jar for compilation and the java_plugin.
java_library(
    name = "auto_value",
    exported_plugins = [
        ":auto_annotation_plugin",
        ":auto_oneof_plugin",
        ":auto_value_plugin",
    ],
    visibility = ["//visibility:public"],
    exports = [":annotations"],
)

# You should only need to use this library in rare situations, such as testing
# other annotations processors that generate @AutoValue types. If you just want
# to use @AutoValue, you should depend on the auto_value library.
java_library(
    name = "auto_value_processor",
    visibility = ["//visibility:public"],
    exports = [":lib"],
)

java_library(
    name = "annotations",
    exports = ["@maven//:com_google_auto_value_auto_value_annotations"],
)

java_library(
    name = "lib",
    exports = ["@maven//:com_google_auto_value_auto_value"],
)
