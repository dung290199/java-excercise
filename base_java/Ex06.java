package base_java;

public class Ex06 {
    public double sum(double n){
        double s = 0.0;
        for (double i = 1.0; i <= n; i++) {
            s = s + 1/i;
        }
        return s;
    }

    public static void main(String[] args) {
        Ex06 ex06 = new Ex06();
        System.out.println("Tong la " + ex06.sum(3.0) + ", " + (float)(1+1/2));
    }
}
