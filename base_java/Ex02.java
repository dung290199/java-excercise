package base_java;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String isContinue;
        do {
            System.out.print("Nhap a: ");
            int a = scanner.nextInt();
            System.out.print("\nNhap b: ");
            int b = scanner.nextInt();
            System.out.print("\nNhap c: ");
            int c = scanner.nextInt();

            double delta = Math.pow(b, 2) - 4 * a * c;

            if (delta < 0){
                System.out.println("Phuowng trinh vo nghiem!");
            } else if (delta == 0){
                System.out.println("Phuong trinh co nghiem x = " + -b/(2*a));
            } else{
                double x1 = (-b + Math.sqrt(delta)) / 2*a;
                double x2 = (-b - Math.sqrt(delta)) / 2*a;
                System.out.println("Phuong trinh co 2 nghiem x1 = " + x1 + ", x2 = " + x2);
            }

            System.out.println("Ban co muon tiep tuc khong?(y/n)");
            isContinue = scanner.next();
        } while (isContinue.equals("y") || isContinue.equals("Y"));
    }
}
