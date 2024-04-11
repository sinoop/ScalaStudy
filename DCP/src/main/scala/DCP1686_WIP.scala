import com.sun.org.slf4j.internal.LoggerFactory

import scala.io.StdIn

object DCP1686_WIP {
  private val logger = LoggerFactory.getLogger(getClass)

  def reverse[T](lst: Seq[T], i : Int , j: Int) : Seq[T] = {
    lst.slice(i,j)
  }

  def main(args: Array[String]): Unit = {
    while (true) {
      println("Enter the list separated by comma")
      val inputInteger = StdIn.readLine()
      val inputSeq = inputInteger.split(",").map(_.toInt).toSeq
      // 1, 2, 4, 3

    }
  }

}
