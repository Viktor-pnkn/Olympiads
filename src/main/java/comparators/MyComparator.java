package comparators;

import model.Student;

import java.util.Comparator;

public interface MyComparator<T> extends Comparator<T> {
    int compare(Student o1, Student o2);
}
