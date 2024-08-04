//
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//
//
//import scala.io.StdIn
//import java.lang.{Long => jLong}
//
//object DCP1643 {
//  private val logger = LoggerFactory.getLogger(getClass)
//
//  private def flipDigit(c: Char): String = if(c == '0')  "1"  else  "0"
//
//  private def bitReversal(inputInteger: Long): Long = {
//    val binaryForm = inputInteger.toBinaryString
//    logger.ino(s"binaryForm              [$inputInteger] = $binaryForm")
//    val bitReversed = binaryForm.map{flipDigit}.mkString("")
//    logger.info(s"bitReversed            `[$inputInteger] = $bitReversed")
//    jLong.parseLong(bitReversed, 2)
//  }
//
//  def main(args: Array[String]): Unit = {
//    while (true) {
//      println("Enter the number to reverse")
//      val inputInteger = StdIn.readLong()
//      logger.info(s"Bit Reversed Number for [$inputInteger] = ${bitReversal(inputInteger)}")
//    }
//  }
//
//}
