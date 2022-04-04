package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //println(x.length) //NullPointerException

  //1. throwing exceptions

  //val aWiredValue = throw new NullPointerException //- in scala this is an expression //of type Nothing
  //exceptions are classes. throwable classes extend the Throwable class.
  //Exception and Error are the major Throwable subtypes

  //2. catching exceptions
  def getInt(withExceptions: Boolean): Int = {
    if withExceptions then throw new RuntimeException("No int for you!")
    else 42
  }

  try {
    //code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a Runtime exception!")
  } finally {
    //code that will get executed NO MATTER WHAT
    println("finally!")
  }

  //AnyVal, because we return different types; if we return same types it is of that type
  val potentialFail = try {
    //code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a Runtime exception!")
  } finally {
    //code that will get executed NO MATTER WHAT
    //optional
    //does not influence the return type of this expression
    //use finally only for side effects
    println("finally!")
  }

  println(potentialFail)

  //3. How to define our own exceptions
  class MyException extends Exception

  val exception = new MyException
  //throw exception

  /**
   * Exercises
   * 1. Crash your program with an OutOfMemoryError
   * 2. Crash with Stack overflow error
   * 3.PocketCalculator
   * --add
   * --subtract
   * --multiply
   * --divide
   *
   * Throw
   * --OverflowException if add exceeds Int.MAX_VALUE
   * --UnderflowException if subtract exceeds Int.MIN_VALUE
   * --MathCalculationException for division by 0
   */

  //val array = Array.ofDim[Int](Int.MaxValue) //OutOfMemoryError

  //Stack overflow
  //def infinite: Int = 1 + infinite 
  //val noLimit = infinite
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      //if(result > Int.MaxValue) //result will never be greater than Int.MaxValue
      //the Integer gets overflown and returns - value
      if x > 0 && y > 0 && result < 0 then throw new OverflowException()
      else if x < 0 && y < 0 && result < 0 then throw new UnderflowException()
      else result
    }
    def subtract(x: Int, y: Int): Int ={
      val result = x - y
      if x > 0 && y < 0 && result < 0 then throw new OverflowException
      else if x < 0 && y > 0 && result > 0 then throw new UnderflowException
      else result
    }
    
    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if x > 0 && y > 0 && result < 0 then throw new OverflowException
      else if x < 0 && y < 0 && result < 0 then throw new OverflowException
      else if x > 0 && y < 0 && result > 0 then throw new UnderflowException
      else if x < 0 && y < 0 && result > 0 then throw new UnderflowException
      else result
    }
    
    def divide(x: Int, y: Int): Int = {
      if y == 0 then throw new MathCalculationException
      else x / y
    }
  }
  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
}
