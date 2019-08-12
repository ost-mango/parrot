plugins {
    `java-library`
    id("io.spring.dependency-management")  //version "1.0.6.RELEASE"
    id("net.ltgt.apt") // version "0.20"
}

repositories {
    jcenter()
}

apply(plugin = "java")
apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


repositories {
    mavenCentral()
}


dependencies {

    "annotationProcessor"(ParrotConfig.Deps.lombok)
    "annotationProcessor"(ParrotConfig.Deps.springBootConfigurationProcessor)
    // ignite
    // framework
    "implementation"(ParrotConfig.Deps.springBootStarterActuator)
    "implementation"(ParrotConfig.Deps.springBootStarterWeb)
    // additional
    "compileOnly"(ParrotConfig.Deps.lombok)
    // test
    "testImplementation"(ParrotConfig.Deps.springBootStarterTest)
}
