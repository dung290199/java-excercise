package base_java;

public class Ex11 {
    public boolean isPrimeNumber(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if ((n % i) == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Ex11 ex11 = new Ex11();
        System.out.println(ex11.isPrimeNumber(4));
    }
}
