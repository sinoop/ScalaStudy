import org.scalatest.funsuite.AnyFunSuite

class DCP1638EASYTest extends AnyFunSuite {
  val solution = new DCP1638_EASY

  // Helper method to create input data for testing
  def createLinkedListInput(linkedListString: String): LinkedListInput = {
    LinkedListInput(linkedListString)
  }

  // Test case to verify the solution with normal input
  test("solve should swap every two nodes") {
    val input = createLinkedListInput("1->2->3->4")
    assert(solution.test(input) == "2->1->4->3")
  }

  // Test case to handle empty linked list
  test("solve should handle an empty linked list") {
    val input = createLinkedListInput("")
    assert(solution.test(input) == "")
  }

  // Test case to handle single element linked list
  test("solve should handle a single element linked list") {
    val input = createLinkedListInput("1")
    assert(solution.test(input) == "1")
  }

  // Test case to handle two elements linked list
  test("solve should handle a two-element linked list") {
    val input = createLinkedListInput("1->2")
    assert(solution.test(input) == "2->1")
  }

  // Test case to validate non-empty list
  test("validateInput should return true for non-empty list") {
    val input = createLinkedListInput("1->2->3")
    assert(solution.validateInput(input))
  }

  // Test case to validate empty list
  test("validateInput should return false for empty list") {
    val input = createLinkedListInput("")
    assert(!solution.validateInput(input))
  }
}
