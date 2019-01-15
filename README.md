# CrateReloaded API

This repository holds the source code to the API for CrateReloaded. Any issues related to the API should be reported here.

* [Main Repository](https://github.com/Hazebyte/CrateReloaded)
* [Build Server](https://ci.hazebyte.com/job/CrateReloadedAPI/)
* [Java Docs](https://ci.hazebyte.com/job/CrateReloadedAPI/javadoc/)

Click the image below for our Discord channel for other support.

![https://discord.gg/0srgnnU1nbB8wMML](https://camo.githubusercontent.com/f858c72e48be080b0b4a6fc350d6e39f1cd2da13/68747470733a2f2f696d6775722e636f6d2f4d465252426e342e706e67)

# Projects

* [NPC](https://github.com/Hazebyte/CrateReloadedNPC)

## Requirements

>- CrateReloaded v2.0.0 or higher
>- JDK 1.8
>- Gradle or Maven

## Maven
```
<repository>
    <url>https://nexus.hazebyte.com/repo/maven-snapshots/</url>
</repository>

<dependency>
    <groupId>com.hazebyte</groupId>
    <artifactId>CrateReloadedAPI</artifactId>
    <version>1.0.0</version>
    <type>jar</type>
</dependency>
```

## Gradle
```
repositories {
    maven   {     
      url = 'https://nexus.hazebyte.com/repo/maven-snapshots/'          
    }
}

dependencies {
    compile group: 'com.hazebyte', name: "CrateReloadedAPI", version: '1.0.0'
}
```
