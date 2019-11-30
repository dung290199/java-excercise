package frame_excercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ItemEventTest extends JFrame implements ItemListener{
    JLabel lb1, lb2;
    Choice choice;
    JPanel pn, pn1, pn2, pn3;
    List list;
    JCheckBox male, female;

    public void GUI() {
        lb1 = new JLabel("Item Event Test");
        lb2 = new JLabel("The event is displayed here!");

        choice = new Choice();
        choice.add("Unix");
        choice.add("Linux");
        choice.add("Window");

        list = new List();
        list.add("Lion");
        list.add("Fox");
        list.add("Tiger");

        male = new JCheckBox("Male", false);
        female = new JCheckBox("Female", false);

        pn = new JPanel(new GridLayout(3, 1));
        pn1 = new JPanel(new FlowLayout());
        pn2 = new JPanel(new FlowLayout());
        pn3 = new JPanel(new FlowLayout());


        choice.addItemListener(this);
        male.addItemListener(this);
        female.addItemListener(this);
        list.addItemListener(this);

        pn1.add(lb1);

        pn2.add(male);
        pn2.add(female);
        pn2.add(choice);
        pn2.add(list);

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
        setSize(500, 300);
        show();

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == choice){
            lb2.setText("You clicked on " + e.getItem().toString());
        }

        if (e.getSource() == male){
            String r = (e.getStateChange() == 1) ? "You chose Male" : "You unchose Male";
            lb2.setText(r);
        }

        if (e.getSource() == female){
            String r = (e.getStateChange() == 1) ? "You chose Female" : "You unchose Female";
            lb2.setText(r);
        }

        if (e.getSource() == list){
            lb2.setText("You chose " + list.getItem(Integer.parseInt(e.getItem().toString())));
        }


    }

    public ItemEventTest(String string){
        super(string);
        GUI();
    }

    public static void main(String[] args) {
        ItemEventTest itemEventTest = new ItemEventTest("this");
        itemEventTest.setVisible(true);
    }
}
