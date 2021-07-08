buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.20")
        classpath("com.android.tools.build:gradle:7.0.0-beta05")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("cleanRoot", Delete::class) {
    delete(rootProject.buildDir)
}