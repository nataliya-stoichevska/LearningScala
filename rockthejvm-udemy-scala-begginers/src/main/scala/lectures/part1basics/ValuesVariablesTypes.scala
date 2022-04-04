package lectures.part1basics

object ValuesVariablesTypes extends App {

  //declaring val
  val x: Int = 42
  println(x)

  //err - vals are immutable
  //x=2

  //types are optional - Compiler can infer types
  val y =42

  val aString: String = "hello"; //semicolons are allowed but arent necessary

  val aBoolean: Boolean = true
  val aBoolean2: Boolean = false

  val aChar: Char = 'a'

  val aInt: Int = x
  val aShort: Short = 4863
  val aLong: Long = 864836583658L

  val aFloat: Float = 0.2f
  val aDouble: Double = 0.2

  //variables
  var aVariable: Int = 4

  //variables can be reassigned - mutable
  aVariable = 5 //side effects

  def c = 432 //the value is calculated each time we use it - we don't take up memory
 }
