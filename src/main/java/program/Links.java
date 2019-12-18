package program;

import model.Car;

public class Links {

    static void f1(Car a){
        a = new Car(10);
        System.out.println(a);
    }

    static void f2(Car b){
        b.setPower(12);
    }

    static void f3(String s){
        s += "fds";
        System.out.println(s);
    }

    static void f4(StringBuilder sb) {
        sb.append("fds");
        System.out.println(sb);
    }
    public static void main(String[] args) {

        /*Integer g = 10;
        Integer f = 10;
        System.out.println(g==f);

        String s1 = "aaa";
        String s2 = "aaa";
        System.out.println(s1==s2);*/

        /*Car f = new Car(5);//ptr_f        5
        Car d = new Car(5);//ptr_d        5
        System.out.println(f.equals(d));*/
       /* f2(f);
        System.out.println(f);
        String s = "qqqq";
        f3(s);
        System.out.println(s);
        StringBuilder sb = new StringBuilder("qqqq");
        f4(sb);
        System.out.println(sb);*/
    }
}
