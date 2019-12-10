package frame_excercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionEventTest extends JFrame implements ItemListener, ActionListener, KeyListener {
    JLabel lb1, lb2;
    JButton ok;
    JTextField text;
    Choice choice;
    JPanel pn, pn1, pn2, pn3;

    public void GUI() {
        lb1 = new JLabel("Action Event");
        lb2 = new JLabel("This event is displayed here!");

        ok = new JButton("OK");
        text = new JTextField("Text");
        text.setColumns(15);

        choice = new Choice();
        choice.add("Tiger");
        choice.add("Lion");
        choice.add("Fox");

        pn = new JPanel(new GridLayout(3, 1));
        pn1 = new JPanel(new FlowLayout());
        pn2 = new JPanel(new FlowLayout());
        pn3 = new JPanel(new FlowLayout());

        ok.addActionListener(this);
        text.addKeyListener(this);
        choice.addItemListener(this);

        pn1.add(lb1);
        pn2.add(ok);
        pn2.add(text);
        pn2.add(choice);
        pn3.add(lb2);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);

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
        if (e.getSource() == ok) {
            lb2.setText("You doubled click on OK!");
        }

        if (e.getSource() == text) {
            String st = e.getActionCommand();
            if (st.contains("\n")) {
                lb2.setText("You clicked on text");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == choice){
            lb2.setText("You clicked on " + e.getItem().toString());
        } else {
            lb2.setText("You clicked on " + e.getItem().toString());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 13){
            lb2.setText(e.paramString());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 13){
        }
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            lb2.setText(text.getText());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 13){
            lb2.setText(e.paramString());
        }
    }

    public ActionEventTest(String string){
        super(string);
        GUI();
    }

    public static void main(String[] args) {
        ActionEventTest actionEventTest = new ActionEventTest("this");
        actionEventTest.setVisible(true);
    }
}
