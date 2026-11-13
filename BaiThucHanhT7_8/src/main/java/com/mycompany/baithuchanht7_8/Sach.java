/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baithuchanht7_8;

import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author PhamVanVu
 */
public class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;
    private Scanner sc = new Scanner(System.in);
    
    public Sach(){
    }

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong){
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.setNamXuatBan(namXuatBan);
        this.setSoLuong(soLuong);
    }
    
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Nam xuat ban khong hop le! Dat mac dinh la nam hien tai.");
            this.namXuatBan = currentYear;
        }
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("So luong khong duoc am! Dat mac dinh la 0.");
            this.soLuong = 0;
        }
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void Nhap(){
        System.out.println("Nhap thong tin sach: ");
        System.out.print("Nhap ma sach: ");
        this.maSach = this.sc.nextLine();
        System.out.print("Nhap tieu de: ");
        this.tieuDe = this.sc.nextLine();
        System.out.print("Nhap tac gia: ");
        this.tacGia = this.sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        int nxb = Integer.parseInt(this.sc.nextLine());
        this.setNamXuatBan(nxb);
        System.out.print("Nhap so luong: ");
        int sl = Integer.parseInt(this.sc.nextLine());
        this.setSoLuong(sl);
    }

    public void Xuat() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
        System.out.println("-----------------------------------");
    }
}