package frame_excercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex12 extends JFrame implements ActionListener {
    JButton red, green, blue, exit;
    JPanel pn;

    @SuppressWarnings("deprecation")
    public void GUI() {
        red = new JButton("Red");
        green = new JButton("Green");
        blue = new JButton("Blue");
        exit = new JButton("Exit");

        pn = new JPanel(new FlowLayout());

        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        exit.addActionListener(this);

        pn.add(red);
        pn.add(green);
        pn.add(blue);
        pn.add(exit);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        add(pn);
        setSize(400, 300);
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource() == red) {
            pn.setBackground(Color.red);
            add(pn);
        }

        if(e.getSource() == green) {
            pn.setBackground(Color.green);
            add(pn);
        }

        if(e.getSource() == blue) {
            pn.setBackground(Color.blue);
            add(pn);
        }

        if(e.getSource() == exit) {
            System.exit(0);
        }

    }

    public Ex12(String st) {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new Ex12("Doi Mau Nen");
    }

}
