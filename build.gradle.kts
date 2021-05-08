import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
}

group = "me.angel"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation ("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:6.0.4")
	implementation("com.squareup.okhttp3:okhttp:4.9.0")
	implementation("com.google.code.gson:gson:2.8.6")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}