package lectures.part3fp

object Sequences extends App{

  //Seq
  val aSequence = Seq(1, 4, 3, 2)
  println(aSequence) //actually a list
  println(aSequence.reverse)
  println(aSequence.apply(2)) //returns a value at given particular index
  println(aSequence ++ Seq(6, 5, 7)) // concatenate lists
  println(aSequence.sorted) // works if the type is by default ordered

  //Ranges
  val aRange: Seq[Int] = 1 to 10
  val aRangeUntil: Seq[Int] = 1 until 10 //all the numbers with the right and noninclusive
  //aRange.foreach(println())

  //eg usage
  (1 to 10).foreach(x => println("Hello"))

  //Lists
  //immutable linked list
  //head, tail, isEmpty methods are fast O(1)
  //sealed - has two subtypes: object Nil(empty) and clas ::

  val aList = List(1, 2, 3)
  val prepended = 42 :: aList // same as +: //42, 1, 2, 3
  println(prepended)
  val appending = aList :+ 54

  val apples5 = List.fill(5)("apple") //fill is a curried function

  println(aList.mkString("-|-")) //elements concatenated with the specified separator

  //Arrays

}
