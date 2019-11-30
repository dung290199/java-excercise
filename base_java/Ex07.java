package base_java;

public class Ex07 {
    public double factorial(int n){
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double sum(int n){
        double s = 15;
        for (int i =1; i <= n; i++){
            s += Math.pow(-1, i) * (1 / factorial(i));
        }
        return s;
    }

    public static void main(String[] args) {
        Ex07 ex07 = new Ex07();
        System.out.println("Ket qua: " + ex07.sum(2));
    }
}
