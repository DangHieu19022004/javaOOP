/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLSV;

import java.util.Arrays;


public class Student {
    private String name;
    private String id;
    private String major;
    private Course[] courses;
    private int CAPACITY = 50;

    public String getName() {
        return name;
    }

    public Student(String name, String id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

    public String getID() {
        return id;
    }

    public String getMajor() {
        return major;
    }
    
    public void addCourse(Course c){
    }
    
    public void dropCourse(Course c){
    }
    
    public double getGPA(){
        return 0;
    }
    
    public boolean isTalking(Course c){
        return false;
    }
    
    public String toString(){
        return "name: " + name + "\t" + "id: " + id + "\t" + "major: " + major + "\t" + "Course: " + Arrays.toString(courses) + "\t" + "Capacity: " + CAPACITY;
    }
}
