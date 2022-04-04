package lectures.part2oop

object Objects extends App{

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("STATIC")

  //it has objects it can have values and method definitions, like classes but they can not receive parameters
  object Person{ //we define type + its only instance
    //static/class level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method - its whole porpoise is to build Person given some parameters
    def from(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  //we can write a class with the same name
  class Person(val name: String = ""){
    //instance-level functionality
  }

  //class Person and object Person are COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  //Scala object is a SINGLETON INSTANCE
  val mary = Person //instance of object Person type
  val john = Person
  println(mary == john) //true, mary and john point to the same object called Person

  val ana = new Person //the class
  val martin = new Person //the class
  println(ana == martin) //false

  val bobby = Person.from(ana, martin) // we cannot put mary and john

  //Scala Applications = Scala object with
  //def main(args: Array[string]): Unit - it has to be defined exactly like this
  //-because scala apps are turned into java vm apps, whose entry point has to be public static void main(String[] args)
}
