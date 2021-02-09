name := "bowling-game"
 
version := "1.0" 
      
lazy val `bowling-game` = (project in file(".")).enablePlugins(PlayScala)
      
scalaVersion := "2.12.8"

libraryDependencies ++= Seq( guice )

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "3.0.0" % Test

      