plugins {
    `java-spring-base`
}

group = ParrotConfig.extendGroup("stt")
version = ParrotConfig.baseVersion("0.0.1")


dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation("org.apache.commons:commons-text:1.7")
    implementation("com.fasterxml.jackson.core:jackson-databind")
}