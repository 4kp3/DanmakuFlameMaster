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
    id("com.android.application")
}

android {
    /**
     * compileSdkVersion specifies the Android API level Gradle should use to
     * compile your app. This means your app can use the API features included in
     * this API level and lower.
     */
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {

        /**
         * applicationId uniquely identifies the package for publishing.
         * However, your source code should still reference the package name
         * defined by the namespace property (for simplicity, keep the
         * applicationId and namespace the same).
         */

        applicationId = "com.example.danmu"

        // Defines the minimum API level required to run the app.
        minSdk = Versions.MIN_SDK

        // Specifies the API level used to test the app.
        targetSdk = Versions.TARGET_SDK

        // Defines the version number of your app.
        versionCode = 1

        // Defines a user-friendly version name for your app.
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":ndkbitmap-armv5"))
    implementation(project(":ndkbitmap-armv7a"))
    implementation(project(":ndkbitmap-x86"))
    implementation(project(":DanmakuFlameMaster"))
    implementation("com.nostra13.universalimageloader:universal-image-loader:1.9.5")
}
