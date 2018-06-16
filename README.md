### Spark Template  

A skeleton for Spark projects using Spark 2.3 and some other useful dependencies

##### SBT Plugins

sbt-coursier allows parallel dependency updates in SBT making the development process justa little bit faster.
The sbt-assembly plugin allows fat jars to be built which is useful for development testing without an Spark cluster.

```scala
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.3")
```
##### Dependencies 


Library | Depedency 
--- | --- 
Spark Libraries |   "org.apache.spark" %% "spark-core" % "2.3.1", "org.apache.spark" %% "spark-sql" % "2.3.1", "org.apache.spark" %% "spark-hive" % "2.3.1",  
Hadoop support |   "org.apache.hadoop" % "hadoop-aws" % "3.1.0", "org.apache.hadoop" % "hadoop-hdfs" % "3.1.0", "org.apache.hadoop" % "hadoop-common" % "3.1.0",
Application configuration  |  "com.typesafe" % "config" % "1.3.3"
JSON parser | "com.typesafe.play" % "play-json_2.11" % "2.6.9"
AWS s3 support |  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.345", "org.apache.hadoop" % "hadoop-aws" % "3.1.0"
JDBC postgres support |   "org.postgresql" % "postgresql" % "42.2.2"
 Test Libraries |  "org.scalatest" %% "scalatest" % "3.0.5" % "test","org.mockito" % "mockito-core" % "2.8.9" % "test"


##### Fat Jars
Creating FAT Jars for Spark can be hazardous for your sanity.  Please read more about class merge  policies suportted in SBT here:

 - [SBT Merge strategy](https://github.com/sbt/sbt-assembly#merge-strategy)
 - 