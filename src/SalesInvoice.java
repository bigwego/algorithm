import java.util.Scanner;

public class SalesInvoice extends Invoice {

    public static String formatId(String oldId) {
        return oldId + "_SalesInvoice";
    }

    public static void main(String[] args) {
        Double d = new Double("17.46d");
        Boolean b = new Boolean("false");
        Float f = new Float(23.43);
//        Integer i = Integer.parseUnsignedInt(4);
//        Character c = new Character("C");
    }
}

interface I1 {


    String name = "N1";


    String s1 = "S1";

}


interface I2 extends I1 {


    String name = "N2";

}


class C2 implements I2 {


    public static void main(String[] args) {
        int i = 10, j = 12;
        for (; ; ) {
            if (i++ < j--)
                continue;
            else
                break;
        }
    }

}

class StringBuilderDemo {


    public static void main(String[] argList) {
        StringBuilder str = new StringBuilder();
        for (String arg : argList) {
            if (str.indexOf(arg) < 1)
                str.append(arg + " ");

        }
        System.out.println(str.toString());
        Scanner sc = new Scanner(str.toString());
        while (sc.hasNext()) {
            if (sc.hasNextInt())
                System.out.print(sc.nextInt() + " ");
            else
                sc.next();

        }

    }

}