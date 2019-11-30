package base_java;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap a: ");
        int a = scanner.nextInt();
        System.out.print("\nNhap b: ");
        int b = scanner.nextInt();
        System.out.print("\nNhap c: ");
        int c = scanner.nextInt();

        int max = (a > b && a > c) ? a : (b > c ? b : c);
        int min = (a < b && a < c) ? a : (b < c ? b : c);
        int mid = (a + b + c) - max - min;

        System.out.println("So trung gian: " + mid);
    }
}
