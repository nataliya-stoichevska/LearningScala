package lectures.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    //add fields/methods
    def openDocument: Unit =
      if this == READ then println("opening document")
      else println("reading not allowed")
  }

  val somePermissions: Permissions = Permissions.READ

  //constructor args
  enum PermissionsWithBits(bits: Int){
    case READ extends PermissionsWithBits(4) //100
    case WRITE extends PermissionsWithBits(2)// 010
    case EXECUTE extends PermissionsWithBits(1)// 001
    case NONE extends PermissionsWithBits(0) // 000
  }

  //companion object
  object PermissionsWithBits{
    def fromBits(bits: Int): PermissionsWithBits = PermissionsWithBits.NONE
  }

  //standard API
  val somePermissionsOrdinal: Int = somePermissions.ordinal //index in witch this instance occurs in enum definition
  val allPermission = PermissionsWithBits.values //array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ") //Permissions.Read

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument
    println(somePermissions)
  }
}
