""" Loads all maven dependencies listed """

load("@rules_jvm_external//:defs.bzl", "maven_install")

def maven_dependencies(maven_servers):
    """ Loads all maven dependencies using the given maven_servers

    Args:
        maven_servers: The servers to use to fetch the maven dependencies
    """
    maven_install(
        name = "maven",
        artifacts = [
            "org.slf4j:slf4j-api:1.7.30",
            # Spring boot dependencies.
            "org.springframework.boot:spring-boot:2.6.4",
            "org.springframework.boot:spring-boot-actuator:2.6.4",
            "org.springframework.boot:spring-boot-actuator-autoconfigure:2.6.4",
            "org.springframework.boot:spring-boot-autoconfigure:2.6.4",
            "org.springframework.boot:spring-boot-configuration-processor:2.6.4",
            "org.springframework.boot:spring-boot-loader:2.6.4",
            "org.springframework.boot:spring-boot-loader-tools:2.6.4",
            "org.springframework.boot:spring-boot-starter:2.6.4",
            "org.springframework.boot:spring-boot-starter-actuator:2.6.4",
            "org.springframework.boot:spring-boot-starter-freemarker:2.6.4",
            "org.springframework.boot:spring-boot-starter-jdbc:2.6.4",
            "org.springframework.boot:spring-boot-starter-jetty:2.6.4",
            "org.springframework.boot:spring-boot-starter-logging:2.6.4",
            "org.springframework.boot:spring-boot-starter-security:2.6.4",
            "org.springframework.boot:spring-boot-starter-test:2.6.4",
            "org.springframework.boot:spring-boot-starter-web:2.6.4",
            "org.springframework.boot:spring-boot-test:2.6.4",
            "org.springframework.boot:spring-boot-test-autoconfigure:2.6.4",
            "org.springframework.boot:spring-boot-starter-thymeleaf:2.6.4",
            "org.springframework.boot:spring-boot-starter-data-jpa:2.6.4",
            # Spring dependencies.
            "org.springframework:spring-aop:5.3.16",
            "org.springframework:spring-aspects:5.3.16",
            "org.springframework:spring-beans:5.3.16",
            "org.springframework:spring-context:5.3.16",
            "org.springframework:spring-context-support:5.3.16",
            "org.springframework:spring-core:5.3.16",
            "org.springframework:spring-expression:5.3.16",
            "org.springframework:spring-jdbc:5.3.16",
            "org.springframework:spring-test:5.3.16",
            "org.springframework:spring-tx:5.3.16",
            "org.springframework:spring-web:5.3.16",
            "org.springframework:spring-webmvc:5.3.16",
            # Data base drivers.
            "com.h2database:h2:2.1.210",
            "org.postgresql:postgresql:42.3.3",
            "org.xerial:sqlite-jdbc:3.36.0.3",
            # Other dependencies.
            "javax.annotation:javax.annotation-api:1.3.2",
            "junit:junit:4.13.2",
            "org.hamcrest:hamcrest:2.2",
            "com.google.guava:guava:28.2-jre",
            "com.google.auto.value:auto-value:1.9",
            "com.google.auto.value:auto-value-annotations:1.9",
            "org.assertj:assertj-core:3.22.0",
            "org.mockito:mockito-all:1.10.19",
            "org.springdoc:springdoc-openapi-ui:1.6.6",
        ],
        excluded_artifacts = [
            "org.springframework.boot:spring-boot-starter-tomcat",
        ],
        repositories = maven_servers,
        fetch_sources = True,
        fetch_javadoc = True,
        version_conflict_policy = "pinned",
        strict_visibility = False,
        generate_compat_repositories = False,
        resolve_timeout = 1800,
    )
