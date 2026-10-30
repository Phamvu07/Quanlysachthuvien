import java.util.Scanner;
import java.time.Year;

class Sach {
    protected String maSach;
    protected String tenSach;
    protected String tacGia;
    protected int namXuatBan;
    protected double donGia;
    protected int soLuong;
    protected int loaiSach;
    protected Scanner sc = new Scanner(System.in);

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, double donGia, int soLuong, int loaiSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.loaiSach = loaiSach;
    }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }
    public String getTenSach() { return tenSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }
    public String getTacGia() { return tacGia; }
    public void setTacGia(String tacGia) { this.tacGia = tacGia; }
    public int getNamXuatBan() { return namXuatBan; }
    public void setNamXuatBan(int namXuatBan) { this.namXuatBan = namXuatBan; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public int getLoaiSach() { return loaiSach; }
    public void setLoaiSach(int loaiSach) { this.loaiSach = loaiSach; }

    public void Nhap() {
        System.out.println("Nhap thong tin sach: ");
        System.out.print("Nhap ma sach: ");
        this.maSach = this.sc.nextLine();
        System.out.print("Nhap ten sach: ");
        this.tenSach = this.sc.nextLine();
        System.out.print("Nhap tac gia: ");
        this.tacGia = this.sc.nextLine();
        
        int currentYear = Year.now().getValue();
        do {
            System.out.print("Nhap nam xuat ban (1900 - " + currentYear + "): ");
            this.namXuatBan = Integer.parseInt(this.sc.nextLine());
            if (this.namXuatBan < 1900 || this.namXuatBan > currentYear) {
                System.out.println("Nam xuat ban khong hop le! Vui long nhap lai.");
            }
        } while (this.namXuatBan < 1900 || this.namXuatBan > currentYear);

        do {
            System.out.print("Nhap don gia (> 0): ");
            this.donGia = Double.parseDouble(this.sc.nextLine());
            if (this.donGia <= 0) {
                System.out.println("Don gia phai lon hon 0! Vui long nhap lai.");
            }
        } while (this.donGia <= 0);

        do {
            System.out.print("Nhap so luong (>= 0): ");
            this.soLuong = Integer.parseInt(this.sc.nextLine());
            if (this.soLuong < 0) {
                System.out.println("So luong phai lon hon hoac bang 0! Vui long nhap lai.");
            }
        } while (this.soLuong < 0);

        do {
            System.out.println("Chon loai sach:");
            System.out.println("1. Sach giao khoa");
            System.out.println("2. Sach tham khao");
            System.out.println("3. Sach chuyen nganh");
            System.out.println("4. Sach khac");
            System.out.print("Lua chon cua ban (1-4): ");
            this.loaiSach = Integer.parseInt(this.sc.nextLine());
            if (this.loaiSach < 1 || this.loaiSach > 4) {
                System.out.println("Lua chon khong hop le! Vui long chon lai tu 1 den 4.");
            }
        } while (this.loaiSach < 1 || this.loaiSach > 4);
    }

    public double tinhThanhTien() {
        return this.donGia * this.soLuong;
    }

    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }

    public double tinhTongTienNhap() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }

    public String phanLoaiGia() {
        if (this.donGia < 50000) {
            return "Sach gia thap";
        } else if (this.donGia <= 100000) {
            return "Sach gia trung binh";
        } else if (this.donGia <= 200000) {
            return "Sach gia cao";
        } else {
            return "Sach gia dac biet";
        }
    }

    public String phanLoaiTonKho() {
        if (this.soLuong == 0) {
            return "Het sach";
        } else if (this.soLuong >= 1 && this.soLuong <= 5) {
            return "Sap het";
        } else if (this.soLuong >= 6 && this.soLuong <= 20) {
            return "Con it";
        } else {
            return "Con nhieu";
        }
    }

    public String getTenLoaiSach() {
        switch (this.loaiSach) {
            case 1:
                return "Sach giao khoa";
            case 2:
                return "Sach tham khao";
            case 3:
                return "Sach chuyen nganh";
            case 4:
                return "Sach khac";
            default:
                return "Khong xac dinh";
        }
    }

    public void Xuat() {
        System.out.println("Ma sach        : " + this.maSach);
        System.out.println("Ten sach       : " + this.tenSach);
        System.out.println("Tac gia        : " + this.tacGia);
        System.out.println("Nam xuat ban   : " + this.namXuatBan);
        System.out.println("Don gia        : " + this.donGia);
        System.out.println("So luong       : " + this.soLuong);
        System.out.println("Loai sach      : " + getTenLoaiSach());
        System.out.println("Phan loai gia  : " + phanLoaiGia());
        System.out.println("Phan loai kho  : " + phanLoaiTonKho());
        System.out.println("Thanh tien     : " + tinhThanhTien());
        System.out.println("Phi van chuyen : " + tinhPhiVanChuyen());
        System.out.println("Tong tien nhap : " + tinhTongTienNhap());
    }
}

public class Main {
    public static void main(String[] args) {
        Sach sach = new Sach();
        sach.Nhap();
        System.out.println("\n--- THONG TIN KET QUA KHO SACH ---");
        sach.Xuat();
    }
}