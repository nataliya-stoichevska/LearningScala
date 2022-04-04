package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {

  //STACK FRAME
  def aFactorialFunction(n: Int): Int =
    if(n <= 0) 1
    else {
      println("Computing factorial of " + n + "; I first need factorial of " + (n - 1))
      val result = n * aFactorialFunction(n-1)
      println("Computed factorial of " + n)

      result
    }

  println(aFactorialFunction(5))
  //stack overflow
  //println(aFactorialFunction(5000))

  def anotherFactorial(n: BigInt): BigInt = {
    @tailrec  //tels the compiler that the function is supposed to be tail recursive
    def factHelper(x:BigInt, accumulator: BigInt): BigInt =
      if(x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) //recursive call as LAST expression

    factHelper(n, 1)
  }

  //this does not give stack overflow because scala does not use multiple stack frames ; TAIL RECURSION = use recursive call as LAST expression
  println(anotherFactorial(5000))

  //WHEN YOU NEED LOOPS USE TAIL RECURSION

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
  */

  @tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String =
    if(n <= 0) accumulator
    else concatenateTailRec(aString, n - 1, aString + accumulator)

  println(concatenateTailRec("hello", 3, " "))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if(t <= 1) true
      else isPrimeTailRec(t-1, n % t != 0 && isStillPrime)

    isPrimeTailRec(n/2, true)
  }

  println(isPrime(2003))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailRec(i: Int, last: Int, nextToLAst: Int): Int =
      if(i >= n) last
      else fibonacciTailRec(i + 1, last + nextToLAst, last)
      
    if(n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }
  
  println(fibonacci(8))
}
