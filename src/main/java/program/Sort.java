package program;

import comparators.StudentGroupComparator;
import comparators.StudentPointComparator;
import model.Student;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        /*int[] mass = new int[]{3,2,5,6,1,7,8,3,4,3,4,2};
        Arrays.sort(mass);*/
        /*Student[] mass = new Student[]{new Student("a", "b", 11,7,1),
                new Student("b", "b", 10,1,1),new Student("c", "c", 50,4,4),
                new Student("a", "a", 34,1,1)};
        Arrays.sort(mass, new StudentGroupComparator());
       // System.out.println(Arrays.toString(mass));
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("a", "b", 70,70,10));
        list.add(new Student("b", "a", 56,8,8));
        list.sort(new StudentPointComparator());
        System.out.println(list);

        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getSchool(), o2.getSchool());
            }
        });
        System.out.println(list);

        TreeMap<Integer, Integer> map = new TreeMap<>();*/
        Map<Student, Integer> m = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
               return Integer.compare(o1.getPoint(), o2.getPoint());
            }
        });
        m.put(new Student("a", "b", 11,7,1), 2800);
        m.put(new Student("c", "c", 50,4,4), 17000);
        m.put( new Student("b", "b", 10,1,1), 2900);
        System.out.println(m);



    }
}
