package ioStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadString {
    public String nhapChuoi() throws IOException {
        InputStreamReader luongvao = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(luongvao);

        return br.readLine();
    }

    public String chuoiDao(String st) {
        String st1 = "";
        for (int i = (st.length() - 1); i >= 0; i--) {
            char c = st.charAt(i);
            st1 += c;
        }

        return st1;
    }

    public String chuoiHoa(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c -= 32;
            }
            result += c;
        }
        return result;
    }

    public String chuoiThuong(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            result += c;
        }
        return result;
    }

    public String chuoiVuaHoaVuaThuong(String string){
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            } else {
                c -= 32;
            }
            result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        ReadString readString = new ReadString();
        try {
            System.out.print("Nhap chuoi: ");
            String string = readString.nhapChuoi();

            System.out.println("Chuoi dao: " + readString.chuoiDao(string));
            System.out.println("Chuoi hoa: " + readString.chuoiHoa(string));
            System.out.println("Chuoi thuong: " + readString.chuoiThuong(string));
            System.out.println("Chuoi vua hoa vua thuong: " + readString.chuoiVuaHoaVuaThuong(string));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
