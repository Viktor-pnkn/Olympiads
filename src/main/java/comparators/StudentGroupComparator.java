package comparators;

import model.Student;

import java.util.Comparator;

public class StudentGroupComparator implements MyComparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getGroup(), o2.getGroup());
    }
}
