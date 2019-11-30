package base_java;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap a: ");
        int a = scanner.nextInt();
        System.out.print("\nNhap b: ");
        int b = scanner.nextInt();

        if (a == 0){
            System.out.println("Phuong trinh vo nghiem!");
        } else{
            System.out.println("Phuong trinh co 1 nghiem x = " + -b/a);
        }
    }
}
