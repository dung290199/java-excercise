package base_java;

public class Ex16 {
    public int[] fibonaci(int n){
        int[] result = new int[n];
        result[0] = 1; result[1] = 1;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

    public static void main(String[] args) {
        Ex16 ex16 = new Ex16();
        int[] result = ex16.fibonaci(8);
        for (int i = 0; i < result.length; i++) {
            System.out.print("\t" + result[i]);
        }
    }
}
