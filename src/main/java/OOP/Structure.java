package OOP;

public class Structure {
    /* creating the method (not static) in the class body*/
    public void toDo() {
        System.out.println("What the object can do");
    }

    /* creating the method (not static) with parameters*/
    public void canToDo(String argument) {
        System.out.println("Can " + argument);
    }

    /* creating the method (static) with return(not void)*/
    public static boolean check(int num) {
        return num > 0;
    }

    public static void main(String[] args) {
        /*creating the object*/
        Structure table = new Structure();

        /*method call(not static)*/
        table.toDo();

        /*method call with argument (not static)*/
        table.canToDo("show relationships");

        /*static method call with argument*/
        System.out.println(Structure.check(2));

    }
}
