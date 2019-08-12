buildscript {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath(ParrotConfig.Deps.springBootGrdlePlugin)
        classpath("net.ltgt.gradle:gradle-apt-plugin:0.20")
    }
}

plugins {
    java
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    id("org.springframework.boot") version "2.1.6.RELEASE"
}

repositories {
    jcenter()
    mavenCentral()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}