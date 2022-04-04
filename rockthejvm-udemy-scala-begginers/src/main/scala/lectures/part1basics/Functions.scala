package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b //the + is string concatenation

  def aFunctionWithBlock(a: String, b: Int): String = {
    a + " " + b
  }

  //the return type is optional, but not for RECURSIVE functions
  //for a good practise we always write them
  def aFunctionWithBlockWithoutReturnType(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  //print(aParameterlessFunction) //can be called without the ()

  def aRepeatedFunction(aString: String, n: Int): String =
    if(n == 1) aString
    else aString + " " + aRepeatedFunction(aString, n - 1)

  println(aRepeatedFunction("hello", 3))

  //WHEN YOU NEED LOOPS, USE RECURSION!

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  //code blocks allow you to define auxiliary functions inside them
  def aBigFunction(n:Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /* Exercises
    1. A greeting function(name, age) => "Hi my name is $name and I am $age years old"
    2. Factorial function 1 * 2 * 3 *...*n
    3. A Fibonacci function f(1) = 1, f(1), f(n) = f(n-1) + f(n-2)
    4. Tests if a number is prime
  */

  def aGreetingFunction(name: String, age: Int): Unit =
    println("Hi my name is " + name + " and I am " + age + " years old")

  aGreetingFunction("Nate", 25)

  def aFactorialFunction(n: Int): Int =
    if(n <= 0) 1
    else
      n * aFactorialFunction(n-1)

  println(aFactorialFunction(5)) //120

  def aFibonacciFunction(n: Int): Int =
    if(n <= 2) 1
    else aFibonacciFunction(n-1) + aFibonacciFunction(n-2)

  println(aFibonacciFunction(8))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1) true
      else n % t !=0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(2003))
}
