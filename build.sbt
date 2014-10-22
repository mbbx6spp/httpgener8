name          := "scalacheck-http-generators"

organization  := "ops.functionalo"

version       := "0.1.0"

scalaVersion  := "2.11.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val scalazV = "7.1.0"
  val scalaCheckV = "1.11.5"
  Seq(
    "org.scalaz"      %%  "scalaz-core"                 % scalazV,
    "org.scalacheck"  %%  "scalacheck"                  % scalaCheckV,
    "org.scalaz"      %%  "scalaz-scalacheck-binding"   % scalazV % "test"
  )
}
