/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLSV;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class guiQLSV extends JFrame {
    private DatabaseManager databaseManager = new DatabaseManager();
    private JTable table;
    private DefaultTableModel dftbmd;
    private JLabel lbten, lbmaso, lbnganhhoc;
    private JTextField txtten, txtmaso, txtnganhhoc;
    private JButton btnAdd, btnReset, btnFilter;
    
    public guiQLSV(){
        
        setLayout(new BorderLayout());
        setTitle("Quản lý sinh viên");
        setSize(700, 600);
        
        
        JPanel inputpanel = new JPanel(new GridLayout(4, 2, 10, 10));
        lbten = new JLabel("Tên");
        inputpanel.add(lbten);
        txtten = new JTextField();
        inputpanel.add(txtten);        
        
        lbmaso = new JLabel("Mã số");
        inputpanel.add(lbmaso);
        txtmaso = new JTextField();
        inputpanel.add(txtmaso);
       
        lbnganhhoc = new JLabel("Ngành học");
        inputpanel.add(lbnganhhoc);
        txtnganhhoc = new JTextField();
        inputpanel.add(txtnganhhoc);      
        
        
        Object[] colName = {"Tên", "Mã số", "Ngành học"};
        dftbmd = new DefaultTableModel(colName, 0);
        table = new JTable(dftbmd);
        JScrollPane scrp = new JScrollPane(table);
        
        
        JPanel btnpanel = new JPanel(new GridLayout(1, 2, 10, 10));
        btnAdd = new JButton("Thêm sinh viên");
        btnReset = new JButton("Làm mới dữ liệu");
        btnFilter = new JButton("Xóa sv có major trong input");
        btnpanel.add(btnAdd);
        btnpanel.add(btnReset);
        btnpanel.add(btnFilter);
        
        
        add(inputpanel, BorderLayout.NORTH);
        add(scrp, BorderLayout.CENTER);
        add(btnpanel, BorderLayout.SOUTH);
                
        
        controlAction();
        
        setVisible(true);
    }
    
    public void controlAction(){
        dftbmd.setRowCount(0);
            ArrayList<Student> liststu1 = databaseManager.getStu();
            for(Student st : liststu1){
                Object[] rowData = {
                    st.getName(),
                    st.getID(),
                    st.getMajor()
                };
                dftbmd.addRow(rowData);
            }
            
            
        btnReset.addActionListener(e -> {
            dftbmd.setRowCount(0);
            ArrayList<Student> liststu = databaseManager.getStu();
            for(Student st : liststu){
                Object[] rowData = {
                    st.getName(),
                    st.getID(),
                    st.getMajor()
                };
                dftbmd.addRow(rowData);
            }
        }); 
        
        btnAdd.addActionListener(e -> {
            String ten = txtten.getText();
            String id = txtmaso.getText();
            String major = txtnganhhoc.getText();
            if(databaseManager.insertSV(ten, id, major)){
                JOptionPane.showMessageDialog(null, "add success, press reset to renew data");
            }else{
                JOptionPane.showMessageDialog(null, "add failed");
            }
        });
        
        btnFilter.addActionListener(e -> {
            String major = txtnganhhoc.getText();
            QLSV qlsv = new QLSV();
            ArrayList<Student> liststuAfter = qlsv.removeStudentsByMajor(liststu1, major);
            dftbmd.setRowCount(0);
            for(Student st : liststuAfter){
                Object[] rowData = {
                    st.getName(),
                    st.getID(),
                    st.getMajor()
                };
                dftbmd.addRow(rowData);
            }
            
        });
    }
    
    public static void main(String[] args) {
        new guiQLSV();
    }
}
