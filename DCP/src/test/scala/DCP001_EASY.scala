
import org.scalatest.funsuite.AnyFunSuite
class DCP0001_EASYTest extends AnyFunSuite {
  val solution = new DCP0001_EASY

  // Helper method to create input data for testing
  def createLinkedListInput(arrayString: String, totalString: String, separatorString: String = ","): ArrayInput = {
    ArrayInput(arrayString, totalString, separatorString)
  }

  // Test case to verify the solution with normal input
  test("solve should return true") {
    val input = createLinkedListInput("10, 15, 3, 7", "17")
    assert(solution.test(input) == "true")
  }


}
