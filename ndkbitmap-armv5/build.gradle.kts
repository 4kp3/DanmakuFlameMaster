plugins {
    id("com.android.library")
}

val sourcePath = "src/main/"

android {
    compileSdk = Versions.COMPILE_SDK
    //使用默认
    //buildToolsVersion = "30.0.2"

    defaultConfig{
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDir("${sourcePath}libs")
        }
    }
}

//if (rootProject.file('gradle/gradle-mvn-push.gradle').exists()) {
//    apply from: rootProject.file('gradle/gradle-mvn-push.gradle')
//}
//if (rootProject.file('gradle/gradle-bintray-upload.gradle').exists()) {
//    apply from: rootProject.file('gradle/gradle-bintray-upload.gradle')
//}