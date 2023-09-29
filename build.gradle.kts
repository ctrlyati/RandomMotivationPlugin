repositories {
    mavenCentral()
}

plugins {
//    id("java")
//    id("org.jetbrains.intellij") version "1.15.0"
//    kotlin("jvm") version "1.9.10"

    id("java")
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
    id("org.jetbrains.intellij") version "1.11.0"

}

group = "app.ctrlyati.plugin.motivate"
version = "1.0-SNAPSHOT"


// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2022.3")
    type.set("IC") // Target IDE Platform
    plugins.set(listOf())
}


tasks {

    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }

    patchPluginXml {
        sinceBuild.set("223")
        untilBuild.set("232.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
