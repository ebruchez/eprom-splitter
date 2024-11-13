import mainargs.*
import os.*

object Main {

  implicit object PathRead extends TokensReader.Simple[os.Path]{
    def shortName = "path"
    def read(strs: Seq[String]): Either[String, Path] = Right(os.Path(strs.head, os.pwd))
  }

  def main(args: Array[String]): Unit = ParserForMethods(this).runOrExit(args)

  @main
  def run(
    @arg(positional = true, doc = "The input ROM file to split")
    inputFilename   : os.Path,
    @arg(positional = true, doc = "The output file for the low bytes")
    outputLoFilename: os.Path,
    @arg(positional = true, doc = "The output file for the high bytes")
    outputHiFilename: os.Path,
  ): Unit = {

    val bytes = os.read.bytes(inputFilename)

    val hi = bytes.sliding(2, step = 2).map(_.head).toArray // low address is high byte (big-endian)
    val lo = bytes.sliding(2, step = 2).map(_.last).toArray // high address is low byte (big-endian)

    os.write(outputLoFilename, lo)
    os.write(outputHiFilename, hi)
  }
}
