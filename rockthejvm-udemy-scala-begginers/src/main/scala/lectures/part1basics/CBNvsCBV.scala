package lectures.part1basics

object CBNvsCBV extends App {

  //the value is computed before the function is evaluated
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  //the value is passed as is throughout the entire function definition
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //stackoverflow
  //printFirst(infinite(), 34)

  //no stackoverflow ; we don't use infinite() in printFirst() so it is not evaluated at all
  printFirst(34, infinite())
}
