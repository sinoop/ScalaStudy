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

  private def generateFibonacci(n: Long): Long = {
    def fibonacciHelper(n: Long, a: Long, b: Long): Long = {
      if (n <= 2) b
      else fibonacciHelper(n - 1, b, a + b)
    }

    fibonacciHelper(n, 1, 1)
  }


  println(s"${input}th fibinocci is ${generateFibonacci(input)}")

}
