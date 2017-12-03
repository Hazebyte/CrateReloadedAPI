# CrateReloaded API

* [Website]() 
* [Examples]() 
* [Java Docs](https://ci.hazebyte.com/job/CrateReloadedAPI/javadoc/)


* Jenkins [![Build Status](https://ci.hazebyte.com/job/CrateReloadedAPI/badge/icon)](https://ci.hazebyte.com/job/CrateReloadedAPI/) 
* TravisCI [![Build Status](https://travis-ci.org/imWillX/CrateReloadedAPI.svg?branch=master)](https://travis-ci.org/imWillX/CrateReloadedAPI)

## Requirements

>- CrateReloaded v2.0.0 or higher
>- JDK 1.8
>- Gradle

## Maven
```
<dependency>
	<groupId>com.hazebyte</groupId>
	<artifactId>CrateReloadedAPI</artifactId>
	<version>1.0.0-SNAPSHOT</version>
	<type>jar</type>
</dependency>
```
## Gradle
```
repositories {
    maven   {     
      url = 'https://nexus.hazebyte.com/repository/maven-snapshots/'          
    }
}
dependencies {
    compile group: 'com.hazebyte', name: "CrateReloadedAPI", version: '1.0.0-SNAPSHOT'
}
```
