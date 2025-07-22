package automation.testsuite;

import org.testng.annotations.Test;
import java.util.Scanner;

public class BTVN_Day7 {

    @Test
    public void NhanVien() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng nhân viên: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        String[] danhSachNhanVien = new String[soLuong];


        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhập tên nhân viên thứ " + (i + 1) + ": ");
            danhSachNhanVien[i] = scanner.nextLine();
        }


        System.out.println("Danh sách nhân viên:");
        for (String ten : danhSachNhanVien) {
            System.out.println(ten);
        }

        scanner.close();
    }
}
