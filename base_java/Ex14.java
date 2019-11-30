package base_java;

public class Ex14 {
    public boolean isPrimeNumber(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if ((n % i) == 0){
                return false;
            }
        }
        return true;
    }

    public void display(int n){
        for (int i = 1; i <= n; i++) {
            if (isPrimeNumber(i)){
                System.out.print("\t" + i);
            }
        }
    }

    public static void main(String[] args) {
        Ex14 ex14 = new Ex14();
        ex14.display(10);
    }
}
