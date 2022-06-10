val sourcePath = "src/main/"

plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
}

android {

    namespace = Maven.GROUP

    compileSdk = Versions.COMPILE_SDK
    //使用默认
    //buildToolsVersion = "30.0.2"

    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDir("${sourcePath}libs")
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = Maven.GROUP
            artifactId = Maven.ARTIFACT_ID
            version = Maven.VERSION_NAME

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

//if (rootProject.file('gradle/gradle-mvn-push.gradle').exists()) {
//    apply from: rootProject.file('gradle/gradle-mvn-push.gradle')
//}
//if (rootProject.file('gradle/gradle-bintray-upload.gradle').exists()) {
//    apply from: rootProject.file('gradle/gradle-bintray-upload.gradle')
//}