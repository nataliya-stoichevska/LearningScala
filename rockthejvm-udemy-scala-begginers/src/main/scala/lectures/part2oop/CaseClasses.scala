package lectures.part2oop

object CaseClasses extends App{

  /**
   * problem: often for a lightweight datastructures we need to reimplement equals, hashcode, toString...
   */
  case class Person(name: String, age: Int)
  //1. class parameters are fields
  val jim = new Person("Jim", 32)
  println(jim.name)

  //2. sensible toString
  // we can obey toString println(instance)=println(instance.toString)
  println(jim.toString)
  println(jim)

  //3. equals and hashcode implemented OOTB otu of the box
  val jim2 = new Person("Jim", 32)
  println(jim == jim2) //true

  //4. having handy copy method
  val jim3 = jim.copy() //creates a new instance
  val jim4 = jim.copy(age=45) //we can change parameters

  //5 having companion objects
  val thePerson = Person //the compiler automatically creates companion object
  val mary = Person("Mary", 23) //using the apply method 
  // - so in practise we don't use keyword new when instancing a case class
  
  //6. serializable - can be send through the network and between jvms
  //Akka framework
  
  //7. they have extractor patterns = can be used in pattern matching
  
  //case objects
  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  }

  /**
   * Exercise
   * Expand MyList - using case classes and case objects
   */
}
