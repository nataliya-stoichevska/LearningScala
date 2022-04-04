package lectures.part2oop

object Inheritance extends App {


  //Scala has single class inheritance - you can only extend one class at a time

  //superclass
  class Animal {
    val creatureType = "wild"

    def eat = println("nom nom nom")

    private def eatGrass = println("cannot extend mee")

    protected def eatMeat = println("only subclasses can call me")

    def sound = {}
  }

  //subclass
  class Cat extends Animal {
    def crunch = {
      eatMeat
      println("Crunchy meat nom nom")
    }
  }

  val cat = new Cat
  cat.eat
  //cat.eatGrass - error
  //cat.eatMeat - error

  //constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0) //another constructor
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) //correct way to extend class with parameters

  class Adult2(name: String, age: Int, idCard: String) extends Person(name) //extends with the other constructor

  //overriding
  final class Dog(override val creatureType: String = "") extends Animal {
    //override val creatureType = "domestic"
    override def eatMeat: Unit = println("Dogie eats")

    override def sound: Unit = println("woof")

    //SUPER - calls fields from superclass
    super.eat
  }

  val dog = new Dog
  dog.eatMeat
  println(dog.creatureType)

  val dogWithOverwriteFieldInConstructor = new Dog("domestic")

  //type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")

  unknownAnimal.sound //will print woof

  //overRIDING - supplying a different implementation in derived classes
  // vs overLOADING - multiple methods with different signatures but with the same name in the same class\

  //preventing overrides
  //1 - use the keyword final on member
  //2 - use the keyword final on class
  //class Shepard extends Dog - err
  //3 - seal the class - software restriction that you can extend classes in this file ONLY
  // but prevents extending in other files  -- using the keyword sealed in-front of the class

  sealed class Wolf {}
}
