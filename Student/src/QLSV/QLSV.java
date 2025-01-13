/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLSV;

import java.util.ArrayList;

public class QLSV {
    public ArrayList<Student> removeStudentsByMajor(ArrayList<Student> students, String major){
        for(Student st : students){
            if(st.getMajor() == major){
                students.remove(st);
            }
        }
        return students;
    }
}
