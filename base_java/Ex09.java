package base_java;

public class Ex09 {
    /*
    * Tính n!! = 1*3*5*…..*n(n lẽ)
   = 2*4*6*….*n(n chẵn)
    * */
    public float doubleFactorial(int n){
        float result = 1;
        int i = ((n % 2) == 0) ? 2 : 1;
        for (; i <= n; i += 2) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Ex09 ex09 = new Ex09();
        System.out.println("Ket qua: " + ex09.doubleFactorial(3));
    }

}
