/*
 * Copyright (C) 2013 Chen Hui <calmer91@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("com.android.library")
}

val SourcePath = "src/main/"

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
            jniLibs.srcDir("${SourcePath}libs")
        }
    }
}

//if (rootProject.file('gradle/gradle-mvn-push.gradle').exists()) {
//    apply from: rootProject.file('gradle/gradle-mvn-push.gradle')
//}
//if (rootProject.file('gradle/gradle-bintray-upload.gradle').exists()) {
//    apply from: rootProject.file('gradle/gradle-bintray-upload.gradle')
//}