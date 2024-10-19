
import scala.io.StdIn.readLine

case class ArrayInput(array: String, totalString:String, separatorString : String) {

  def parsedArray: Seq[Int] =
    array.split(separatorString).toSeq.map(_.trim.toInt)

  def parsedTotal: Int = totalString.toInt
}


class DCP0001_EASY extends Solution[ArrayInput] {
  private val separatorString = ","

  def validateInput(input: ArrayInput): Boolean = {
    input.array.nonEmpty
  }

  override def solve(input: ArrayInput): String = {
    var currentMap =  Map[Int, Int]()
    input.parsedArray.foreach { i =>
      if(currentMap.contains(input.parsedTotal - i)){
        return "true"
      }
      else {
        currentMap += i -> i
      }
    }
    "false"
  }

  def getInputs: ArrayInput = {
    println(s"Enter the List of elements Separated by $separatorString:")
    val arrayString = readLine

    println(s"Enter the total number $separatorString:")
    val totalString = readLine

    ArrayInput(arrayString, totalString, separatorString)
  }
}

object DCP0001_EASY extends App {
  val solution = new DCP0001_EASY
  solution.execute()
}

