lazy val commonSettings = Seq(
  organization := "org.opensirf",
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

libraryDependencies += "org.glassfish.jersey.media" % "jersey-media-moxy" % "2.25"

crossPaths := false
publishTo := Some(Resolver.url("Artifactory Realm", new URL("http://200.144.189.109:58082/artifactory"))(Resolver.ivyStylePatterns))
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
publishMavenStyle := false
isSnapshot := true

publishArtifact in (Compile, packageDoc) := false
publishArtifact in (Compile, packageSrc) := false
