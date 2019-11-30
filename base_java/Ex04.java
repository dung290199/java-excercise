package base_java;

public class Ex04 {
    public static void main(String[] args) {
        Ex04 ex04 = new Ex04();
        System.out.println("Tong tien la: " + ex04.bill(5, 19));
    }

    public double bill(int a, int b){
        int time = b - a;
        return (time <= 18) ? (time * 45000) : (time * 60000);
    }

}
