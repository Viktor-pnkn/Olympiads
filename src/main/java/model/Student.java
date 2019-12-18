package model;

import java.util.function.Consumer;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private int point;
    private int group;
    private int school;

    public Student(String name, String surname, int point, int group, int school) {
        this.name = name;
        this.surname = surname;
        this.point = point;
        this.group = group;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.group + " " + this.point + " " + this.school + "\n";
    }

    @Override
    public int compareTo(Student o) {
        if (this.getSurname().compareTo(o.getSurname()) == 0) {
            return this.getName().compareTo(o.getName());
        } else {
            return this.getSurname().compareTo(o.getSurname());
        }
    }

}
