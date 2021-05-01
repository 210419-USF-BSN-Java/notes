// name of the class needs to match the file name exactly
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello World!");
        System.out.println(Person.age)
        System.out.println(args[0]);
    }
}

// Legal (because not public) but not best practice
class AnotherClass{

}
