import scala.io.StdIn



object DCP1638_EASY {
  private val separatorString = "->"
  case class Node(data:String, next:Node) {
    override def toString: String = {
      printLinkedList(this)
    }
  }

  private def parseLinkedListString(linkedListString: String) = {
    val items = linkedListString.split(separatorString).toSeq
    items.foldRight(null: Node)((value, next) => Node(value, next))
  }


//  def reverseLinkedList(parsedLinkedList: Node): Node = {
//    def swap(node: Node): Node = {
//      node match {
//        case null => null
//        case n if n.next == null => n
//        case n =>
//          val nextPair = n.next.next
//          val newHead = n.next.copy(next = n)
//          n.copy(next = swap(nextPair))
//          newHead
//      }
//    }
//
//    swap(parsedLinkedList)
//  }

  def reverseLinkedList(aNode: Node): Node = {
    def swapPairs(aNode:Node): Node = {
      aNode match {
        case  _ if aNode.next == null  => aNode
        case thisNode =>
          val rightNode = thisNode.next
          val restOfRight = rightNode.next
          val newRightNode = thisNode.copy(next = restOfRight)
          val newLeftNode = rightNode.copy(next = newRightNode)
          newLeftNode
      }
    }


    aNode match {
      case null  => aNode
      case  _ if aNode.next == null  => aNode
      case thisNode =>
        val rightNode = thisNode.next
        val rest = rightNode.next
        val newRightNode = thisNode.copy(next = rest)
        val newLeftNode = rightNode.copy(next = newRightNode)
        println(s"thisNode = ${thisNode.data} | rightNode = ${rightNode.data} | newLeftNode = ${newLeftNode.data} | newRightNode = ${newRightNode.data}")
//        println(s"newRightNode.next = ${newRightNode.next.data}")
        thisNode.copy(next = swapPairs(newRightNode.next))
    }
  }


  private def printLinkedList(head:Node): String = {
    def printHelper(current:Node): String = {
      current match {
        case null => ""
        case value => value.data + (if( value.next != null) separatorString else "") + printHelper(value.next)
      }
    }
    printHelper(head)
  }

  def main(args: Array[String]): Unit = {
    println(s"Enter the Linked List Separated by ${separatorString}")
    val linkedListString = StdIn.readLine()
    val parsedLinkedList = parseLinkedListString(linkedListString)
    val reversedLinkedList = reverseLinkedList(parsedLinkedList)
    println(reversedLinkedList)
  }

}
