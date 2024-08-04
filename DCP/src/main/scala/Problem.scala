// Trait defining the structure for problems
trait Problem[T] {
  def getInputs: T // Method to get inputs for the problem
  def validateInput(input: T): Boolean // Method to validate the inputs
}

// Abstract class for solutions, extending Problem
abstract class Solution[T] extends Problem[T] {
  // Method to implement the solution logic
  def solve(input: T): String

  // Method to execute the solution
  def execute(): Unit = {
    val input = getInputs // Get inputs from the user or source
    if (validateInput(input)) { // Validate the inputs
      val result = solve(input) // Solve the problem
      println(result) // Print the result
    } else {
      println("Invalid input") // Handle invalid inputs
    }
  }

  // Method to support unit testing
  def test(input: T): String = {
    if (validateInput(input)) {
      solve(input) // Solve the problem for testing
    } else {
      throw new IllegalArgumentException("Invalid input") // Handle invalid inputs
    }
  }
}
