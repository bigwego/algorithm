import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Solution extends Number {

    public static void main(String[] args) throws FileNotFoundException {
        new HashMap<>().put(null, null);
        new ConcurrentHashMap<>().put(null, null);
    }

    void test() {
        System.out.println(super.getClass().getName());
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}

class Super {

    static int a;

    Inner inner = new Inner();

    void method() throws RuntimeException {


    }

    static class Inner {
        int b = a;
    }
}

class Sub extends Super {

    @Override
    public void method() {

    }
}

interface Inter {

    static void methdo() {
        System.out.println("inter");
    }
}

abstract class A {
}