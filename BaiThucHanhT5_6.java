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

    public void hienThiThongTin() {
        System.out.printf("Ma: %-10s | Ten: %-25s | So luong: %-5d | Gia: %,.2f\n", maSach, tenSach, soLuong, gia);
    }
}

public class BaiThucHanhT5_6 {
    static Scanner scanner = new Scanner(System.in);
    static Sach[] danhSachSach = null;
    static int n = 0;

    public static void nhapSach() {
        System.out.print("Nhap so luong sach can them (n): ");
        while (!scanner.hasNextInt()) {
            System.out.print("So luong phai la so nguyen: ");
            scanner.next();
        }
        n = scanner.nextInt();
        scanner.nextLine();

        if (n <= 0) {
            System.out.println("So luong sach phai lon hon 0!");
            n = 0;
            return;
        }

        danhSachSach = new Sach[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap thong tin sach thu " + (i + 1) + " ---");
            System.out.print("Nhap ma sach: ");
            String ma = scanner.nextLine();

            System.out.print("Nhap ten sach: ");
            String ten = scanner.nextLine();

            System.out.print("Nhap so luong: ");
            while (!scanner.hasNextInt()) {
                System.out.print("So luong phai la so nguyen: ");
                scanner.next();
            }
            int sl = scanner.nextInt();

            System.out.print("Nhap gia sach: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Gia sach phai la so: ");
                scanner.next();
            }
            double g = scanner.nextDouble();
            scanner.nextLine();

            danhSachSach[i] = new Sach(ma, ten, sl, g);
        }
        System.out.println("-> Da nhap thanh cong " + n + " quyen sach!");
    }

    public static void tinhTongSach() {
        if (danhSachSach == null || n == 0) {
            System.out.println("Chua co du lieu sach!");
            return;
        }

        int tongSoLuong = 0;
        double tongGiaTri = 0;

        for (int i = 0; i < n; i++) {
            tongSoLuong += danhSachSach[i].soLuong;
            tongGiaTri += (danhSachSach[i].soLuong * danhSachSach[i].gia);
        }

        System.out.println("\n--- KET QUA TINH TOAN (BAI 2) ---");
        System.out.println("Tong so luong sach: " + tongSoLuong);
        System.out.printf("Tong gia tri sach: %,.2f VND\n", tongGiaTri);
    }

    public static void hienThiDanhSach() {
        if (danhSachSach == null || n == 0) {
            System.out.println("Chua co du lieu sach!");
            return;
        }

        System.out.println("\n--- DANH SACH SACH ---");
        for (int i = 0; i < n; i++) {
            danhSachSach[i].hienThiThongTin();
        }
    }

    public static void timSachTheoMa() {
        if (danhSachSach == null || n == 0) {
            System.out.println("Chua co du lieu sach de tim kiem!");
            return;
        }

        System.out.print("Nhap ma sach can tim: ");
        String maTimKiem = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (danhSachSach[i].maSach.equalsIgnoreCase(maTimKiem)) {
                System.out.println("-> Da tim thay sach:");
                danhSachSach[i].hienThiThongTin();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("-> Khong tim thay sach co ma: " + maTimKiem);
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n================ MENU QUAN LY THU VIEN ================");
            System.out.println("1. Nhap n sach bang vong lap ");
            System.out.println("2. Tinh tong so luong va tong gia tri sach ");
            System.out.println("3. Hien thi danh sach sach ");
            System.out.println("4. Tim sach theo ma ");
            System.out.println("0. Thoat chuong trinh ");
            System.out.print("Chon chuc nang (0-4): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Vui long nhap so hop le (0-4): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    nhapSach();
                    break;
                case 2:
                    tinhTongSach();
                    break;
                case 3:
                    hienThiDanhSach();
                    break;
                case 4:
                    timSachTheoMa();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);

        scanner.close();
    }
}