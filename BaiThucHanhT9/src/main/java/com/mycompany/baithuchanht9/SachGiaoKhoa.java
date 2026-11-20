/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baithuchanht9;

import java.util.Scanner;

/**
 *
 * @author PhamVanVu
 */
public class SachGiaoKhoa extends Sach {
    private String tinhTrang;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);

        do {
            System.out.print("Nhap tinh trang (moi/cu): ");
            tinhTrang = sc.nextLine();

            if (!tinhTrang.equalsIgnoreCase("moi")
                    && !tinhTrang.equalsIgnoreCase("cu")) {
                System.out.println("Chi nhap moi hoac cu!");
            }
        } while (!tinhTrang.equalsIgnoreCase("moi")
                && !tinhTrang.equalsIgnoreCase("cu"));
    }

    @Override
    public double tinhThanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 0.5;
        }
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-15s %-15.2f\n",
                tinhTrang, tinhThanhTien());
    }
}
