package exercises

abstract class MyListCaseCl [+A] {
  /*
   methods:
      head = first element of this list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) => new list with this element added
      toString => string representation of the list
  */

  def head: A
  def tail: MyListCaseCl[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListCaseCl[B]
  def printElements: String
  //polymorphic call
  //we need override because toString is a method that is present in AnyRef class; also equals and hash 
  override def toString: String = "[" + printElements + "]"
}
//??? is Nothing

case object EmptyCC extends MyListCaseCl[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListCaseCl[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListCaseCl[B] = new ConsCC(element, EmptyCC)

  def printElements: String = ""
}

case class ConsCC[+A](h: A, t: MyListCaseCl[A]) extends MyListCaseCl[A] {
  def head: A = h
  def tail: MyListCaseCl[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListCaseCl[B] = new ConsCC(element, tail)

  def printElements: String =
    if(t.isEmpty) "" + h
    else h.toString + " " + t.printElements
}

object ListTestCC extends App {
  val listIntegers: MyListCaseCl[Int] = EmptyCC
  val cloneListIntegers: MyListCaseCl[Int] = EmptyCC
  val listOfStrings: MyListCaseCl[String] = EmptyCC

  val listI: MyListCaseCl[Int] = new ConsCC(1, new ConsCC(2, new ConsCC(3, EmptyCC)))
  val listS: MyListCaseCl[String] = new ConsCC("Hello", new ConsCC("Scala", new ConsCC("!", EmptyCC)))

  println(listI.toString)
  println(listS.toString)

  println(cloneListIntegers == listIntegers) //true because of case classes
}
