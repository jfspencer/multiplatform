plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("dependencies") {
            id = "com.core.config.dependencies"
            implementationClass = "com.core.config.DependenciesPlugin"
        }
    }
}
