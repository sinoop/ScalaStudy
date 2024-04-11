import scala.annotation.tailrec
import scala.io.StdIn

object Fibonacci extends App {
  val input = StdIn.readLine("Enter the number : ").toInt

  // Brute force approach
  private def generateFibinocci(input: Int): Int = {
    input match {
      case 1 => 1
      case 2 => 1
      case n => generateFibinocci(n-1) + generateFibinocci(n-2)
    }
  }

  // Memoized Solution
  private def generateFibonacci(n: Long): Long = {
    @tailrec
    def fibonacciHelper(number: Long, currentTerm: Long, nextTerm: Long): Long = {
      if (number <= 2) nextTerm
      else fibonacciHelper(number - 1, nextTerm, currentTerm + nextTerm)
    }

    fibonacciHelper(n, 1, 1)
  }

awA
  println(s"${input}th fibinocci is ${generateFibonacci(input)}")

}
