import org.gradle.api.JavaVersion.VERSION_1_8

val specTitle = "JAlec"
val artifact = specTitle.lowercase()
group = "net.anvilcraft"

plugins {
    id("java")
    id("maven-publish")
}

configure<JavaPluginConvention> {
    sourceCompatibility = VERSION_1_8
    targetCompatibility = VERSION_1_8
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = artifact
            artifact(tasks["jar"])
        }
    }

    repositories {
        maven {
            url = uri("https://maven.tilera.xyz/")
            credentials {
                username = findProperty("mvnUsername") as String?
                password = findProperty("mvnPassword") as String?
            }
        }
    }
}
