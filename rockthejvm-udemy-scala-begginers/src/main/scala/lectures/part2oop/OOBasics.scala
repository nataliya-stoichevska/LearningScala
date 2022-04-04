package lectures.part2oop

object OOBasics extends App{

  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")
  person.greet()

  val writer = new Writer("Nate", "Stoi", 25)
  println(writer.fullname())

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Grat Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter)) //same name but returns false

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.inc.print
  counter.inc(10).print

//by using default parameters we omit the need of multiple constructors
class Person(name: String, val age: Int = 0) /*constructor*/{
  //class's body
  //the whole body is executed when class is created
  val x = 2 //x is FIELD
  println(1 + 1)

  //method - function inside class
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading - same name but different parameters
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}


/*
  Counter class
    -receives an int value
    -method current count
    -method to increment/decrement => new Counter
    -overload inc/dec to receive an amount => new Counter

*/

class Counter(val n: Int = 0){
  def count = n // same with adding val in constructor
  def inc = new Counter(count + 1) // immutability - important in functional programming
  def dec = new Counter(count - 1)

  //overloads
  //def inc(n: Int) = new Counter(count + n)
  //def dec(n: Int) = new Counter(count - n)

  def inc(n: Int): Counter = {
    if(n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)
}
//class parameters are not FIELDS person.age -err - we need to add val before age
}
/*
  Implement a Novel and a Writer
  Writer: first name, surname, year
    -method fullname
  Novel: name, year of release, author
    -authorAge
    -isWrittenBy(author)
    -copy(new year of release) = new instance of novel
*/
class Writer(firstName: String, surname: String, val year: Int){
  def fullname(): String =
    firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer){
  def authorAge = yearOfRelease - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}