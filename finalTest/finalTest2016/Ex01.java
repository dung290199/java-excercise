package finalTest.finalTest2016;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Ex01 extends JFrame implements ActionListener, ItemListener {

    private JLabel lb1, lb2, lb3;
    private Choice choice;
    JTextField txt1;
    JTextArea txt2;
    JButton view, reset, exit;
    JPanel pn, pn1, pn2;

    public void GUI(){
        lb1 = new JLabel("Nhập chuỗi: ");
        lb2 = new JLabel("Thực hiện: ");
        lb3 = new JLabel("Kết quả: ");

        txt1 = new JTextField();
        txt2 = new JTextArea();
        txt1.setPreferredSize(new Dimension(200, 30));
        txt2.setPreferredSize(new Dimension(200, 100));

        choice = new Choice();
        choice.add("Đếm từ");
        choice.add("Đếm từ trùng lặp");
        choice.add("Đảo chuỗi");

        choice.addItemListener(this);

        view = new JButton("View");
        reset = new JButton("Reset");
        exit = new JButton("Exit");

        view.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);

        pn = new JPanel(new GridBagLayout());
        pn1 = new JPanel(new GridBagLayout());
        pn2 = new JPanel(new FlowLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.01;
        gbc.weighty = 0.5;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        pn1.add(lb1, gbc);
        gbc.gridy++;
        pn1.add(lb2, gbc);
        gbc.gridy++;
        pn1.add(lb3, gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        pn1.add(txt1, gbc);
        gbc.gridy++;
        pn1.add(choice, gbc);
        gbc.gridy++;
        pn1.add(txt2, gbc);

        pn2.add(view);
        pn2.add(reset);
        pn2.add(exit);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.weighty = 1.;
        gbc1.weightx = 1.;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.anchor = GridBagConstraints.WEST;

        pn.add(pn1, gbc);
        gbc.gridy++;
        pn.add(pn2, gbc);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        add(pn);
        setSize(500, 300);
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            System.exit(0);
        }

        if (e.getSource() == reset) {
            txt1.setText("");
            txt2.setText("");
        }
        if (e.getSource() == view){
            String task = choice.getItem(choice.getSelectedIndex());
            String string = txt1.getText();
            switch (task){
                case "Đếm từ" :
                    int count = countWords(string);
                    txt2.setText(String.valueOf(count));
                    break;
                case "Đếm từ trùng lặp" :
                    Map<String, Integer> resultMap = countAppearances(string);
                    txt2.setText("");
                    for (String str : resultMap.keySet()) {
                        txt2.append(str + ": " + resultMap.get(str) + " lần\n");
                    }
                    break;
                case "Đảo chuỗi" :
                    String resultStr = reverseWords(string);
                    txt2.setText(resultStr);
                    break;
            }
        }
    }

    private Map<String, Integer> countAppearances(String string) {
        String[] arrStr = string.split(" ");
        Map<String, Integer> result = new HashMap<>();
        for (String str : arrStr) {
            if (result.containsKey(str)){
                int count = result.get(str);

                result.replace(str, count, ++count);
            } else {
                result.put(str, 1);
            }
        }
        return result;
    }

    private String reverseWords(String string) {
        String[] arrStr = string.split(" ");
        String result = "";
        for (int i = (arrStr.length - 1); i >= 0; i--) {
            result += arrStr[i] + " ";
        }
        return result;
    }

    private int countWords(String string) {
        String[] arrStr = string.split(" ");
        return arrStr.length;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public Ex01(String string){
        super(string);
        GUI();
    }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01("2016");
    }
}
