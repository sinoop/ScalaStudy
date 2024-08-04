case class BroadcastRangeInput(listeners: Seq[Int], towers: Seq[Int])


// Concrete implementation of the solution for calculating minimum broadcast range
class DCP1789Optimized extends Solution[BroadcastRangeInput] {
  // Method to get inputs from the user
  def getInputs: BroadcastRangeInput = {
    println("Enter the list of listeners (comma-separated):")
    val listeners = scala.io.StdIn.readLine().replace(" ", "").split(",").map(_.toInt).toSeq

    println("Enter the list of radio towers (comma-separated):")
    val towers = scala.io.StdIn.readLine().replace(" ", "").split(",").map(_.toInt).toSeq

    BroadcastRangeInput(listeners, towers) // Return the input data
  }

  // Method to validate inputs
  def validateInput(input: BroadcastRangeInput): Boolean = {
    input.listeners.nonEmpty && input.towers.nonEmpty // Check if both lists are non-empty
  }

  // Method to solve the problem and calculate the minimum broadcast range
  def solve(input: BroadcastRangeInput): String = {
    val listenersSorted = input.listeners.sorted // Sort listeners
    val towersSorted = input.towers.sorted // Sort towers

    // Function to calculate the closest distance from a listener to any tower
    def closestTowerDistance(listener: Int): Int = {
      var low = 0
      var high = towersSorted.length - 1
      while (low < high) {
        val mid = (low + high) / 2
        if (towersSorted(mid) < listener) {
          low = mid + 1
        } else {
          high = mid
        }
      }

      val rightDist = if (low < towersSorted.length) Math.abs(towersSorted(low) - listener) else Int.MaxValue
      val leftDist = if (low > 0) Math.abs(towersSorted(low - 1) - listener) else Int.MaxValue

      Math.min(rightDist, leftDist) // Return the minimum distance to the nearest tower
    }

    val maxDistance = listenersSorted.map(closestTowerDistance).max // Find the maximum distance among all listeners
    maxDistance.toString // Return the result as a string
  }
}

object DCP1789Optimized extends App {
  // Entry point for the application
  val solution = new DCP1789Optimized
  solution.execute() // Execute the solution
}
