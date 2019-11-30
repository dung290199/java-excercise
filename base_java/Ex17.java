package base_java;

public class Ex17 {
    public boolean isFibonaci(int n){
        if (n == 1){
            return true;
        }

        int[] result = new int[n + 1];
        result[0] = 1; result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
            if (result[i] == n){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Ex17 ex17 = new Ex17();
        System.out.println(ex17.isFibonaci(13));
    }
}
