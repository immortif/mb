package ecom.mbc.interfaceTest;

import org.junit.Test;

public class Bird implements Fly{

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        System.out.println("Immortif fly in public");
    }

    @Test
    public void test() {
        new Bird().fly();
    }
    
}
