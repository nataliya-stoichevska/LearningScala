package exercises

abstract class MyList {
  /*
   methods:
      head = first element of this list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) => new list with this element added
      toString => string representation of the list
  */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  //polymorphic call
  //we need override because toString is a method that is present in AnyRef class; also equals and hash 
  override def toString: String = "[" + printElements + "]"
}
//??? is Nothing

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)

  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, tail)

  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, Empty))
  println(list.head)
  println(list.add(4).head)
  println(list.isEmpty)
}
