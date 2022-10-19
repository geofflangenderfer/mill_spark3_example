// build.sc
import mill._
import mill.scalalib._
import mill.modules.Assembly
import coursier.maven.MavenRepository

object foo extends ScalaModule {
  def scalaVersion = "2.12.15"

  override def ivyDeps = Agg(
    ivy"org.apache.spark::spark-sql:3.3.0",
  )
}
