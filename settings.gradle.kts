rootProject.name = "YA2048CC"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":application-compose")
include(":data-preference")
include(":data-preference-impl")
include(":data-repository")
include(":data-repository-impl")
include(":domain-usecase")
include(":domain-usecase-impl")
include(":presentation-core-navigation")
include(":presentation-core-ui")
include(":presentation-feature-host")
include(":presentation-feature-game")
include(":presentation-feature-about")
