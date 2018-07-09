# CrateReloaded API

* [Website]() 
* [Examples]() 
* [Java Docs](https://ci.hazebyte.com/job/CrateReloadedAPI/javadoc/)


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
