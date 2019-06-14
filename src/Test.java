import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class Test {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {

        }
    }

    public static void main() {
        System.out.println("main 2");
    }


}


class Indices {
    public String s;

    public List<Integer> indices;

    public Indices(String s) {
        this.s = s;
        indices = new LinkedList<>();
        for (int i = 0; i < this.s.length(); ++i) {
            indices.add(i);
        }
    }
}

class TestIndices {
    public static void main(String[] args) {
        int a = 0;
        System.out.println((a != 0) ? "true" : "false");
        Double d = null;
        System.out.println((d instanceof Double) ? "true" : "false");

        boolean b = false;
        System.out.println((b = true) ? "true" : "false");
        int c = 0;
        System.out.println((0 == c++) ? "true" : "false");
        String e = "1";
        System.out.println(("1" != e) ? "true" : "false");
    }
}

class A {
    static int total = 10;

    public void call() {
        int total = 5;
        System.out.println(this.total);
    }


}