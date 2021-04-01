package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<Student>();

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        for (Student s : students){

            if (s.getAverageGrade()==value) return s;

        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:

        TreeMap<Double, Student> map = new TreeMap<>();
        for (Student s : students){

            map.put(s.getAverageGrade(), s);
        }

        Student s1 = map.lastEntry().getValue();

        return s1;
    }

    public Student getStudentWithMinAverageGrade() {
        TreeMap<Double, Student> map = new TreeMap<>();
        for (Student s : students){

            map.put(s.getAverageGrade(), s);
        }

        Student s1 = map.firstEntry().getValue();

        return s1;
    }

    public void expel(Student student) {

        students.remove(student);
    }

}