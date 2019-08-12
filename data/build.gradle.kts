plugins {
    `java-spring-base`
}

group = ParrotConfig.extendGroup("data")
version = ParrotConfig.baseVersion("0.0.1")


dependencies {
    implementation("org.springframework.data:spring-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.apache.commons:commons-lang3")
    implementation("org.apache.commons:commons-text:1.7")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("ma.glasnost.orika:orika-core:1.5.4")
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    runtimeOnly("com.h2database:h2")
}