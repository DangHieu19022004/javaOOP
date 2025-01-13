/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CKH;

import java.util.List;


public class Test_KH {
    public static void doInsertKH(){
        XLKH xlkh = new XLKH();
        if(xlkh.insertKH(0, "hoten", "gt", "diachi", 0)){
            System.out.println("success add");
        }else{
            System.out.println("err add");
        }
    }
    
    public static void main(String[] args) {
        doInsertKH();
        XLKH xlkh = new XLKH();
        List<Khachhang> lkh = xlkh.showKH();
        for(Khachhang kh : lkh){
            System.out.println(kh.toString());
        }
    }
}
