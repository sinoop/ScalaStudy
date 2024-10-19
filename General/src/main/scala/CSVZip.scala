import java.io.{File, FileInputStream, FileOutputStream}
import java.nio.file.{Files, Paths}
import java.util.zip.{ZipEntry, ZipOutputStream}

object CSVZip extends App {
  def zipCsvFiles(files: Seq[String], targetPath: String): Unit = {
    val buffer = new Array // 8KB buffer size
    val zipStream = new ZipOutputStream(new FileOutputStream(targetPath))

    try {
      files.foreach { file =>
        val f = new File(file)
        zipStream.putNextEntry(new ZipEntry(f.getName))
        val fileInputStream = new FileInputStream(f)
        try {
          var length = 0
          while ( {
            length = fileInputStream.read(buffer); length != -1
          }) {
            zipStream.write(buffer, 0, length)
          }
        } finally {
          fileInputStream.close()
        }
        zipStream.closeEntry()
      }
    } finally {
      zipStream.close()
    }
  }

  // Example usage:
  val files = Seq("path/to/file1.csv", "path/to/file2.csv", "path/to/file3.csv")
  val targetPath = "path/to/target.zip"

  // Measure runtime performance
  val startTime = System.nanoTime()
  zipCsvFiles(files, targetPath)
  val endTime = System.nanoTime()
  val duration = (endTime - startTime) / 1e9d // convert to seconds

  println(s"Time taken: ${duration.toString} seconds")

}

