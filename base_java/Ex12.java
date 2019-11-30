package base_java;

public class Ex12 {

    public boolean isSquareNumber(int m){
        if (m < 0){
            return false;
        }
        double check = Math.sqrt(m) * 10;
        return ((check % 10) == 0);
    }

    public static void main(String[] args) {
        Ex12 ex12 = new Ex12();
        System.out.println(ex12.isSquareNumber(12));
    }
}
