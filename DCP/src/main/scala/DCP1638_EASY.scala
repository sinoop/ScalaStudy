

case class LinkedListInput(linkedListString: String) {
  val separatorString = "->"

  def parseLinkedListString(linkedListString: String): Node = {
    val items = linkedListString.split(separatorString).toSeq
    items.foldRight(null: Node)((value, next) => Node(value, next))
  }
}

case class Node(data:String, next:Node) {
  override def toString: String = {
    printLinkedList(this)
  }

  private def printLinkedList(head:Node): String = {
    val separatorString = "->"

    def printHelper(current:Node): String = {
      current match {
        case null => ""
        case value => value.data + (if( value.next != null) separatorString else "") + printHelper(value.next)
      }
    }
    printHelper(head)
  }
}

class DCP1638_EASY extends Solution[LinkedListInput] {
  private val separatorString = "->"


  // Method to validate inputs
  def validateInput(input: LinkedListInput): Boolean = {
    input.linkedListString.nonEmpty
  }

  override def solve(input: LinkedListInput): String = {

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
          thisNode.copy(next = swapPairs(newRightNode.next))
      }
    }

//    reverseLinkedList(parseLinkedListString(input.linkedListString)).toString
    ""
  }

  def getInputs: LinkedListInput = {
    println(s"Enter the Linked List Separated by $separatorString:")
    val linkedListString = scala.io.StdIn.readLine()
    LinkedListInput(linkedListString)
  }
}

object DCP1638_EASY extends App {
  val solution = new DCP1638_EASY
  solution.execute()
}

