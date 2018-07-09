plugins {
    kotlin("jvm") version "1.2.51"
}

dependencies {
    compile(kotlin("stdlib"))
    testCompile(kotlin("test-junit"))
}

repositories {
    jcenter()
}

task<Wrapper>("wrapper") {
    gradleVersion = "4.8"
    distributionType = Wrapper.DistributionType.ALL
}
