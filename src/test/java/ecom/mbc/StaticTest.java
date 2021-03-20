package ecom.mbc;

public class StaticTest {
    static {
        System.out.println("One line of STATIC CODE!");
        System.out.println("Coder wants to know when these codes run.");
    }

    public StaticTest() {
        System.out.println("I'm a default constructor of StaticTest class.");
    }

    public static void staticMethod() {
        System.out.println("I'm a static method.");
    }

}
