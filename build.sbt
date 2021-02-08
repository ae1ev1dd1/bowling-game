name := "bowling-game"
 
version := "1.0" 
      
lazy val `bowling-game` = (project in file(".")).enablePlugins(PlayScala)
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( guice )

      