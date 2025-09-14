package ua.opnu;

import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private ArrayList<String> disciplines = new ArrayList<>();


    public Student(String name, int year) {
        this.name=name;
        this.year=year;

    }
    public void dropAll(){
        disciplines.clear();
    }
    public void addCourse(String courseName) {
        if (courseName != null && !courseName.trim().isEmpty()) {
            disciplines.add(courseName);
        } else {
            throw new IllegalArgumentException("Назва курсу не може бути порожньою.");
        }
    }
    public int getYear(){
        return year;
    }
    public String getName(){
        return name;
    }
    public int getTuition(){
        return year*20000;
    }
    public int getCourseCount(){
        return disciplines.size();
    }
}
