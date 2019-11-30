package frame_excercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex10 extends JFrame implements ActionListener {
    JLabel lb1, lb2, lb;
    JTextField txtn, txtkq;
    JButton ok, reset, exit;
    JPanel pn, pn1, pn2, pn3;

    public void GUI() {
        lb = new JLabel("KIEM TRA CO THUOC DAY FIBONACI KHONG?");
        lb1 = new JLabel("Nhap n: ");
        lb2 = new JLabel("Ket qua: ");

        txtn = new JTextField();
        txtkq = new JTextField();

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

        pn1.add(lb);

        pn2.add(lb1);
        pn2.add(txtn);
        pn2.add(lb2);
        pn2.add(txtkq);

        pn3.add(ok);
        pn3.add(exit);
        pn3.add(reset);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        add(pn);//add vao frame
        setSize(400, 300);//thiet lap kich thuoc
        show();//hien thi

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == ok) {
            if (!txtn.getText().isEmpty()){
                int n = Integer.parseInt(txtn.getText().toString());
                if (isFibonaci(n)){
                    txtkq.setText("So nay thuoc day Fibonaci!");
                } else {
                    txtkq.setText("So nay khong thuoc day Fibonaci!!");
                }
            }
        }

        if (e.getSource() == reset) {
            txtn.setText("");
            txtkq.setText("");
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

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

    public Ex10(String st) {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new Ex10("KIEM TRA CO THUOC DAY FIBONACI KHONG");
    }
}
