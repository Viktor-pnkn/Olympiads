package program;

import model.Olympiads;
import model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        try {

            ArrayList<Student> students = Olympiads.loadData("students.txt");
            /*Map<Integer, Integer> scoreWinners = Olympiads.getScoreWinners(students);
            System.out.println(scoreWinners);
            ArrayList<Student> winners = Olympiads.winners(students);*/
           /* System.out.println("Победители всей олимпиады");
            for (Student st : winners) {
                System.out.println(st.getName() + " " + st.getSurname() + " " + st.getPoint());
            }
            System.out.println("Победители по классам");
            System.out.println(Olympiads.winnersClasses(students));
            System.out.println("Количество победителей в каждом классе");
            System.out.println(Olympiads.countWinners(students));
            System.out.println("Баллы призеров по классам(вторые места)");
            System.out.println(Olympiads.medalistClasses(students));
            System.out.println("Школы, из которых в олимпиаде принимало участие больше всего участников");
            System.out.println(Olympiads.mostSchools(students));
            System.out.println("Студенты в классах");
            System.out.println(Olympiads.studentClasses(students));
            System.out.println("Средний бал по классам");
            System.out.println(Olympiads.averageClasses(students));
            System.out.println("Студенты в школах");
            System.out.println(Olympiads.studentSchools(students));
            System.out.println("Средний бал по школам");
            System.out.println(Olympiads.studentSchools(students));
            Object o = Olympiads.secondPlace(students);
            if (o.getClass() == Student.class) {
                Student s = (Student)o;
                System.out.println(s.getName() + " " + s.getSurname());
            } else {
                Integer count = (Integer) o;
                System.out.println("Количество призеров = " + count);
            }*/
            //System.out.println(o instanceof Student);
            System.out.println(Olympiads.getSchoolLeaders(students));
            System.out.println(Olympiads.getSchoolLeaders1(students));
            System.out.println(Olympiads.averageSchools(students));
            System.out.println(Olympiads.getSchoolAverage(students));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
