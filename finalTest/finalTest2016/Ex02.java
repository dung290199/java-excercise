package finalTest.finalTest2016;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.stream.Stream;

public class Ex02 {

    public ResultSet connect(String query){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtourdulich_102170148","root","123456");
            Statement stmt=con.createStatement();
            ResultSet rs = null;
            if (query.toLowerCase().contains("select")){
                rs = stmt.executeQuery(query);
            } else {
                stmt.execute(query);
            }
//            if (query.contains("select")){
//                rs = stmt.executeQuery(query);
//                rs.last();
//                rs.first();
//            } else {
//                stmt.executeUpdate(query);
//                rs = stmt.executeQuery("select * from table1");
//                rs.last();
//                rows = rs.getRow();
//                rs.first();
//            }
            return rs;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    /*
    * E:/JAVA/src/finalTest/finalTest2016/dataFiles/data2.txt
    * */

    public static void main(String[] args) throws SQLException {
        Ex02 ex02 = new Ex02();

        String filePath1 = "E:/JAVA/src/finalTest/finalTest2016/dataFiles/data1.txt";
        Object[] data1 = ex02.getData(filePath1);
        for (Object str : data1) {
            String[] values = ((String)str).split(", ");
            String query = "INSERT INTO thanhvien(MaThanhVien, TenThanhVien, NgaySinh, DiaChi, Email, SoDienThoai, ChiPhiNhan)" +
                    " VALUES ('" + values[0] + "','" + values[1] + "','"+ values[2] + "','" + values[3] + "','" + values[4] + "','" + values[5] + "',0)";
            ex02.connect(query);
        }

        String filePath2 = "E:/JAVA/src/finalTest/finalTest2016/dataFiles/data2.txt";
        Object[] data2 = ex02.getData(filePath2);
        for (Object str : data2) {
            String[] values = ((String)str).split(", ");

            String q = "SELECT `ChiPhiNhan` FROM `thanhvien` WHERE `MaThanhVien`='" + values[0] + "'";
            ResultSet resultSet = ex02.connect(q);
            resultSet.next();
            float chiPhiNhan = Float.parseFloat(resultSet.getString(1));

            String level = values[2];
            float diemThuong = Float.parseFloat(values[1]);
            switch (level){
                case "VIP":
                    chiPhiNhan += diemThuong * 50000;
                    break;
                case "NOR":
                    chiPhiNhan += diemThuong * 20000;
                    break;
            }
            //UPDATE `thanhvien` SET `ChiPhiNhan`=12000 WHERE `MaThanhVien`='TV00001'
            String query = "UPDATE thanhvien SET ChiPhiNhan=" + chiPhiNhan + " WHERE MaThanhVien='" + values[0] + "'";
            ex02.connect(query);
        }

    }


    //Read file content into string with - Files.lines(Path path, Charset cs)

    private Object[] getData(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        Object[] arrStr = null;

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            arrStr = stream.toArray();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return arrStr;
    }
}
