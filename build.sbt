lazy val commonSettings = Seq(
  organization := "org.opensirf.core",
  version := "1.0.0",
  name := "opensirf-core"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "OpenSIRF Core",
    version := "1.0.0",
    crossTarget := new java.io.File("target"),
    artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
        artifact.name + "-" + version.value + "." + artifact.extension
	}
)

crossPaths := false
publishTo := Some("Artifactory Realm" at "http://200.144.189.109:58082/artifactory/org.opensirf.core")
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
publishMavenStyle := false
isSnapshot := true

publishArtifact in (Compile, packageDoc) := false
publishArtifact in (Compile, packageSrc) := false
