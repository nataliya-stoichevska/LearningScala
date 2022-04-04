package playground;

public class JavaPlayground {

    public static void main(String[] args) {
        System.out.println(Person.N_EYES); //acces from class not from instance of class CLASS-LEVEL FUNCTIONALITY
    }
}

class Person {
    //constant
    public static final int N_EYES = 2;
}
