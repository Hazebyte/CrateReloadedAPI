# CrateReloaded API

This repository holds the source code to the API for CrateReloaded. Any issues related to the API should be reported here.

* [Main Repository](https://github.com/Hazebyte/CrateReloaded)
* [Build Server](https://ci.hazebyte.com/job/CrateReloadedAPI/)
* [Java Docs](https://ci.hazebyte.com/job/CrateReloadedAPI/javadoc/)

Click the image below for our Discord channel for other support.


[![discord](https://imgur.com/MFRRBn4.png)](https://discord.gg/0srgnnU1nbB8wMML)

# Projects

* [NPC](https://github.com/Hazebyte/CrateReloadedNPC)

Community

* [ShiftOpenKeys](https://github.com/Twi5TeD/ShiftOpenKeys)

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
