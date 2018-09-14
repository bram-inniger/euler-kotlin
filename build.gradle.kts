plugins {
    kotlin("jvm") version "1.2.70"
}

dependencies {
    compile(kotlin("stdlib"))
    testCompile(kotlin("test-junit"))
}

repositories {
    jcenter()
}

tasks.getByName<Wrapper>("wrapper").gradleVersion = "4.10.1"
tasks.getByName<Wrapper>("wrapper").distributionType = Wrapper.DistributionType.ALL
