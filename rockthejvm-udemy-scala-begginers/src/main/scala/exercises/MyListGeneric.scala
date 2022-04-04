package exercises

abstract class MyListGeneric [+A] {
  /*
   methods:
      head = first element of this list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) => new list with this element added
      toString => string representation of the list
  */

  def head: A
  def tail: MyListGeneric[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGeneric[B]
  def printElements: String
  //polymorphic call
  //we need override because toString is a method that is present in AnyRef class; also equals and hash 
  override def toString: String = "[" + printElements + "]"
}
//??? is Nothing

object EmptyG extends MyListGeneric[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListGeneric[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGeneric[B] = new ConsG(element, EmptyG)

  def printElements: String = ""
}

class ConsG[+A](h: A, t: MyListGeneric[A]) extends MyListGeneric[A] {
  def head: A = h
  def tail: MyListGeneric[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGeneric[B] = new ConsG(element, tail)

  def printElements: String =
    if(t.isEmpty) "" + h
    else h.toString + " " + t.printElements
}

object ListTestG extends App {
  val listIntegers: MyListGeneric[Int] = EmptyG
  val listOfStrings: MyListGeneric[String] = EmptyG

  val listI: MyListGeneric[Int] = new ConsG(1, new ConsG(2, new ConsG(3, EmptyG)))
  val listS: MyListGeneric[String] = new ConsG("Hello", new ConsG("Scala", new ConsG("!", EmptyG)))

  println(listI.toString)
  println(listS.toString)
}
