package QLCB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class guiQLCB extends JFrame {
    QLCB qlcb = new QLCB();
    //component
    private JLabel lbSoTK, lbHoten, lbGT, lbDiachi, lbLuong;
    private JTextField txtSoTK, txtHoten, txtGT, txtDiachi, txtLuong;
    private JButton btnShow, btnAdd, btnUpd, btnDel;
    private JTable table;
    private DefaultTableModel dfTable;
    
    public guiQLCB(){
    
        //setLayout
        setLayout(new BorderLayout());
        setTitle("manage qlcb");
        setSize(700, 600);
        
        //input
        JPanel panelInput = new JPanel(new GridLayout(6, 2, 10, 10));
        lbSoTK = new JLabel("So tk");
        panelInput.add(lbSoTK);
        txtSoTK = new JTextField();
        panelInput.add(txtSoTK);
        
        lbHoten = new JLabel("Ho ten");
        panelInput.add(lbHoten);
        txtHoten = new JTextField();
        panelInput.add(txtHoten);
        
        lbGT = new JLabel("GT");
        panelInput.add(lbGT);
        txtGT = new JTextField();
        panelInput.add(txtGT);
        
        lbDiachi = new JLabel("Dia chi");
        panelInput.add(lbDiachi);
        txtDiachi = new JTextField();
        panelInput.add(txtDiachi);
        
        lbLuong = new JLabel("Luong");
        panelInput.add(lbLuong);
        txtLuong = new JTextField();
        panelInput.add(txtLuong);
        
        
        //table
        String[] colName = {"Sotk", "Hoten", "GT", "Diachi", "Luong"};
        dfTable = new DefaultTableModel(colName, 0);
        table = new JTable(dfTable);
        JScrollPane scpTB = new JScrollPane(table);
        
        //btn
        JPanel panelBtn = new JPanel(new GridLayout(1,4,5,5));
        btnAdd = new JButton("add");
        btnUpd = new JButton("upd");
        btnDel = new JButton("del");
        btnShow = new JButton("show");
        panelBtn.add(btnAdd);
        panelBtn.add(btnUpd);
        panelBtn.add(btnDel);
        panelBtn.add(btnShow);
        
        add(panelInput, BorderLayout.NORTH);
        add(scpTB, BorderLayout.CENTER);
        add(panelBtn, BorderLayout.SOUTH);

        addAction();
        
        setVisible(true);
    }
    
    public void addAction(){
        //add
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SoTK = Integer.parseInt(txtSoTK.getText());
                String Hoten = txtHoten.getText();
                String GT = txtGT.getText();
                String Diachi = txtDiachi.getText();
                double Luong = Double.parseDouble(txtLuong.getText());
                if(qlcb.insertCB(SoTK, Hoten, GT, Diachi, Luong)){
                    JOptionPane.showMessageDialog(null, "add success");
                }
            }
        });
        
        btnUpd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int SoTK = Integer.parseInt(txtSoTK.getText());
                String Hoten = txtHoten.getText();
                String GT = txtGT.getText();
                String Diachi = txtDiachi.getText();
                double Luong = Double.parseDouble(txtLuong.getText());
                if(qlcb.updateCB(SoTK, Hoten, GT, Diachi, Luong)){
                    JOptionPane.showMessageDialog(null, "upd success");
                }
            }
        });
        
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SoTK = Integer.parseInt(txtSoTK.getText());
                if(qlcb.deleteCB(SoTK)){
                    JOptionPane.showMessageDialog(null, "add success");
                }
            }
        });
        
        //show
        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dfTable.setRowCount(0);
                List<Canbo> lcb = qlcb.showCB();
                if(lcb != null)
                for(Canbo cb : lcb){
                    int SoTK = cb.getSoTK();
                    String Hoten = cb.getHoten();
                    String GT = cb.getHoten();
                    String Diachi = cb.getHoten();
                    double Luong = cb.getLuong();
                    Object[] obj = {SoTK, Hoten, GT, Diachi, Luong};
                    dfTable.addRow(obj);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        new guiQLCB();
    }
}
