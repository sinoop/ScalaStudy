
class BroadcastRangeInitialSolution extends Solution[BroadcastRangeInput] {
  def getInputs: BroadcastRangeInput = {
    println("Enter the list of listeners (comma-separated):")
    val listeners = scala.io.StdIn.readLine().replace(" ", "").split(",").map(_.toInt).toSeq

    println("Enter the list of radio towers (comma-separated):")
    val towers = scala.io.StdIn.readLine().replace(" ", "").split(",").map(_.toInt).toSeq

    BroadcastRangeInput(listeners, towers)
  }

  // Method to validate inputs
  def validateInput(input: BroadcastRangeInput): Boolean = {
    input.listeners.nonEmpty && input.towers.nonEmpty // Check if both lists are non-empty
  }

  // Method to solve the problem and calculate the minimum broadcast range
  def solve(input: BroadcastRangeInput): String = {
    val listenersSorted = input.listeners.sorted // Sort listeners
    val towersSorted = input.towers.sorted // Sort towers

    val diffMap = listenersSorted.map { listener =>
      towersSorted.map(x => Math.abs(x - listener)).min
    }
    diffMap.max.toString
  }
}


object BroadcastRangeInitialSolution extends App {
  // Entry point for the application
  val solution = new BroadcastRangeInitialSolution
  solution.execute() // Execute the solution
}

