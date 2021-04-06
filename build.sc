import mill._
import mill.scalalib._
import mill.define.{Command, Target}
import os._

object sample extends mill.Module {

  val serviceDirectory  = os.pwd / "service"

  def build: Target[Unit] =
    T.command {
        os.proc(
          "bash",
          "-c",
          s"""mkdir service/target-files && \\
          echo "foo=bar" > service/target-files/foo.txt && \\
          cd service && \\
          docker build -t layered-test --build-arg source_path=target-files ."""
        ).call(stdin = os.Inherit, stdout = os.Inherit, stderr = os.Inherit)
          .exitCode match {
          case 0 =>
            println(s"Docker image build completed successfully")
          case _ => println(s"Docker image build failed")
        }
    }
}