### Spark Template  

A skeleton for Spark projects using Spark 2.3 and some other useful dependencies

**SBT Plugins**
sbt-coursier allows parallel dependency updates in SBT making the development process justa little bit faster.
The sbt-assembly plugin allows fat jars to be built which is useful for development testing without an Spark cluster.

```scala
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")


addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.3")
```

