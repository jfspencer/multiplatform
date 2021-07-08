package com.core.config
import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
    }

    companion object{
        //android
        val androidCompileVersion = 30
        val androidMinSdk = 26
        val androidTargetSdk = 30

        //kotlin
        val koinVersion = "3.1.2"

        //Ktor
        val kTorVersion = "1.6.1"

    }
}