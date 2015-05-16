# auto-video-transcoder
Automatic video transcoder working on uploaded videos to S3

How to use
===

+ Install ffmpeg ( recommended version 2.4.9-1) e.g yum install ffmpeg
+ Build project 

```
mvn clean install -DskipTests=true
```

+ add depecndecy to your project 

```
<dependency>
			<groupId>org.taak</groupId>
			<artifactId>video</artifactId>
			<version>1.0</version>
		</dependency>
```

+ use it as follow

```
File file = VideoTransformer.transform("/home/omidp/taak/jpa.mp4", "/home/omidp/taak/"); // see testcase
```
