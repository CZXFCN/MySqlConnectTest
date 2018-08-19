import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by qcl on 2017/11/18.
 * 数据库连接
 */
public class DB {
    public static void main(String[] args) {
        //数据库连接测试
        Connection con;
        String driver="com.mysql.cj.jdbc.Driver";
        //这里我的数据库是qc1
        String url="jdbc:mysql://localhost:3306/qc1";
        String user="root";
        String password="czxsda0.0";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM home;";//我的表格叫home
            ResultSet resultSet = statement.executeQuery(sql);
            String name;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                System.out.println("姓名：" + name);
            }
            resultSet.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
    }
}