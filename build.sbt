name := "algorithms"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "junit" % "junit" % "4.11" % Test,
  "org.hamcrest" % "hamcrest-library" % "1.3" % Test,
  "com.novocode" % "junit-interface" % "0.10" % Test
)
