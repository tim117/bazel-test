"""Go dependency loader."""

load("@bazel_gazelle//:deps.bzl", "go_repository")

def go_dependencies():
    """Loads Go repositories."""
    go_repository(
        name = "com_github_creack_pty",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/creack/pty",
        sum = "h1:uDmaGzcdjhF4i/plgjmEsriH11Y0o7RKapEf/LDaM3w=",
        version = "v1.1.9",
    )

    go_repository(
        name = "com_github_davecgh_go_spew",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/davecgh/go-spew",
        sum = "h1:vj9j/u1bqnvCEfJOwUhtlOARqs3+rkHYY13jYWTU97c=",
        version = "v1.1.1",
    )
    go_repository(
        name = "com_github_gin_contrib_sse",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/gin-contrib/sse",
        sum = "h1:Y/yl/+YNO8GZSjAhjMsSuLt29uWRFHdHYUb5lYOV9qE=",
        version = "v0.1.0",
    )
    go_repository(
        name = "com_github_gin_gonic_gin",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/gin-gonic/gin",
        sum = "h1:3DoBmSbJbZAWqXJC3SLjAPfutPJJRN1U5pALB7EeTTs=",
        version = "v1.7.7",
    )
    go_repository(
        name = "com_github_go_playground_assert_v2",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/go-playground/assert/v2",
        sum = "h1:MsBgLAaY856+nPRTKrp3/OZK38U/wa0CcBYNjji3q3A=",
        version = "v2.0.1",
    )
    go_repository(
        name = "com_github_go_playground_locales",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/go-playground/locales",
        sum = "h1:u50s323jtVGugKlcYeyzC0etD1HifMjqmJqb8WugfUU=",
        version = "v0.14.0",
    )
    go_repository(
        name = "com_github_go_playground_universal_translator",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/go-playground/universal-translator",
        sum = "h1:82dyy6p4OuJq4/CByFNOn/jYrnRPArHwAcmLoJZxyho=",
        version = "v0.18.0",
    )
    go_repository(
        name = "com_github_go_playground_validator_v10",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/go-playground/validator/v10",
        sum = "h1:uA0+amWMiglNZKZ9FJRKUAe9U3RX91eVn1JYXMWt7ig=",
        version = "v10.10.1",
    )
    go_repository(
        name = "com_github_golang_protobuf",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/golang/protobuf",
        sum = "h1:ROPKBNFfQgOUMifHyP+KYbvpjbdoFNs+aK7DXlji0Tw=",
        version = "v1.5.2",
    )
    go_repository(
        name = "com_github_google_go_cmp",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/google/go-cmp",
        sum = "h1:Khx7svrCpmxxtHBq5j2mp/xVjsi8hQMfNLvJFAlrGgU=",
        version = "v0.5.5",
    )

    go_repository(
        name = "com_github_google_gofuzz",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/google/gofuzz",
        sum = "h1:A8PeW59pxE9IoFRqBp37U+mSNaQoZ46F1f0f863XSXw=",
        version = "v1.0.0",
    )
    go_repository(
        name = "com_github_google_uuid",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/google/uuid",
        sum = "h1:t6JiXgmwXMjEs8VusXIJk2BXHsn+wx8BZdTaoZ5fu7I=",
        version = "v1.3.0",
    )

    go_repository(
        name = "com_github_jinzhu_inflection",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/jinzhu/inflection",
        sum = "h1:K317FqzuhWc8YvSVlFMCCUb36O/S9MCKRDI7QkRKD/E=",
        version = "v1.0.0",
    )
    go_repository(
        name = "com_github_jinzhu_now",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/jinzhu/now",
        sum = "h1:/o9tlHleP7gOFmsnYNz3RGnqzefHA47wQpKrrdTIwXQ=",
        version = "v1.1.5",
    )
    go_repository(
        name = "com_github_json_iterator_go",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/json-iterator/go",
        sum = "h1:PV8peI4a0ysnczrg+LtxykD8LfKY9ML6u2jnxaEnrnM=",
        version = "v1.1.12",
    )
    go_repository(
        name = "com_github_kr_pretty",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/kr/pretty",
        sum = "h1:WgNl7dwNpEZ6jJ9k1snq4pZsg7DOEN8hP9Xw0Tsjwk0=",
        version = "v0.3.0",
    )
    go_repository(
        name = "com_github_kr_pty",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/kr/pty",
        sum = "h1:VkoXIwSboBpnk99O/KFauAEILuNHv5DVFKZMBN/gUgw=",
        version = "v1.1.1",
    )
    go_repository(
        name = "com_github_kr_text",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/kr/text",
        sum = "h1:5Nx0Ya0ZqY2ygV366QzturHI13Jq95ApcVaJBhpS+AY=",
        version = "v0.2.0",
    )

    go_repository(
        name = "com_github_leodido_go_urn",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/leodido/go-urn",
        sum = "h1:BqpAaACuzVSgi/VLzGZIobT2z4v53pjosyNd9Yv6n/w=",
        version = "v1.2.1",
    )
    go_repository(
        name = "com_github_mattn_go_isatty",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/mattn/go-isatty",
        sum = "h1:yVuAays6BHfxijgZPzw+3Zlu5yQgKGP2/hcQbHb7S9Y=",
        version = "v0.0.14",
    )
    go_repository(
        name = "com_github_mattn_go_sqlite3",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/mattn/go-sqlite3",
        sum = "h1:TJ1bhYJPV44phC+IMu1u2K/i5RriLTPe+yc68XDJ1Z0=",
        version = "v1.14.12",
    )
    go_repository(
        name = "com_github_modern_go_concurrent",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/modern-go/concurrent",
        sum = "h1:TRLaZ9cD/w8PVh93nsPXa1VrQ6jlwL5oN8l14QlcNfg=",
        version = "v0.0.0-20180306012644-bacd9c7ef1dd",
    )
    go_repository(
        name = "com_github_modern_go_reflect2",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/modern-go/reflect2",
        sum = "h1:xBagoLtFs94CBntxluKeaWgTMpvLxC4ur3nMaC9Gz0M=",
        version = "v1.0.2",
    )
    go_repository(
        name = "com_github_pkg_diff",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/pkg/diff",
        sum = "h1:aoZm08cpOy4WuID//EZDgcC4zIxODThtZNPirFr42+A=",
        version = "v0.0.0-20210226163009-20ebb0f2a09e",
    )

    go_repository(
        name = "com_github_pmezard_go_difflib",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/pmezard/go-difflib",
        sum = "h1:4DBwDE0NGyQoBHbLQYPwSUPoCMWR5BEzIk/f1lZbAQM=",
        version = "v1.0.0",
    )
    go_repository(
        name = "com_github_rogpeppe_go_internal",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/rogpeppe/go-internal",
        sum = "h1:FCbCCtXNOY3UtUuHUYaghJg4y7Fd14rXifAYUAtL9R8=",
        version = "v1.8.0",
    )

    go_repository(
        name = "com_github_stretchr_objx",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/stretchr/objx",
        sum = "h1:4G4v2dO3VZwixGIRoQ5Lfboy6nUhCyYzaqnIAPPhYs4=",
        version = "v0.1.0",
    )
    go_repository(
        name = "com_github_stretchr_testify",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/stretchr/testify",
        sum = "h1:nwc3DEeHmmLAfoZucVR881uASk0Mfjw8xYJ99tb5CcY=",
        version = "v1.7.0",
    )
    go_repository(
        name = "com_github_ugorji_go",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/ugorji/go",
        sum = "h1:qYhyWUUd6WbiM+C6JZAUkIJt/1WrjzNHY9+KCIjVqTo=",
        version = "v1.2.7",
    )
    go_repository(
        name = "com_github_ugorji_go_codec",
        build_file_proto_mode = "disable_global",
        importpath = "github.com/ugorji/go/codec",
        sum = "h1:YPXUKf7fYbp/y8xloBqZOw2qaVggbfwMlI8WM3wZUJ0=",
        version = "v1.2.7",
    )
    go_repository(
        name = "in_gopkg_check_v1",
        build_file_proto_mode = "disable_global",
        importpath = "gopkg.in/check.v1",
        sum = "h1:Hei/4ADfdWqJk1ZMxUNpqntNwaWcugrBjAiHlqqRiVk=",
        version = "v1.0.0-20201130134442-10cb98267c6c",
    )
    go_repository(
        name = "in_gopkg_errgo_v2",
        build_file_proto_mode = "disable_global",
        importpath = "gopkg.in/errgo.v2",
        sum = "h1:0vLT13EuvQ0hNvakwLuFZ/jYrLp5F3kcWHXdRggjCE8=",
        version = "v2.1.0",
    )

    go_repository(
        name = "in_gopkg_yaml_v2",
        build_file_proto_mode = "disable_global",
        importpath = "gopkg.in/yaml.v2",
        sum = "h1:D8xgwECY7CYvx+Y2n4sBz93Jn9JRvxdiyyo8CTfuKaY=",
        version = "v2.4.0",
    )
    go_repository(
        name = "in_gopkg_yaml_v3",
        build_file_proto_mode = "disable_global",
        importpath = "gopkg.in/yaml.v3",
        sum = "h1:h8qDotaEPuJATrMmW04NCwg7v22aHH28wwpauUhK9Oo=",
        version = "v3.0.0-20210107192922-496545a6307b",
    )
    go_repository(
        name = "io_gorm_driver_sqlite",
        build_file_proto_mode = "disable_global",
        importpath = "gorm.io/driver/sqlite",
        sum = "h1:bwfE+zTEWklBYoEodIOIBwuWHpnx52Z9zJFW5F33WLk=",
        version = "v1.3.1",
    )
    go_repository(
        name = "io_gorm_gorm",
        build_file_proto_mode = "disable_global",
        importpath = "gorm.io/gorm",
        sum = "h1:jYh3nm7uLZkrMVfA8WVNjDZryKfr7W+HTlInVgKFJAg=",
        version = "v1.23.3",
    )
    go_repository(
        name = "org_golang_google_protobuf",
        build_file_proto_mode = "disable_global",
        importpath = "google.golang.org/protobuf",
        sum = "h1:SnqbnDw1V7RiZcXPx5MEeqPv2s79L9i7BJUlG/+RurQ=",
        version = "v1.27.1",
    )

    go_repository(
        name = "org_golang_x_crypto",
        build_file_proto_mode = "disable_global",
        importpath = "golang.org/x/crypto",
        sum = "h1:XcWmESyNjXJMLahc3mqVQJcgSTDxFxhETVlfk9uGc38=",
        version = "v0.0.0-20220315160706-3147a52a75dd",
    )
    go_repository(
        name = "org_golang_x_net",
        build_file_proto_mode = "disable_global",
        importpath = "golang.org/x/net",
        sum = "h1:CIJ76btIcR3eFI5EgSo6k1qKw9KJexJuRLI9G7Hp5wE=",
        version = "v0.0.0-20211112202133-69e39bad7dc2",
    )
    go_repository(
        name = "org_golang_x_sys",
        build_file_proto_mode = "disable_global",
        importpath = "golang.org/x/sys",
        sum = "h1:saXMvIOKvRFwbOMicHXr0B1uwoxq9dGmLe5ExMES6c4=",
        version = "v0.0.0-20220318055525-2edf467146b5",
    )
    go_repository(
        name = "org_golang_x_term",
        build_file_proto_mode = "disable_global",
        importpath = "golang.org/x/term",
        sum = "h1:v+OssWQX+hTHEmOBgwxdZxK4zHq3yOs8F9J7mk0PY8E=",
        version = "v0.0.0-20201126162022-7de9c90e9dd1",
    )

    go_repository(
        name = "org_golang_x_text",
        build_file_proto_mode = "disable_global",
        importpath = "golang.org/x/text",
        sum = "h1:olpwvP2KacW1ZWvsR7uQhoyTYvKAupfQrRGBFM352Gk=",
        version = "v0.3.7",
    )
    go_repository(
        name = "org_golang_x_tools",
        build_file_proto_mode = "disable_global",
        importpath = "golang.org/x/tools",
        sum = "h1:FDhOuMEY4JVRztM/gsbk+IKUQ8kj74bxZrgw87eMMVc=",
        version = "v0.0.0-20180917221912-90fa682c2a6e",
    )
    go_repository(
        name = "org_golang_x_xerrors",
        build_file_proto_mode = "disable_global",
        importpath = "golang.org/x/xerrors",
        sum = "h1:E7g+9GITq07hpfrRu66IVDexMakfv52eLZ2CXBWiKr4=",
        version = "v0.0.0-20191204190536-9bdfabe68543",
    )
