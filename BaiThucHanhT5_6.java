
import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    String maSach;
    String tenSach;
    int soLuong;
    double gia;

    public Sach(String maSach, String tenSach, int soLuong, double gia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public void hienThi() {
        System.out.printf("%-10s %-25s %-10d %,.2f\n",
                maSach, tenSach, soLuong, gia);
    }
}

public class BaiThucHanhT5_6 {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Sach> danhSachSach = new ArrayList<>();

    public static void bai1() {
        int[] soLuong = new int[5];
        int tong = 0;
        int max;

        System.out.println("\n--- BAI 1: MANG SO LUONG ---");

        for (int i = 0; i < 5; i++) {
            System.out.print("Nhap so luong sach thu " + (i + 1) + ": ");
            soLuong[i] = sc.nextInt();
        }

        max = soLuong[0];

        System.out.println("\nSo luong 5 cuon sach:");

        for (int i = 0; i < 5; i++) {
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);

            tong += soLuong[i];

            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }

        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + max);
    }

    public static void bai2() {
        ArrayList<String> maSach = new ArrayList<>();
        int chon;

        do {
            System.out.println("\n--- BAI 2: QUAN LY MA SACH ---");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    String ma = sc.nextLine();
                    maSach.add(ma);
                    System.out.println("Them thanh cong!");
                    break;

                case 2:
                    System.out.println("Danh sach ma sach:");
                    for (int i = 0; i < maSach.size(); i++) {
                        System.out.println((i + 1) + ". " + maSach.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    ma = sc.nextLine();

                    if (maSach.contains(ma)) {
                        System.out.println("Tim thay ma sach!");
                    } else {
                        System.out.println("Khong tim thay!");
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma sach can xoa: ");
                    ma = sc.nextLine();

                    if (maSach.remove(ma)) {
                        System.out.println("Xoa thanh cong!");
                    } else {
                        System.out.println("Khong tim thay ma sach!");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }

    public static int timSach(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).maSach.equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    public static void themSach() {
        System.out.println("\n--- THEM SACH ---");

        System.out.print("Nhap ma sach: ");
        String ma = sc.nextLine();

        if (timSach(ma) != -1) {
            System.out.println("Ma sach da ton tai!");
            return;
        }

        System.out.print("Nhap ten sach: ");
        String ten = sc.nextLine();

        System.out.print("Nhap so luong: ");
        int sl = sc.nextInt();

        System.out.print("Nhap gia sach: ");
        double gia = sc.nextDouble();
        sc.nextLine();

        Sach s = new Sach(ma, ten, sl, gia);
        danhSachSach.add(s);

        System.out.println("Them sach thanh cong!");
    }

    public static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach rong!");
            return;
        }

        System.out.println("\n--- DANH SACH SACH ---");
        System.out.printf("%-10s %-25s %-10s %s\n",
                "Ma sach", "Ten sach", "So luong", "Gia");

        for (Sach s : danhSachSach) {
            s.hienThi();
        }
    }

    public static void timSachMenu() {
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine();

        int vt = timSach(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay sach!");
        } else {
            System.out.println("Thong tin sach:");
            danhSachSach.get(vt).hienThi();
        }
    }

    public static void xoaSach() {
        System.out.print("Nhap ma sach can xoa: ");
        String ma = sc.nextLine();

        int vt = timSach(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay sach!");
        } else {
            danhSachSach.remove(vt);
            System.out.println("Xoa sach thanh cong!");
        }
    }

    public static void suaSach() {
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine();

        int vt = timSach(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay sach!");
            return;
        }

        Sach s = danhSachSach.get(vt);

        System.out.print("Nhap ten sach moi: ");
        s.tenSach = sc.nextLine();

        System.out.print("Nhap so luong moi: ");
        s.soLuong = sc.nextInt();

        System.out.print("Nhap gia moi: ");
        s.gia = sc.nextDouble();
        sc.nextLine();

        System.out.println("Sua sach thanh cong!");
    }

    public static void tinhTongSoLuong() {
        int tong = 0;

        for (Sach s : danhSachSach) {
            tong += s.soLuong;
        }

        System.out.println("Tong so luong sach: " + tong);
    }

    public static void tinhTongGiaTri() {
        double tong = 0;

        for (Sach s : danhSachSach) {
            tong += s.soLuong * s.gia;
        }

        System.out.printf("Tong gia tri sach: %,.2f VND\n", tong);
    }

    public static void bai4() {
        int chon;

        do {
            System.out.println("\n===== MENU QUAN LY THU VIEN =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    themSach();
                    break;

                case 2:
                    hienThiSach();
                    break;

                case 3:
                    timSachMenu();
                    break;

                case 4:
                    xoaSach();
                    break;

                case 5:
                    suaSach();
                    break;

                case 6:
                    tinhTongSoLuong();
                    break;

                case 7:
                    tinhTongGiaTri();
                    break;

                case 8:
                    System.out.println("Thoat menu!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 8);
    }

    public static void main(String[] args) {
        int chon;

        do {
            System.out.println("\n===== BAI THUC HANH TUAN 6 =====");
            System.out.println("1. Bai 1 - Mang");
            System.out.println("2. Bai 2 - ArrayList String");
            System.out.println("3. Bai 3 va Bai 4 - Quan ly sach");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    bai1();
                    break;

                case 2:
                    bai2();
                    break;

                case 3:
                    bai4();
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();
    }
}