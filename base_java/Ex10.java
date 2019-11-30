package base_java;

public class Ex10 {
    public String plusAndMulOfDigit(int m){
        if (m < 0){
            return "Ban phai nhap so nguyen duong!";
        }
        int s = 0, p = 1;
        do {
            s += m % 10;
            p *= m % 10;
            m /= 10;
        } while (m != 0);
        return "s = " + s + ", p = " + p;
    }

    public static void main(String[] args) {
        Ex10 ex10 = new Ex10();
        System.out.println("Ket qua: " + ex10.plusAndMulOfDigit(10));
    }
}
