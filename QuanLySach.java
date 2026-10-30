import java.util.Scanner;

class Sach {
    protected String maSach;
    protected String tenSach;
    protected String tacGia;
    protected int namXuatBan;
    protected double donGia;
    protected int soLuong;
    protected Scanner sc = new Scanner(System.in);

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, double donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void Nhap() {
        System.out.println("Nhap thong tin sach: ");
        System.out.print("Nhap ma sach: ");
        this.maSach = this.sc.nextLine();
        System.out.print("Nhap ten sach: ");
        this.tenSach = this.sc.nextLine();
        System.out.print("Nhap tac gia: ");
        this.tacGia = this.sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        this.namXuatBan = Integer.parseInt(this.sc.nextLine());
        System.out.print("Nhap don gia: ");
        this.donGia = Double.parseDouble(this.sc.nextLine());
        System.out.print("Nhap so luong: ");
        this.soLuong = Integer.parseInt(this.sc.nextLine());
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

    public void Xuat() {
        System.out.println("Ma sach        : " + this.maSach);
        System.out.println("Ten sach       : " + this.tenSach);
        System.out.println("Tac gia        : " + this.tacGia);
        System.out.println("Nam xuat ban   : " + this.namXuatBan);
        System.out.println("Don gia        : " + this.donGia);
        System.out.println("So luong       : " + this.soLuong);
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