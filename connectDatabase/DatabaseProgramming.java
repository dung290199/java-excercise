package connectDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class DatabaseProgramming extends JFrame implements ActionListener {

    Connection con;

    static int rows = 0;
    String column[]={"ID","NAME","ADDRESS", "TOTAL"};

    JLabel lb1, lb2, lb3, lb4, lb5, lb6;
    JTextField txt1, txt2;
    JButton submit, reset, cancel;
    JPanel pn, pn1, pn2, pn3;
    JTable table;
    public void GUI() throws SQLException {
        lb1 = new JLabel("Input information: ");
        lb2 = new JLabel("SQL: ");
        lb3 = new JLabel("Id");
        lb4 = new JLabel("Name");
        lb5 = new JLabel("Address");
        lb6 = new JLabel("Total");

        txt1 = new JTextField();
        txt1.setColumns(20);
        txt2 = new JTextField();
        txt2.setColumns(20);

        String data[][] = new String[rows][4];
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column);
        table = new JTable();
        table.setModel(defaultTableModel);
        table.setBounds(30,40,700,300);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        submit = new JButton("Submit");
        reset = new JButton("Reset");
        cancel = new JButton("Cancel");

        submit.addActionListener(this);
        reset.addActionListener(this);
        cancel.addActionListener(this);

        pn = new JPanel(new GridLayout(3,1));
        pn1 = new JPanel(new GridBagLayout());
        pn2 = new JPanel(new FlowLayout());
        pn3 = new JPanel(new FlowLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        pn1.add(lb1, gbc);
        gbc.gridy++;
        pn1.add(lb2, gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        pn1.add(txt1, gbc);
        gbc.gridy++;
        pn1.add(txt2, gbc);

        pn2.add(scrollPane);

        pn3.add(submit);
        pn3.add(reset);
        pn3.add(cancel);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        add(pn);
        setSize(600, 400);
        show();
    }

    private void setTableData(JTable table, ResultSet resultSet) throws SQLException {
        String data[][] = new String[rows][4];

        try{
            for (int i = 0; i < rows; i++) {
                for (int j = 1; j <= 4; j++) {
                    data[i][j-1] = resultSet.getString(j);
                    System.out.println(resultSet.getString(j));
                }
                resultSet.next();
            }
        } catch (Exception e1){
            e1.getStackTrace();
        }

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column);
        table.setModel(defaultTableModel);
    }
/*
* jdbc:mysql://localhost:3306/dulieu
* select * from table1
* */
    public ResultSet connect(String dataInfo, String query){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dataInfo,"root","123456");
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            query = query.toLowerCase();
            ResultSet rs = null;
            if (query.contains("select")){
                rs = stmt.executeQuery(query);
                rs.last();
                rows = rs.getRow();
                rs.first();
            } else {
                stmt.executeUpdate(query);
                rs = stmt.executeQuery("select * from table1");
                rs.last();
                rows = rs.getRow();
                rs.first();
            }

            return rs;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel){
            if (con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.exit(0);
        }

        if (e.getSource() == reset){
            txt1.setText("");
            txt2.setText("");

            DefaultTableModel dm = (DefaultTableModel) table.getModel();
            while (rows != 0){
                dm.removeRow(rows - 1);
                rows--;
            }
        }

        if (e.getSource() == submit){
            String dataInfor = txt1.getText();
            String query = txt2.getText();

            if (!dataInfor.isEmpty() && !query.isEmpty()){
                ResultSet resultSet = connect(dataInfor, query);
                try {
                    setTableData(table, resultSet);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public DatabaseProgramming(String string) throws SQLException {
        super(string);
        GUI();
    }

    public static void main(String[] args) throws SQLException {
        DatabaseProgramming databaseProgramming2 = new DatabaseProgramming("Database connect");
    }


}
