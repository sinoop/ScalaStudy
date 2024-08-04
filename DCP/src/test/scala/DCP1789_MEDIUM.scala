import org.scalatest.funsuite.AnyFunSuite

class DCP1789_MEDIUM extends AnyFunSuite {
  val solution = new BroadcastRangeSolution
  val solution2 = new BroadcastRangeInitialSolution

  // validateInput
  test("validateInput should return true for non-empty lists") {
    val input = BroadcastRangeInput(Seq(1, 2, 3), Seq(4, 5, 6))
    assert(solution.validateInput(input))
  }

  test("validateInput should return false for empty listener list") {
    val input = BroadcastRangeInput(Nil, Seq(4, 5, 6))
    assert(!solution.validateInput(input))
  }

  test("validateInput should return false for empty tower list") {
    val input = BroadcastRangeInput(Seq(1, 2, 3), Nil)
    assert(!solution.validateInput(input))
  }
  
  // BroadcastRangeSolution
  test("BroadcastRangeSolution should return the minimum broadcast range required") {
    val input = BroadcastRangeInput(Seq(1, 5, 11, 20), Seq(4, 8, 15))
    assert(solution.test(input) == "5")
  }

  test("BroadcastRangeSolution should handle a single listener and single tower") {
    val input = BroadcastRangeInput(Seq(1), Seq(10))
    assert(solution.test(input) == "9")
  }

  test("BroadcastRangeSolution should handle multiple listeners and towers") {
    val input = BroadcastRangeInput(Seq(1, 2, 3, 6), Seq(2, 4))
    assert(solution.test(input) == "2")
  }


  // BroadcastRangeInitialSolution
  test("BroadcastRangeInitialSolution should return the minimum broadcast range required") {
    val input = BroadcastRangeInput(Seq(1, 5, 11, 20), Seq(4, 8, 15))
    assert(solution2.test(input) == "5")
  }

  test("BroadcastRangeInitialSolution should handle a single listener and single tower") {
    val input = BroadcastRangeInput(Seq(1), Seq(10))
    assert(solution2.test(input) == "9")
  }

  test("BroadcastRangeInitialSolution should handle multiple listeners and towers") {
    val input = BroadcastRangeInput(Seq(1, 2, 3, 6), Seq(2, 4))
    assert(solution2.test(input) == "2")
  }

}
