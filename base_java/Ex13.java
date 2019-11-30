package base_java;

public class Ex13 {
    public boolean isSymmetricNumber(int m){
        int check = m, result = 0;
        do {
            result = result * 10 + check % 10;
            check /= 10;
        } while (check != 0);
        return result == m;
    }

    public static void main(String[] args) {
        Ex13 ex13 = new Ex13();
        System.out.println(ex13.isSymmetricNumber(12));
    }
}
