package base_java;

public class Ex05 {
    public void displayDate(int month, int year) {
        int date = 0;
        switch(month) {
            case 2:
                if ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    date = 29;
                } else {
                    date = 28;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                date = 30;
                break;

            default :
                date = 31;
                break;
        }

        System.out.println("Ngay " + date + ", thang " + month + ", nam " + year);

    }

    public static void main(String args[]) {
        Ex05 ex05 = new Ex05();
        ex05.displayDate(2, 1600);
    }
}
