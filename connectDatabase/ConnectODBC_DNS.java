package connectDatabase;



public class ConnectODBC_DNS {

    private Connection con=null;

    public ConnectODBC_DNS() throws Exception{

        String url="sun.jdbc.odbc.JdbcOdbcDriver";

        Class.forName(url);

        String dbUrl="jdbc:odbc:ex01";

        con= DriverManager.getConnection(dbUrl);

    }

    /**

     * Lấy danh sách các mẫu tin của bảng CSDL

     * @param tableName: tên bảng cần lấy các dòng

     * @return danh sách các dòng được lưu trong 1 ResultSet

     * @throws SQLException

     */

    public ResultSet GetResultSet(String tableName)throws SQLException {

        ResultSet rs=null;

        Statement stmt=con.createStatement();

        String sql="select * from " +tableName;

        rs=stmt.executeQuery(sql);

        return rs;

    }

    public void Close()throws Exception{

        con.close();

    }

//Thử chương trình

    public static void main(String[] args) {

        try {

            ConnectODBC_DNS conDSN=new ConnectODBC_DNS();

            ResultSet rs=conDSN.GetResultSet("table1");

            while(rs.next()) {

                System.out.println(rs.getString("id"));

            }

            conDSN.Close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
