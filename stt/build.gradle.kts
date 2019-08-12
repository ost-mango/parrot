plugins {
    `java-spring-base`
}

group = ParrotConfig.extendGroup("stt")
version = ParrotConfig.baseVersion("0.0.1")


dependencies {
    implementation("org.mozilla.deepspeech:libdeepspeech:0.6.0-alpha.3")

    implementation("net.sf.phat:sphinx4-core:5prealpha")
    implementation("net.sf.phat:sphinx4-data:5prealpha")
}