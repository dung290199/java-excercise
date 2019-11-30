package base_java;

public class Ex18 {
    public int ucln(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public int bcnn(int a, int b) {
        return (a * b) / ucln(a,b);
    }

    public static void main(String[] args) {
        Ex18 ex18 = new Ex18();

        System.out.println("UCLN(a, b) = " + ex18.ucln(9, 43));
        System.out.println("BCNN(a, b) = " + ex18.bcnn(9, 43));

    }
}
