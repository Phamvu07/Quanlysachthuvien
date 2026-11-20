/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.baithuchanht9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PhamVanVu
 */
public class BaiThucHanhT9 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Sach> ds = new ArrayList<>();

    public static void nhapDanhSach() {
        System.out.print("Nhap so luong sach: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Sach thu " + (i + 1) + " ---");
            System.out.println("1. Sach giao khoa");
            System.out.println("2. Sach tham khao");
            System.out.print("Chon loai sach: ");

            int chon = Integer.parseInt(sc.nextLine());

            Sach s;

            if (chon == 1) {
                s = new SachGiaoKhoa();
            } else if (chon == 2) {
                s = new SachThamKhao();
            } else {
                System.out.println("Loai sach khong hop le!");
                i--;
                continue;
            }

            s.nhap(sc);
            ds.add(s);
        }
    }

    public static void xuatDanhSach() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach sach rong!");
            return;
        }

        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa) {
                System.out.println("\n--- SACH GIAO KHOA ---");
                System.out.printf("%-12s %-15s %-12s %-10s %-20s %-15s %-15s\n",
                        "Ma sach", "Ngay nhap", "Don gia",
                        "So luong", "Nha xuat ban",
                        "Tinh trang", "Thanh tien");
            } else {
                System.out.println("\n--- SACH THAM KHAO ---");
                System.out.printf("%-12s %-15s %-12s %-10s %-20s %-15s %-15s\n",
                        "Ma sach", "Ngay nhap", "Don gia",
                        "So luong", "Nha xuat ban",
                        "Thue", "Thanh tien");
            }

            s.xuat();
        }
    }

    public static void tinhTongThanhTien() {
        double tongSGK = 0;
        double tongSTK = 0;

        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa) {
                tongSGK += s.tinhThanhTien();
            } else if (s instanceof SachThamKhao) {
                tongSTK += s.tinhThanhTien();
            }
        }

        System.out.println("Tong tien sach giao khoa: " + tongSGK);
        System.out.println("Tong tien sach tham khao: " + tongSTK);
    }

    public static void tinhTrungBinhDonGia() {
        double tong = 0;
        int dem = 0;

        for (Sach s : ds) {
            if (s instanceof SachThamKhao) {
                tong += s.donGia;
                dem++;
            }
        }

        if (dem == 0) {
            System.out.println("Khong co sach tham khao!");
        } else {
            System.out.println("Trung binh cong don gia sach tham khao: "
                    + (tong / dem));
        }
    }

    public static void xuatSachNhaXuatBanX() {
        System.out.print("Nhap ten nha xuat ban: ");
        String tenNXB = sc.nextLine();

        boolean timThay = false;

        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa
                    && s.nhaXuatBan.equalsIgnoreCase(tenNXB)) {
                s.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach!");
        }
    }
     public static void main(String[] args) {
        int chon;

        do {
            System.out.println("\n========== QUAN LY SACH ==========");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Xuat danh sach sach");
            System.out.println("3. Tinh tong thanh tien tung loai");
            System.out.println("4. Tinh trung binh don gia sach tham khao");
            System.out.println("5. Xuat sach giao khoa cua NXB X");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    nhapDanhSach();
                    break;

                case 2:
                    xuatDanhSach();
                    break;

                case 3:
                    tinhTongThanhTien();
                    break;

                case 4:
                    tinhTrungBinhDonGia();
                    break;

                case 5:
                    xuatSachNhaXuatBanX();
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }
}
