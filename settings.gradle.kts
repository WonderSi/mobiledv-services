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
