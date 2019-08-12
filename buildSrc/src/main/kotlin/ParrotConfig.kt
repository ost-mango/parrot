object ParrotConfig {

    const val PARROT_VERSION = "M1"
    const val mangoRootGroup = "com.mango"

    fun baseVersion(appVer: String) = "${PARROT_VERSION}_${appVer}"
    fun extendGroup(appPackage: String) = "${mangoRootGroup}.${appPackage}"

    object Deps {

        const val springBootVersion = "2.1.6.RELEASE"
        const val springBootAdminVersion = "2.1.4"
        const val springCloudVersion = "Greenwich.SR2"

        const val springBootDepsBom = "org.springframework.boot:spring-boot-dependencies:$springBootVersion"
        const val springBootAdminDepsBom = "de.codecentric:spring-boot-admin-dependencies:$springBootAdminVersion"
        const val springCloudDepsBom = "org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion"
        const val springBootGrdlePlugin = "org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion"

        const val springBootStarter = "org.springframework.boot:spring-boot-starter"
        const val springBootStarterActuator = "org.springframework.boot:spring-boot-starter-actuator"
        const val springBootStarterWeb = "org.springframework.boot:spring-boot-starter-web"
        const val springBootStarterWebFlux = "org.springframework.boot:spring-boot-starter-webflux"
        const val springBootConfigurationProcessor = "org.springframework.boot:spring-boot-configuration-processor"
        const val springBootStarterTest = "org.springframework.boot:spring-boot-starter-test"
        const val reactorSpring = "org.projectreactor:reactor-spring:1.0.1.RELEASE"

        const val springCloudConfigServer = "org.springframework.cloud:spring-cloud-config-server:2.1.2.RELEASE"
        const val springCloudStarterConfig = "org.springframework.cloud:spring-cloud-starter-config"
        const val springBootAdminStarterClient = "de.codecentric:spring-boot-admin-starter-client"
        const val springBootAdminStarterServer = "de.codecentric:spring-boot-admin-starter-server"
        const val springCloudStarterNetflixEurekaClient = "org.springframework.cloud:spring-cloud-starter-netflix-eureka-client"

        const val lombok = "org.projectlombok:lombok"



        public object Test {
            const val junit = "junit:junit"
        }

        public object Kotlin {
            const val kotlinVersion = "1.2.61"

            const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
            const val kotlinAllopen = "org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion"
            const val jetbrainsKotlinStdLibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
            const val jetbrainsKotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"
        }

        public object Dmp {
        }
    }

    object Repo {
        private const val dmpArtifactoryPublicBaseUrl = "https://dmpapi.kyivstar.ua/artifactory"
        private const val dmpArtifactoryBaseUrl = "http://ks-dmp29.kyivstar.ua:9000/artifactory"

        const val dmpArtifactorySnapshotUrl = "$dmpArtifactoryBaseUrl/kyivstar-ua-snapshot/"
        const val dmpArtifactorySnapshotUserName = "dmp_dev"
        const val dmpArtifactorySnapshotPassword = "dmp_dev"
        const val dmpArtifactoryReleaseUrl = "$dmpArtifactoryBaseUrl/kyivstar-ua-releases/"
        const val dmpArtifactoryReleaseUserName = "dmp_dev"
        const val dmpArtifactoryReleasePassword = "dmp_dev"

        const val nexusProxyJcenter = "http://nexus-vm.kyivstar.ua:8081/repository/jcenter/"

        const val hortonworksReleases = "http://repo.hortonworks.com/content/repositories/releases/"
    }


}