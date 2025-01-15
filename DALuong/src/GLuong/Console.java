/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Console {
    private static XLLuong xll = new XLLuong();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n== QUAN LY NHAN VIEN ==");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Hien thi tat ca nhan vien");
            System.out.println("3. Tim nhan vien theo ma");
            System.out.println("4. Cap nhat nhan vien");
            System.out.println("5. Xoa nhan vien");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    insertNhanVien();
                    break;
                case 2:
                    displayAllNhanVien();
                    break;
                case 3:
                    findNhanVienByMa();
                    break;
                case 4:
                    updateNhanVien();
                    break;
                case 5:
                    deleteNhanVien();
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    System.exit(0);
                default:
                    System.out.println("Chuc nang khong hop le!");
            }
        }
    }

    private static void insertNhanVien() {
        System.out.print("Nhap ma nhan vien: ");
        int maNV = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhap luong: ");
        double luong = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap gioi tinh (Nam/Nu): ");
        String gioiTinh = scanner.nextLine();

        boolean success = xll.insertNV(maNV, hoTen, diaChi, luong, gioiTinh);
        if (success) {
            System.out.println("Them nhan vien thanh cong!");
        } else {
            System.out.println("Them nhan vien that bai!");
        }
    }

    private static void displayAllNhanVien() {
        ArrayList<Nhanvien> listNV = xll.getAllNV();
        if (listNV != null && !listNV.isEmpty()) {
            System.out.println("\nDanh sach nhan vien:");
            for (Nhanvien nv : listNV) {
                System.out.println(nv);
            }
        } else {
            System.out.println("Khong co nhan vien nao.");
        }
    }

    private static void findNhanVienByMa() {
        System.out.print("Nhap ma nhan vien can tim: ");
        int maNV = Integer.parseInt(scanner.nextLine());

        ArrayList<Nhanvien> listNV = xll.getNVbyMa(maNV);
        if (listNV != null && !listNV.isEmpty()) {
            for (Nhanvien nv : listNV) {
                System.out.println(nv);
            }
        } else {
            System.out.println("Khong tim thay nhan vien voi ma so: " + maNV);
        }
    }

    private static void updateNhanVien() {
        System.out.print("Nhap ma nhan vien can cap nhat: ");
        int maNV = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap ho ten moi: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap dia chi moi: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhap luong moi: ");
        double luong = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap gioi tinh moi (Nam/Nu): ");
        String gioiTinh = scanner.nextLine();

        boolean success = xll.updateNV(maNV, hoTen, diaChi, luong, gioiTinh);
        if (success) {
            System.out.println("Cap nhat nhan vien thanh cong!");
        } else {
            System.out.println("Cap nhat nhan vien that bai!");
        }
    }

    private static void deleteNhanVien() {
        System.out.print("Nhap ma nhan vien can xoa: ");
        int maNV = Integer.parseInt(scanner.nextLine());

        boolean success = xll.deleteNV(maNV);
        if (success) {
            System.out.println("Xoa nhan vien thanh cong!");
        } else {
            System.out.println("Xoa nhan vien that bai!");
        }
    }
}
