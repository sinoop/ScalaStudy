case class DCP1789Input(matrix: IndexedSeq[IndexedSeq[String]])

class DCP1798Initial extends Solution[DCP1789Input] {
  def getInputs: DCP1789Input = {
    println("Enter the matrix size :")
    println("No of Rows :")
    val numRows = scala.io.StdIn.readInt()
    println("No of Columns :")
    val numCols  = scala.io.StdIn.readInt()

    var matrix : IndexedSeq[IndexedSeq[String]] = IndexedSeq.empty
    var currRowCnt = 0
    var flag = false
    while (currRowCnt < numRows){
      while(!flag) {
        println(s"Enter [$currRowCnt] row with $numCols columns")
        val currRow = scala.io.StdIn.readLine().split(",")
        if (currRow.size == numCols) {
          flag = true
          matrix ++ currRow.toIndexedSeq
          currRowCnt += 1
        }
      }
    }
    DCP1789Input(matrix)

  }

  override def solve(input: DCP1789Input): String = ???

  override def validateInput(input: DCP1789Input): Boolean = true
}


object DCP1798Initial extends App {
  // Entry point for the application
  val solution = new DCP1789Initial
  solution.execute() // Execute the solution
}

