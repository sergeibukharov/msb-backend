plugins {
	java
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.owasp.dependencycheck") version "9.1.0"
}


extra["springBootVersion"] = "3.2.5"
extra["springCloudVersion"] = "2023.0.1"

allprojects {
	group = "com.thoughtworks"
	version = "0.0.1-SNAPSHOT"


	apply {
		plugin("java")
		plugin("io.spring.dependency-management")
		plugin("org.owasp.dependencycheck")
	}

	repositories {
		mavenCentral()
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.boot:spring-boot-dependencies:${property("springBootVersion")}")
		}
	}

	dependencies {
		testImplementation("org.junit.jupiter:junit-jupiter-api")
		testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
	}

	tasks {
		withType<Test> {
			useJUnitPlatform()
		}
		check {
			dependsOn("dependencyCheckAnalyze")
		}
	}
}

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

dependencies {
	implementation(project(":financial-management"))
	implementation(project(":api"))
	implementation(project(":persistence"))

	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("io.micrometer:micrometer-tracing-bridge-brave")
	implementation("org.flywaydb:flyway-core")
	implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")
	testImplementation("org.junit.jupiter:junit-jupiter-api")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}
