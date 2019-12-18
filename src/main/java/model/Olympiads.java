package model;

import sun.nio.cs.ext.IBM037;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Olympiads {
    public static ArrayList<Student> loadData(String fileName) throws IOException {
        ArrayList<Student> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        boolean f = false;
        while (br.ready()) {
            String s = br.readLine();
            if (f) {
                String[] s1 = s.split(" ");
                if (s1[2].equals("-")) {
                    list.add(new Student(s1[1], s1[0], -1, Integer.parseInt(s1[3]), Integer.parseInt(s1[4])));
                } else {
                    list.add(new Student(s1[1], s1[0], Integer.parseInt(s1[2]), Integer.parseInt(s1[3]), Integer.parseInt(s1[4])));
                }
            } else {
                f = true;
            }
        }
        br.close();
        return list;
    }

    /**
     * Определите количество баллов, которое набрал победитель в каждом классе.
     * Гарантируется, что в каждом классе был хотя бы один участник.
     */
    public static Map<Integer, Integer> getScoreWinners(ArrayList<Student> list) {
        Map<Integer, Integer> scores = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!scores.containsKey(list.get(i).getGroup())) {
                scores.put(list.get(i).getGroup(), list.get(i).getPoint());
            } else {
                if (list.get(i).getPoint() > scores.get(list.get(i).getGroup())) {
                    scores.put(list.get(i).getGroup(), list.get(i).getPoint());
                }
            }
        }
        return scores;
    }
    /**
     * цикл по мапе
     */

    /**
     * Победители олимпиады без деления на классы. Через предыдущие методы
     */
    public static ArrayList<Student> winners(ArrayList<Student> list) {
        int max = 0;
        for (Student st : list) {
            if (st.getPoint() > max) {
                max = st.getPoint();
            }
        }
        ArrayList<Student> winners = new ArrayList<>();
        for (Student st : list) {
            if (st.getPoint() == max) {
                winners.add(st);
            }
        }
        return winners;
    }

    /**
     * Победители по классам
     */
    //переделать через ArrayList
    public static Map<Integer, Student> winnersClasses(ArrayList<Student> list) {
        Map<Integer, Student> winners = new HashMap<>();
        for (Student st : list) {
            if (!winners.containsKey(st.getGroup())) {
                winners.put(st.getGroup(), st);
            } else {
                if (st.getPoint() > winners.get(st.getGroup()).getPoint()) {
                    winners.put(st.getGroup(), st);
                }
            }
        }
        return winners;
    }

    /**
     * Число победителей в каждом классе
     */
    //через предыдущий метод (size)
    public static Map<Integer, Integer> countWinners(ArrayList<Student> list) {
        Map<Integer, Student> winners = winnersClasses(list);
        Map<Integer, Integer> countWinners = new HashMap<>();
        for (Student st : list) {
            if (st.getPoint() == winners.get(st.getGroup()).getPoint()) {
                if (!countWinners.containsKey(st.getGroup())) {
                    countWinners.put(st.getGroup(), 1);
                } else {
                    countWinners.put(st.getGroup(), countWinners.get(st.getGroup()) + 1);
                }
            }
        }
        return countWinners;
    }

    /**
     * Баллы призеров по классам(вторые места)
     */
    //исправить через ArrayList
    public static Map<Integer, Student> medalistClasses(ArrayList<Student> list) {
        Map<Integer, Student> medalists = new HashMap<>();
        Map<Integer, Student> winners = winnersClasses(list);
        Student s = new Student("none", "none", 0, 0, 0);
        for (Student st : list) {
            if (!medalists.containsKey(st.getGroup())) {
                if (st.getPoint() == winners.get(st.getGroup()).getPoint()) {
                    medalists.put(st.getGroup(), s);
                } else {
                    medalists.put(st.getGroup(), st);
                }
            } else {
                if (st.getPoint() > medalists.get(st.getGroup()).getPoint() && st.getPoint() < winners.get(st.getGroup()).getPoint()) {
                    medalists.put(st.getGroup(), st);
                }
            }
        }
        return medalists;
    }

    /**
     * Определите школы, из которых в олимпиаде принимало участие больше всего участников.
     * Выведите номера этих школ в порядке возрастания.
     */
    public static TreeMap<Integer, Integer> mostSchools(ArrayList<Student> list) {
        Map<Integer, Integer> studentsFromEachSchool = studentsFromEachSchool(list); // школа - количество победителей в ней
        TreeMap<Integer, Integer> mostSchools = new TreeMap<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : studentsFromEachSchool.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : studentsFromEachSchool.entrySet()) {
            if (entry.getValue() == max) {
                mostSchools.put(entry.getKey(), entry.getValue());
            }
        }
        return mostSchools;
    }

    private static Map<Integer, Integer> studentsFromEachSchool(ArrayList<Student> list) {
        Map<Integer, Integer> studentsFromEachSchool = new HashMap<>();
        for (Student st : list) {
            if (!studentsFromEachSchool.containsKey(st.getSchool())) {
                studentsFromEachSchool.put(st.getSchool(), 1);
            } else {
                studentsFromEachSchool.put(st.getSchool(), studentsFromEachSchool.get(st.getSchool()) + 1);
            }
        }
        return studentsFromEachSchool;
    }

    /**
     * Ученики из классoв
     */
    public static Map<Integer, Set<Student>> studentClasses(ArrayList<Student> list) {
        Map<Integer, Set<Student>> studentClasses = new HashMap<>();
        for (Student st : list) {
            if (!studentClasses.containsKey(st.getGroup())) {
                Set<Student> s = new HashSet<>();
                s.add(st);
                studentClasses.put(st.getGroup(), s);
            } else {
                studentClasses.get(st.getGroup()).add(st);
            }
        }
        return studentClasses;
    }

    /**
     * Средний бал по классам
     */
    public static Map<Integer, Integer> averageClasses(ArrayList<Student> list) {
        Map<Integer, Integer> average = new HashMap<>();
        Map<Integer, Set<Student>> classes = studentClasses(list);
        for (Map.Entry<Integer, Set<Student>> entry : classes.entrySet()) {
            int sum = 0;
            int count = 0;
            for (Student st : entry.getValue()) {
                sum += st.getPoint();
                count++;
            }
            average.put(entry.getKey(), sum / count);
        }
        return average;
    }

    /**
     * Ученики по школам
     */
    public static Map<Integer, Set<Student>> studentSchools(ArrayList<Student> list) {
        Map<Integer, Set<Student>> studentSchools = new HashMap<>();
        for (Student st : list) {
            if (!studentSchools.containsKey(st.getSchool())) {
                Set<Student> s = new HashSet<>();
                if (st.getPoint() != -1) {
                    s.add(st);
                }
                studentSchools.put(st.getSchool(), s);
            } else {
                if (st.getPoint() != -1) {
                    studentSchools.get(st.getSchool()).add(st);
                }
            }
        }
        return studentSchools;
    }

    /**
     * Cредний бал по школам
     */
    public static Map<Integer, Double> averageSchools(ArrayList<Student> list) {
        Map<Integer, Double> average = new HashMap<>();
        Map<Integer, Set<Student>> schools = studentSchools(list);
        for (Map.Entry<Integer, Set<Student>> entry : schools.entrySet()) {
            double sum = 0;
            int count = 0;
            for (Student st : entry.getValue()) {
                sum += st.getPoint();
                count++;
            }
            average.put(entry.getKey(), sum / count);
        }
        return average;
    }

    /**
     * Выведите студента, набравшего наибольший балл, но не ставшего победителем.
     * Если таких студентов несколько - выведите их количество.
     */
    public static Object secondPlace(ArrayList<Student> list) {
        int max = 0;
        int max2 = 0;
        int count = 0;
        Student s = null;
        Map<Integer, Student> medalists = medalistClasses(list);
        for (Map.Entry<Integer, Student> entry : medalists.entrySet()) {
            if (entry.getValue().getPoint() > max) {
                max = entry.getValue().getPoint();
            }
        }
        for (Student st : list) {
            if (st.getPoint() == max) {
                count++;
                if (count == 1) {
                    s = st;
                }
            }
        }
        if (count == 1) {
            return s;
        } else {
            return count;
        }
    }

    /**
     * Bыведите номера школ, из которых был хотя бы один участник олимпиады, в порядке убывания количества участников олимпиады из этих школ.
     * Если из двух школ было одинаковое число участников, то их номера выводятся в порядке возрастания номера школы.
     */
    public static ArrayList<Integer> getSchoolLeaders(ArrayList<Student> list) {
        ArrayList<Integer> leaders = new ArrayList<>();
        Map<Integer, Set<Student>> studentSchools = studentSchools(list);
        ArrayList<Map.Entry<Integer, Set<Student>>> lst = new ArrayList<>(studentSchools.entrySet());
        lst.sort(new Comparator<Map.Entry<Integer, Set<Student>>>() {
            @Override
            public int compare(Map.Entry<Integer, Set<Student>> o1, Map.Entry<Integer, Set<Student>> o2) {
                if (Integer.compare(o1.getValue().size(), o2.getValue().size()) == 0) {
                    return Integer.compare(o1.getKey(), o2.getKey());
                } else {
                    return -Integer.compare(o1.getValue().size(), o2.getValue().size());
                }
            }
        });
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (Map.Entry<Integer, Set<Student>> entry : lst) {
            map.put(entry.getKey(), entry.getValue().size());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            leaders.add(entry.getKey());
        }
        return leaders;
    }

    public static ArrayList<Integer> getSchoolLeaders1(ArrayList<Student> list) {
        ArrayList<Integer> leaders = new ArrayList<>();
        Map<Integer, Set<Student>> studentSchools = studentSchools(list);
        ArrayList<Map.Entry<Integer, Set<Student>>> lst = new ArrayList<>(studentSchools.entrySet());
        lst.sort(new Comparator<Map.Entry<Integer, Set<Student>>>() {
            @Override
            public int compare(Map.Entry<Integer, Set<Student>> o1, Map.Entry<Integer, Set<Student>> o2) {
                if (Integer.compare(o1.getValue().size(), o2.getValue().size()) == 0) {
                    return Integer.compare(o1.getKey(), o2.getKey());
                } else {
                    return -Integer.compare(o1.getValue().size(), o2.getValue().size());
                }
            }
        });

        for (Map.Entry<Integer, Set<Student>> entry : lst) {
            leaders.add(entry.getKey());
        }
        return leaders;
    }

    /**
     * Выведите номера школ, из которых был хотя бы один участник олимпиады, в порядке убывания среднего балла участников олимпиады из этих школ.
     * Если для двух школ средний балл участников совпадает, то их номера выводятся в порядке возрастания номера школы.
     */
    public static ArrayList<Integer> getSchoolAverage(ArrayList<Student> list) {
        ArrayList<Integer> schools = new ArrayList<>();
        Map<Integer, Double> average = averageSchools(list);
        ArrayList<Map.Entry<Integer, Double>> lst = new ArrayList<>(average.entrySet());
        lst.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (!o1.getValue().equals(o2.getValue())) {
                    return -Double.compare(o1.getValue(), o2.getValue());
                } else {
                    return Integer.compare(o1.getKey(), o2.getKey());
                }
            }
        });
        for (Map.Entry<Integer, Double> entry : lst) {
            schools.add(entry.getKey());
        }
        return schools;
    }
}
