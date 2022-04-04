package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello I am learning scala!"

  println(str.charAt(2)) // 0 indexed
  println(str.substring(7/*inclusive*/, 11/*exclusive*/))
  println(str.split(" ").toList /*returns array*/)
  println(str.startsWith("Hello") /*true or false*/)
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length) //function without parameters

  val aNumberStr = "2"
  val aNumber = aNumberStr.toInt

  //prepending, appending
  println('a' +: aNumberStr :+ 'z')

  println(str.reverse)

  println(str.take(2))

  //Scala-specific: String interpolator

  //S-interpolators
  val name = "Nate"
  val age = 25
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeting)

  //F-interpolators
  val sped = 1.2f
  val myth = f"$name%s can eat $sped%2.2f burgers per minute" //%2.2f means 2 characters total,minimum 2 decimal precision
  println(myth)

  val x = 1.1f
  //val str = f"$x%3d" - compiler err because it checks the type

  //Raw-interpolators
  println(raw"This is a \n newLine")
  val escaped = "This is a \n newLine"
  println(raw"$escaped") //injected variables do get escaped
}
