pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // VK Android SDK
        maven { url = uri("https://artifactory.vk.com/artifactory/maven/") }
        // Yandex MapKit
        maven { url = uri("https://artifactory.mapsapi.ru/repository/maven/") }
    }
}

rootProject.name = "mobiledv-services"
include(":app")
include(":core")
include(":core:navigation")
include(":core:ui")
include(":habits:domain")
include(":habits:data")
include(":habits:ui")
include(":stats:domain")
include(":stats:ui")
