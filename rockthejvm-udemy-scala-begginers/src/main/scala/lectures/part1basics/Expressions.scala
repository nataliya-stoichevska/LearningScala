package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 //EXPRESSION, they have types, compiler finds out the type
  println(x)

  // + - * / & | ^ << >> >>(right shift with zero extension)
  println(2 + 3 * 4)

  // == != > < >= <=
  println(1 == x) //also expression

  // ! && ||
  println(!(1 == x)) //logical negation

  // += -= *= /= ...all work with variables... all are side effects
  var aVariable = 2
  aVariable += 3

  //Instructions(you tel the computer to DO) vs Expressions(something that has VALUE and or TYPE)

  //IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 //it gives back a VALUE - that is why it is called expression
  println(aConditionedValue)
  println(if(aCondition) 6 else 8)

  //LOOPS

  //we should not use while loops
  var i = 0
  while(i < 10){
    println(i)
    i+=1
  }

  //EVERYTHING IN SCALA IS AN EXPRESSION!

  //NEVER WRITE THIS AGAIN
  val aWiredValue = (aVariable = 3) //has type Unit==void
  print(aWiredValue) //returns ()

  //SIDE EFFECTS IN SCALA ARE EXPRESSIONS RETURNING ()
  // ^ they are like instructions but in scala they are expressions returning Unit
  //E.G. println(), whiles, reassigning a val

  //Code blocks

  //they are an expressions
  //the value of the block is the value of it's last expression
  //the type of the block is the type of it's last expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z> 2) "hello" else "goodbye"
  }

  //val anotherValue = z + 1 - err z is not vissible here

  //1. difference between "hello world" vs println("hello world")? 
  //                 value of type string vs expression which is side effect
  //2. Boolean
    val someValue = {
      2 < 3
    }
    
    val someOtherValue = {
      if(someValue) 239 else 984
      42 //this is the last value , the if expression is irrelevant
    }
}
