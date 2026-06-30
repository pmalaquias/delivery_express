import java.util.Properties

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "9.2.1" apply false
    id("org.jetbrains.kotlin.android") version "2.2.10" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.2.10" apply false
}

val envFile = project.rootDir.resolve(".env")

if (envFile.exists()) {
    val props = Properties()
    envFile.inputStream().use { props.load(it) }

    props.forEach { (name, value) ->
        project.extensions.extraProperties.set(name.toString(), value.toString())
    }
}
