import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Invoice {
    public static String formatId(String oldId) {
        return oldId + "_Invoice";
    }
}


class Super {
    public Super() {

    }
}

class Shape {}

class Quadrilateral extends Shape {}

class Triangle extends Shape {

    public static void main(String[] args) {
        Shape shape = new Quadrilateral();
        Quadrilateral quadrilateral = new Quadrilateral();


        Triangle tri = (Triangle) shape;
    }
}

class CalendarTest {
    public static void main(String[] args) {
        Date aDate = null;
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTimeInMillis(1450000000000L);
        aDate = aCalendar.getTime();
        System.out.print(new SimpleDateFormat("dd-MMM-yyyy").format(aDate));

        Instant anInstant = Instant.ofEpochMilli(1450000000000L);
        DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        System.out.println(" " + LocalDateTime.ofInstant(anInstant, ZoneId.systemDefault()).format(d));

        aCalendar.add(Calendar.DAY_OF_MONTH, 60);
        aDate = aCalendar.getTime();
        System.out.print(new SimpleDateFormat("dd-MMM-yyyy").format(aDate));

        anInstant.plus(60, ChronoUnit.DAYS);
        System.out.println(" " + LocalDateTime.ofInstant(anInstant, ZoneId.systemDefault()).format(d));
    }
}

class IKMProcessor {
    public List<String> queueSequence;

    public void setUp() {
        try {
            establishQueueSequence();
        } finally {
            cleanupQueueSequence();
            System.out.println("Queue sequence successfully cleaned up");
        }
    }

    private void cleanupQueueSequence() {
        if (queueSequence.size() > 0) {
            System.out.println("Queue size > 0");
        }
    }

    private void establishQueueSequence() {
        if (true) {
            throw new IllegalArgumentException();
        }
        queueSequence = new ArrayList<String>();
    }

    public static void main(String[] args) {
        IKMProcessor processor = new IKMProcessor();
        processor.setUp();
        System.out.println("Processing complete");
    }
}

class JavaClass {
    public static void main(String arg[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

    }
}

interface StringMapper<T> {
    String map(T t);
}

class X {
    String s;

    public X(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s.toLowerCase();
    }

    public String toLowerCase() {
        return s.toLowerCase();
    }
}

class Y<T> {
    T s;

    public Y(T s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s.toString();
    }
}

class H2 {
    static String mapme(Y y, StringMapper<Y> t) {
        return t.map(y);
    }

    static String mapme(X x, StringMapper<X> t) {
        return t.map(x);
    }

    public static void main(String[] args) {
        System.out.println(mapme(new Y<>(3), e -> {
            return e.toString().equals("3") ? "hello" : "HELLO";
        }));


        System.out.println(mapme(new X("HELLO"),
                e -> {
                    if (e.s.charAt(0) == 'H') return e.toString();
                    return e.toLowerCase();
                }));

        System.out.println(mapme(new Y<>("HELLO"), e -> e.toString()));

        System.out.println(mapme(new Y<>(3), e -> e.toString()));

        System.out.println(mapme(new Y<>(new X("HELLO")), e -> {
            return e.toString();
        }));

    }
}

class IkmTest {
    public IkmTest() {
        this(10);
    }

    public IkmTest(int data) {
        this.data = data;
    }

    public void display() {
        class Decrementer {
            public void decrement() {
                data--;
            }
        }
        Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("data = " + data);
    }

    private int data;

    public static void main(String[] args) {
        int data = 0;
        IkmTest t = new IkmTest();
        t.display();
        System.out.println("data = " + data);
    }
}

class IKMTest {
    public static void main(String[] args) {
        Double d = 1.0;
        if (d instanceof Number)
            d = d++;
        boolean condition1 = (d == 2) ? true : false;
        if (condition1)
            System.out.println("Perform action1");
        double e = 1.0;
        if ((Double) e instanceof Double | d++ == e++)
            d += d;
        boolean condition2 = (d > 2) ? true : false;
        if (condition2)
            System.out.println("Perform action2");
        boolean condition3 = condition1 ^ condition2;
        if (condition3)
            System.out.println("Perform action3");
    }
}


interface DatabaseOperations {
    ResultSet getData(String query);

    default void executeProcedure(String procedureName) {
        System.out.println("do nothing");
    }

    Connection getConnection();
}


class IkmTest2 {

    public static void main(String[] args) {
        SortedSet<Element> s = new TreeSet<Element>();
        s.add(new Element(15));
        s.add(new Element(10));
        s.add(new Element(25));
        s.add(new Element(10));
        System.out.println(s.first() + " " + s.size());
    }
}

class Element implements Comparable {
    int id;

