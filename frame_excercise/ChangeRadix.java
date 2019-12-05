package frame_excercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeRadix extends JFrame implements ActionListener {
    JLabel lb1, lb2, lb3, lb4, lb5;
    JTextField txt1, txt2, txt3, txt4;
    JButton ok, reset, exit;
    JPanel pn, pn1, pn2, pn3;

    public void GUI(){
        lb1 = new JLabel("Đổi cơ số");
        lb2 = new JLabel("Nhập n: ");
        lb3 = new JLabel("Nhị phân: ");
        lb4 = new JLabel("Bát phân: ");
        lb5 = new JLabel("Thập lục phân: ");

        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        txt4 = new JTextField();

        ok = new JButton("OK");
        reset = new JButton("Reset");
        exit = new JButton("Exit");

        ok.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);

        pn = new JPanel(new GridLayout(3, 1));
        pn1 = new JPanel(new FlowLayout());
        pn2 = new JPanel(new GridLayout(2, 2));
        pn3 = new JPanel(new FlowLayout());

        pn1.add(lb1);

        pn2.add(lb2);
        pn2.add(txt1);
        pn2.add(lb3);
        pn2.add(txt2);
        pn2.add(lb4);
        pn2.add(txt3);
        pn2.add(lb5);
        pn2.add(txt4);

        pn3.add(ok);
        pn3.add(reset);
        pn3.add(exit);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);

        add(pn);
        setSize(600, 200);
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset){
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");
        }

        if (e.getSource() == exit){
            System.exit(0);
        }

        if (e.getSource() == ok){
            int n = (!txt1.getText().isEmpty()) ? Integer.parseInt(txt1.getText()) : 0;
            txt2.setText(getBinary(n));
            txt3.setText(getOctalNumber(n));
            txt4.setText(getHexNumber(n));
        }
    }

    private String getHexNumber(int n) {
        String s = "";
        String result = "";
        do {
            int tmp = (n % 16);
            if (tmp > 9){
                switch (tmp){
                    case 10:
                        result += 'A';
                        break;
                    case 11:
                        result += 'B';
                        break;
                    case 12:
                        result += 'C';
                        break;
                    case 13:
                        result += 'D';
                        break;
                    case 14:
                        result += 'E';
                        break;
                    case 15:
                        result += 'F';
                        break;
                }
            }else {
                s += tmp;
            }
            n /= 16;
        } while (n != 0);

        for (int i = (s.length() - 1); i >= 0 ; i--) {
            result += s.charAt(i);
            if ((i % 4) == 0){
                result += " ";
            }
        }
        return result;
    }

    private String getOctalNumber(int n) {
        String s = "";
        String result = "";
        do {
            s += (n % 8);
            n /= 8;
        } while (n != 0);

        for (int i = (s.length() - 1); i >= 0 ; i--) {
            result += s.charAt(i);
            if ((i % 4) == 0){
                result += " ";
            }
        }
        return result;
    }

    private String getBinary(int n) {
        String s = "";
        String result = "";
        do {
            s += (n % 2);
            n /= 2;
        } while (n != 0);

        for (int i = (s.length() - 1); i >= 0 ; i--) {
            result += s.charAt(i);
            if ((i % 4) == 0){
                result += " ";
            }
        }


        return result;
    }

    public ChangeRadix(String string){
        super(string);
        GUI();
    }

    public static void main(String[] args) {
        ChangeRadix changeRadix = new ChangeRadix("Doi co so");

    }
}
