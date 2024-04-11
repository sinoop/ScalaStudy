package ScalaFunctionalProgrammingEssentialsRocktheJVM

object Playground {
  def main(args: Array[String]): Unit = {

    val regularBlock: Unit =
      println("This is printed everytime this Application is called")
    lazy val aLazyCodeBlock: Unit = {
      println("This is called only if we reference")
    }


  }
}
