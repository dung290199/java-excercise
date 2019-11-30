package frame_excercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex7 extends JFrame implements ActionListener {
    JLabel lb1, lb2, lb3, lb;
    JTextField txta, txtb, txtkq;
    JButton kq, reset, thoat;
    JPanel pn, pn1, pn2, pn3;

    public void GUI() {
        lb = new JLabel(" GIAI PHUONG TRINH BAC NHAT ");
        lb1 = new JLabel("Nhap a: ");
        lb2 = new JLabel("Nhap b: ");
        lb3 = new JLabel("Ket qua: ");

        txta = new JTextField();
        txtb = new JTextField();
        txtkq = new JTextField();

        kq = new JButton("Tinh");
        reset = new JButton("Reset");
        thoat = new JButton("Thoat");

        kq.addActionListener(this);
        reset.addActionListener(this);
        thoat.addActionListener(this);

        pn = new JPanel(new GridLayout(3, 1));
        pn1 = new JPanel(new FlowLayout());
        pn2 = new JPanel(new GridLayout(3, 2));
        pn3 = new JPanel(new GridLayout(1, 3));

        pn1.add(lb);

        pn2.add(lb1);
        pn2.add(txta);
        pn2.add(lb2);
        pn2.add(txtb);
        pn2.add(lb3);
        pn2.add(txtkq);

        pn3.add(kq);
        pn3.add(reset);
        pn3.add(thoat);

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
        if (e.getSource() == kq) {
            int a = Integer.parseInt(txta.getText());
            int b = Integer.parseInt(txtb.getText());
            if (a != 0) {
                txtkq.setText(Float.toString((float) -b / a));
            }else {
                if (b == 0) {
                    txtkq.setText("Phuong trinh vo so nghiem.");
                }else {
                    txtkq.setText("Phuong trinh vo nghiem");
                }
            }
        }

        if (e.getSource() == reset) {
            txta.setText("");
            txtb.setText("");
            txtkq.setText("");
        }

        if (e.getSource() == thoat) {
            System.exit(0);
        }
    }

    public Ex7(String st) {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new Ex7("Giai phuong trinh bac 1");
    }
}
