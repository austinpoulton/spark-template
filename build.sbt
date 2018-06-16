import sbt.Keys.scalaVersion


name := BuildConfig.artifactName


scalaVersion := "2.11.11"

crossPaths := false

parallelExecution in Test := false

resolvers ++= Seq(
  "artifactory" at "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases",
  "sbt-plugin-releases" at "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
)

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.7"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.7"
dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.7"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.2.2",
  "org.uaparser" % "uap-scala_2.11" % "0.2.0",
  "com.typesafe.play" % "play-json_2.11" % "2.6.9",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.345",
  "org.apache.hadoop" % "hadoop-aws" % "3.1.0",
  "org.apache.hadoop" % "hadoop-hdfs" % "3.1.0",
  "org.apache.hadoop" % "hadoop-common" % "3.1.0",
  "org.apache.spark" %% "spark-core" % "2.3.1",
  "org.apache.spark" %% "spark-sql" % "2.3.1",
  "org.apache.spark" %% "spark-hive" % "2.3.1",

  "com.typesafe" % "config" % "1.3.3",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.mockito" % "mockito-core" % "2.8.9" % "test"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "services", "org.apache.hadoop.fs.FileSystem") => MergeStrategy.filterDistinctLines
  case PathList("META-INF", "MANIFEST.MF", _*) => MergeStrategy.discard
  case PathList("META-INF", xs@_*) => MergeStrategy.filterDistinctLines
  case x => MergeStrategy.first
}
