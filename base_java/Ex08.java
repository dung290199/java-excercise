package base_java;

public class Ex08 {
    public double factorial(int n){
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double sum(int n){
        double s = 0;
        for (int i =1; i <= n; i++){
            s += 1 / factorial(2 * i - 1);
        }
        return s;
    }

    public static void main(String[] args) {
        Ex08 ex08 = new Ex08();
        System.out.println("Ket qua: " + ex08.sum(2));
    }
}
