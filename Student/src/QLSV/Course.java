/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLSV;

import java.util.Arrays;

/**
 *
 * @author ACER
 */
public class Course {
    private String name;
    private String id;
    private String department;
    private int maxCapacity = 60;
    private Student[] studens;

    public String getName() {
        return name;
    }
    
    public void addStudent(Student s){
    }
    
    public void dropStudent(Student s){
    
    }
    
    public double getAverage(){
        return 0;
    }
    
    public String toString(){
        return "name: " + name + "\t" + "id: " + id + "\t" + "department: " + department + "\t" + "maxCapacity: " + maxCapacity + "\t" + "Students: " + Arrays.toString(studens);
    }
}
