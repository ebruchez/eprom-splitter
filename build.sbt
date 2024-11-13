scalaVersion := "3.3.3"

enablePlugins(ScalaNativePlugin)

logLevel := Level.Info

libraryDependencies += "com.lihaoyi" %%% "os-lib" % "0.11.3"
libraryDependencies += "com.lihaoyi" %%% "mainargs" % "0.7.6"

import scala.scalanative.build._

nativeConfig ~= { c =>
  c.withLTO(LTO.none)
    .withMode(Mode.releaseSize)
    .withGC(GC.immix)
}
