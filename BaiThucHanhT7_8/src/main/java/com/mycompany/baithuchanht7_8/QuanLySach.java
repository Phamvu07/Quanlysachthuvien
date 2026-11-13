/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baithuchanht7_8;

import java.util.ArrayList;

/**
 *
 * @author PhamVanVu
 */
public class QuanLySach {
    private ArrayList<Sach> danhSach;

    public QuanLySach() {
        this.danhSach = new ArrayList<>();
    }

    public void themSach(Sach s) {
        danhSach.add(s);
    }

    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Thu vien hien chua co cuon sach nao.");
        } else {
            System.out.println("\n=== DANH SACH CAC CUON SACH TRONG THU VIEN ===");
            for (Sach s : danhSach) {
                s.Xuat();
            }
        }
    }
}
