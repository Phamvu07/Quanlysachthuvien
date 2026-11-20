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
public class SachThamKhao extends Sach {
    private double thue;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);

        System.out.print("Nhap thue: ");
        thue = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhThanhTien() {
        return soLuong * donGia + thue;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-15.2f %-15.2f\n",
                thue, tinhThanhTien());
    }
}
