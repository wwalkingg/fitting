pluginManagement {
    repositories {
        google()
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
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}
rootProject.name = "Template"
include(":app")
include(":feature:template")
include(":core-network")
include(":core-repository")
include(":feature:statusPage")
include(":feature:home")
// components
include(":swiper")
