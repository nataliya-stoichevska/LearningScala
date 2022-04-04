package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} + ${person.name}"

    def +(nickname: String): Person = new Person(s"${this.name} ($nickname)", this.favoriteMovie, this.age)

    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

    def unary_! : String = s"$name what the heck!"

    def isAlive: Boolean = true

    def learns(thing: String): String = s"${this.name} learns ${thing}"

    def learnsScala : String = learns("Scala")

    //parenthesis are important
    def apply(): String =  s"Hi, my name is $name and I like $favoriteMovie"

    def apply(times: Int): String = s"${this.name} watched ${this.favoriteMovie} ${times} times."
  }

  val mary = new Person("Mary", "Inception", 25)
  println(mary.likes("Inception")) //true
  println(mary likes "Inception") //equivalent //infix notation = operator notation (syntactic sugar)
                                  // - works with methods that have only 1 parameter

  //"operators" in Scala
  val tom = new Person("Tom", "Fight club", 23)
  println(mary hangOutWith tom)

  //Scala has permissive naming of methods i.e. we can call the method "+", "-" etc. we can rename hangOutWith to +
  println(mary + tom)
  println(mary.+(tom)) //same

  println(1 + 2)
  println(1.+(2)) //same for mathematical operators

  //ALL OPERATORS ARE METHODS!

  //prefix notations
  val x = -1 // the - is unary operator
  val y = 1.unary_- //this is the same as the one above
  //unary_ prefix only works with few operators, - + ~ !

  println(!mary)
  println(mary.unary_!)

  //post fix notations - available only to methods without parameters
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) //the same as the above //this brakes the barrier between oop and fp


  /* Exercises:
  1. Overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the Person class
    Add a unary + operator => new person with age + 1
    +mary => mary with the age incremented ;

  3. Add a "learns" method in the Person class => Mary learns * eg. Scala
      Add a learnsScala method, calls the learns method with "Scala" as a parameter
      Use it in postfix notation
  4. Overload the apply method
    mary.apply(2) "Mary watched the Inception 2 times"
  */

  println((mary + "the rockstar").name)
  println((mary + "the rockstar")())

  println((+mary).age)

  println(mary learns "Java")

  println(mary learnsScala)

  println(mary(2))
}
