package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //anonymous class
  //we instanced an abstract class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = {
      println("Haha haha")
    }
  }

  //what the compiler does:
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = {
      println("Haha haha")
    }
  }
  //val funnyAnimal: Animal = new AnonymousClasses$$anon$1

  println(funnyAnimal.getClass)

  //Anonymous classes work for traits, abstract and non-abstract classes
  class Person(name: String) {
    def sayHi: Unit = println(s"hi my name is $name")
  }

  //we should pass the parameters even anonymously
  //make sure we override all of the super fields or methods
  val jim = new Person ("Jim") {
    override def sayHi: Unit = "Hi I am Jim!"
  }
}
