package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract class - cannot be instantiated - made to be extended
  abstract class Animal { //can have both abstract and non-abstract types
    val creatureType: String
    val creatureTypeNonAbstract: String = "Wild"
    def eat: Unit
  }

  //val animal = new Animal - err

  class Dog extends Animal{
    val creatureType: String = "K9"
    override val creatureTypeNonAbstract: String = "K9" //need of override when non-abstract

    def eat: Unit = println("crunch crunch")
  }

  //traits - can be inherited along classes
  trait Carnivore {
    def eat(animal: Animal): Unit

    val preferredMEal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "crock"

    override def eat(animal: Animal): Unit = println(s"I am a crock and I am eating ${animal.creatureType}")

    override def eat: Unit = "nom nom"
  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)

  //traits vs abstract classes
  //1. traits do not have constructor parameters
  //2. multiple traits may be inherited by the same class
  //3. traits are behavior, abstract class is a type of thing
}
