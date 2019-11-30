package base_java;

public class Ex15 {
    public boolean isPerfectNum(int m){
        int s = 0;
        for (int i = 1; i < m; i++) {
            if ((m % i) == 0){
                s += i;
            }
        }
        return s == m;
    }

    public static void main(String[] args) {
        Ex15 ex15 = new Ex15();
        System.out.println(ex15.isPerfectNum(496));
    }
}
