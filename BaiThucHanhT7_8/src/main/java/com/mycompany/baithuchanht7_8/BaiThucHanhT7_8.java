/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.baithuchanht7_8;

import java.util.Scanner;

/**
 *
 * @author PhamVanVu
 */
public class BaiThucHanhT7_8{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLySach ql = new QuanLySach();
        int chon;

        do {
            System.out.println("\n--- CHUONG TRINH QUAN LY SACH ---");
            System.out.println("1. Them mot cuon sach moi");
            System.out.println("2. Hien thi danh sach tat ca cac cuon sach");
            System.out.println("3. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");
            chon = Integer.parseInt(scanner.nextLine());

            switch (chon) {
                case 1:
                    Sach s = new Sach();
                    s.Nhap();
                    ql.themSach(s);
                    System.out.println("=> Them sach thanh cong!");
                    break;
                case 2:
                    ql.hienThiDanhSach();
                    break;
                case 3:
                    System.out.println("Cam on bạn da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon tu 1 den 3.");
            }
        } while (chon != 3);

        scanner.close();
    }   
}
