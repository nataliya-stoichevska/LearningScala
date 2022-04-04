package exercises

abstract class MyListGenericAnonymous [+A] {
  /*
   methods:
      head = first element of this list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) => new list with this element added
      toString => string representation of the list
  */

  def head: A
  def tail: MyListGenericAnonymous[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGenericAnonymous[B]
  def printElements: String
  //polymorphic call
  //we need override because toString is a method that is present in AnyRef class; also equals and hash 
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]) : MyListGenericAnonymous[B]
  def flatMap[B](transformer: MyTransformer[A, MyListGenericAnonymous[B]]) : MyListGenericAnonymous[B]
  def filter(predicate: MyPredicate[A]) : MyListGenericAnonymous[A]
}
//??? is Nothing

//object EmptyGA extends MyListGenericAnonymous[Nothing] {
//  def head: Nothing = throw new NoSuchElementException
//  def tail: MyListGenericAnonymous[Nothing] = throw new NoSuchElementException
//  def isEmpty: Boolean = true
//  def add[B >: Nothing](element: B): MyListGenericAnonymous[B] = new ConsGA(element, EmptyGA)
//
//  def printElements: String = ""
//}

//class ConsGA[+A](h: A, t: MyListGenericAnonymous[A]) extends MyListGenericAnonymous[A] {
//  def head: A = h
//  def tail: MyListGenericAnonymous[A] = t
//  def isEmpty: Boolean = false
//  def add[B >: A](element: B): MyListGenericAnonymous[B] = new ConsGA(element, tail)
//
//  def printElements: String =
//    if(t.isEmpty) "" + h
//    else h.toString + " " + t.printElements
//}

trait MyPredicate[-T]{
  def test(elem: T) : Boolean
}

trait MyTransformer[-A, B]{
  def transform(elem: A): B
}



object ListTestGA extends App {
//  val listIntegers: MyListGenericAnonymous[Int] = EmptyGA
//  val listOfStrings: MyListGenericAnonymous[String] = EmptyGA
//
//  val listI: MyListGenericAnonymous[Int] = new ConsGA(1, new ConsGA(2, new ConsGA(3, EmptyGA)))
//  val listS: MyListGenericAnonymous[String] = new ConsGA("Hello", new ConsGA("Scala", new ConsGA("!", EmptyGA)))
//
//  println(listI.toString)
//  println(listS.toString)
}
