plugins {
	java
	id("net.ltgt.errorprone") version "3.1.0"
}

group = "com.github.gavlyukovskiy"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jspecify:jspecify:0.3.0")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
	testImplementation("org.assertj:assertj-core:3.25.3")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
