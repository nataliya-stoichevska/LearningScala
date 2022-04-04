package lectures.part1basics

object DefaultArgs extends App {

  def trFactorial(n: Int, acc: Int): Int =
    if(n <= 1) acc
    else trFactorial(n - 1, n * acc)

  val fact10 = trFactorial(10, 1) //accumulator pollutes the function signature

  def trFactorialDefaults(n: Int, acc: Int = 1): Int =
    if(n <= 1) acc
    else trFactorial(n - 1, n * acc)

  val fact10Default = trFactorialDefaults(10) //we don't need to pass accumulator

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")


  //err savePicture(800, 600)
  //err savePicture(800)

  /* solutions:
    1. pass in every leading argument
    2. name the arguments
  */

  savePicture(width = 800)
  //even in different order
  savePicture(height = 900, width = 790, format = "bmp")


}
