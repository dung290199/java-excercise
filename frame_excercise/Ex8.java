package frame_excercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex8 extends JFrame implements ActionListener {
    JLabel lb1, lb2, lb3, lb;
    JTextField txta, txtb, txtkq;
    JButton add, sub, mul, div, reset, exit;
    JPanel pn, pn1, pn2, pn3, pn4;

    public void GUI() {
        lb = new JLabel(" MINH HOA CAC PHEP TOAN ");
        lb1 = new JLabel("Nhap a: ");
        lb2 = new JLabel("Nhap b: ");
        lb3 = new JLabel("Ket qua: ");

        txta = new JTextField();
        txtb = new JTextField();
        txtkq = new JTextField();

        add = new JButton("ADD");
        sub = new JButton("SUB");
        mul = new JButton("MUL");
        div = new JButton("DIV");

        reset = new JButton("Reset");
        exit = new JButton("Exit");

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);

        pn = new JPanel(new GridLayout(3, 1));
        pn1 = new JPanel(new FlowLayout());
        pn2 = new JPanel(new GridLayout(3, 2));
        pn3 = new JPanel(new FlowLayout());
        pn4 = new JPanel(new FlowLayout());

        pn1.add(lb);

        pn2.add(lb1);
        pn2.add(txta);
        pn2.add(lb2);
        pn2.add(txtb);
        pn2.add(lb3);
        pn2.add(txtkq);

        pn3.add(add);
        pn3.add(sub);
        pn3.add(mul);
        pn3.add(div);

        pn4.add(exit);
        pn4.add(reset);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);
        pn.add(pn4);

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
        int a = 0,b = 0;

        if (!txta.getText().isEmpty() && !txtb.getText().isEmpty()){
            a = Integer.parseInt(txta.getText());
            b = Integer.parseInt(txtb.getText());
        }

        if (e.getSource() == add) {
            txtkq.setText(Integer.toString(a + b));
        }

        if (e.getSource() == sub){
            txtkq.setText(Integer.toString(a - b));
        }

        if (e.getSource() == mul){
            txtkq.setText(Float.toString((float) a * b));
        }

        if (e.getSource() == div){
            txtkq.setText(Double.toString((double) a / b));
        }

        if (e.getSource() == reset) {
            txta.setText("");
            txtb.setText("");
            txtkq.setText("");
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public Ex8(String st) {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new Ex8("Thuc hien cac phep toan");
    }
}
