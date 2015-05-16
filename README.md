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
			<groupId>com.taakestan</groupId>
			<artifactId>auto-video-transcoder</artifactId>
			<version>1.0</version>
		</dependency>
```

+ use it as follow

```
File file = VideoTransformer.transform("/home/omidp/taak/jpa.mp4", "/home/omidp/taak/"); // see testcase
```

```
 ffmpeg -i test.mp4 -vcodec libx264 -crf 20 -strict -2 output.mp4
```
