package web01;

import org.junit.Test;

import java.sql.*;

public class JdbcDemo {

    @Test
    public void testFn() throws ClassNotFoundException {
        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取链接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtest?serverTimezone=GMT%2B8", "root", "000510");
            //3.获取/创建 Statement对象，用来执行sql语句
            Statement st = conn.createStatement();
            //4.编写sql语句
            String sql = "select * from user";
            //5.调用statement的API执行sql语句
            ResultSet rs = st.executeQuery(sql);
            //6.遍历结果
            while (rs.next()){
                System.out.println("user_name:" + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