    Element(int id) {
        this.id = id;
    }

    public int compareTo(Object obj) {
        Element e = (Element) obj;
        return this.id - e.id;
    }

    public String toString() {
        return "" + this.id;
    }
}

class Namer {
    final private String firstName, lastName;

    public Namer(String fn, String ln) {
        firstName = fn;
        lastName = ln;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class Sorter {
    public static void main(String[] args) {
        Consumer<Namer> printit = e -> System.out.println(e.getFirstName() + " " + e.getLastName());
        List<Namer> names = new ArrayList(Arrays.asList(
                new Namer("Harry", "Smith"), new Namer("Joe", "Smith"), new Namer("Jane", "Doe"),
                new Namer("Mary", "Jane"), new Namer("Harry", "Homeowner")));

        Collections.sort(names, (Namer e1, Namer e2) -> e1.getFirstName().compareTo(e2.getFirstName()));
        names.removeIf(e -> e.getFirstName().equals("Mary"));
        for (Namer e : names)
            System.out.println(e.getFirstName() + " " + e.getLastName());
    }
}

class SystemManager {
    private static String initString;

    static {
        String currentString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("initconfig.txt"));
            initString = reader.lines().findFirst().orElse(null);
        } catch (IOException ex) {
            throw new NoSuchElementException("File initconfig.txt");
        }
    }

    public SystemManager() {
        if (initString.length() == 0) {
            throw new IllegalArgumentException("length is zero");
        }
        System.out.println("It works!");
    }

    public static void main(String[] args) {
        SystemManager myClass = new SystemManager();
    }
}

interface Company {
    public String getAddress(String companyName);

    default public String getPhoneNumber() {
        return "555-1212";
    }
}

class LocaleDemo {
    public static void main(String[] args) {
        Locale locale = new Locale("USA");
        System.out.println("Country: " + locale.getCountry());
    }
}

class Person {
    String name;

    Integer id;

    Person(String n, Integer i) {
        name = n;
        id = i;
    }

    Person(Integer i) {
        name = null;
        id = i;
    }

    @Override
    public String toString() {
        return name + " " + id;
    }
}

class PersonTest {
    static List<Person> people = Arrays.asList(
            new Person("Bob", 1), new Person(2), new Person("Jane", 3));

    static int x;

    public static void main(String[] args) {
        people.stream()
                .reduce((e1, e2) -> {
                    x = e1.id;
                    if (e1.id > e2.id) return e1;
                    x = e2.id;
                    return e2;
                })
                .flatMap(e -> Optional.ofNullable(e.name))
                .map(y -> new Person(y, x))
                .ifPresent(System.out::println);
    }
}

class ConcurrencyExample {
    private long count;

    private LongAccumulator accum = new LongAccumulator((x, y) -> x + y, count);

    public void incrementCount() {
        accum.accumulate(1);
    }

    public long getCount() {
        return accum.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ConcurrencyExample ce = new ConcurrencyExample();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ce.incrementCount();
                }
            }, "Thread" + i).start();
        }
        Thread.sleep(5000);
        System.out.println("Final number: " + ce.getCount());
    }
}

class MainClassA {
    public static void main(String[] args) {
        System.out.println("Class A " + args[0]);
    }
}

class MainClassB {
    public static void main(String[] args) {
        System.out.println("Class B");
        MainClassA.main(args);
    }
}

class Parent {
    protected static int count = 0;

    public Parent() {
        count++;
    }

    static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        new InputStreamReader(System.in);
    }
}

class EnumDemo {


    public static void main(String args[]) {
        String report = args[0];
        if (report.equals(Report.EMPRPT.getName()))
            System.out.println("Id: " + Report.EMPRPT.getId() + " Name: " + Report.EMPRPT.getName());
        if (report.equals(Report.EMPRPT))
            System.out.println("Id: " + Report.EMPRPT.getId() + " Name: " + Report.EMPRPT.getName());
        if (report.equals(Report.MNGRPT.toString()))
            System.out.println("Id: " + Report.MNGRPT.getId() + " Name: " + Report.MNGRPT.getName());
        if (report.equals(Report.MNGRPT.name()))
            System.out.println("Id: " + Report.MNGRPT.getId() + " Name: " + Report.MNGRPT.getName());

    }

    public enum Report {

        EMPRPT(1, "EMPLOYEE_REPORT"), MNGRPT(2, "MANAGER_REPORT");

        private String name;

        private int id;

        Report(int id, String name) {
            this.setName(name);
            this.id = id;

        }


        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }


        public int getId() {
            return this.id;
        }

    }

}

