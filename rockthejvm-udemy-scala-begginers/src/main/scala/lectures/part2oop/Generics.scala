package lectures.part2oop

object Generics extends App {

  class MList[A] {
    //use the type A
  }

  trait MyTrait[A] {
    //use the type A
  }

  //lists should be covariant
  class MyListC[+A] {
    //def add(element: A): MyTraitC[A] = ??? - err
    def add[B >: A](element: B): MyListC[B] = ???
    /*
      A = Cat
      B = Dog = Animal
    */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MList[Int]
  val listOfStrings = new MList[String]

  //generic methods
  //objects cannot be parameterised
  object MyList {
    //def empty[A]: MyList[A] = ???//we can use it like this
  }

  //val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //does list of Cat extend Animal?

  //1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.Add(new Dog) ??? - ca be done but not ok

  //2. no = INVARIANCE
  class InvariantList[A]
  //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] - err

  //3. hell no = CONTRAVARIANCE
  class ContraVariantList[-A]
  val contravariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types - allow you to use your generic classes only for certain types
  class Cage[A <: Animal] (animal: A) //only accept types A which are subtypes of Animal
  val cage = new Cage(new Dog)
  class Car
  //val newCage = new Cage(new Car) - err

  class Cage1[A >: Animal] //only accept types A which are supertype to Animal


  /** Exercise
   * expand MyList to be a generic
   */
}
