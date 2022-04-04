package lectures.part2oop

import playground.{Cinderella, PrinceCharming}

import java.sql // we can rename Cinderella - Cinderella => Princess

//same name different import
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App{

  //package members are accessible by their simple name
  //from OOBasics
  val writer = new Writer("Nate", "Stoi", 25)
  
  //import the package
  var princess = new Cinderella //playground.Cinderella = fully qualified name
  
  //packages are in hierarchy
  //matching folder structure
  
  //package object
  sayHello
  println(SPEED_OF_LIGHT)
  
  //imports
  val prince = new PrinceCharming //import groups PrinceCharming and Cinderella;
                                  // we can use _ if there are too much classes
                                  
  //val d = new Date // err
  val sqlDate = new sql.Date(2018, 5, 4) //using fully qualified name
  val sqlDate2 = new SqlDate(2018, 5, 4) // using aliasing
  
  //default imports
  //java.lang - String, Object, Exception ...
  //scala - Int, Nothing, Function ...
  //scala.Predef - println(), ???, ...
}
