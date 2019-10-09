NearBee SDK for Android

You will need an API key for the NearBee SDK service to work.
Integration with your existing project in Android Studio
Add this to your project level build.gradle

allprojects {
    repositories {
        …
        maven {
            url  "https://dl.bintray.com/mobstac/maven"
        }
        …
    }
}

In the build.gradle file of the app, add the following in the dependencies section:

dependencies {
    …
    implementation 'co.nearbee:nearbeesdk:2.1.6'
}

Latest version

Download
Permissions
