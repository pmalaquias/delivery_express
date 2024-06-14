import java.util.Properties

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.5.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

val envFile = project.rootDir.resolve(".env")

if (envFile.exists()) {
    val props = Properties()
    envFile.inputStream().use { props.load(it) }

    props.forEach { (name, value) ->
        project.extensions.extraProperties.set(name.toString(), value.toString())
    }
}
