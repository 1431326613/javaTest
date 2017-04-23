package xx;



import java.sql.*;
public class MysqlJdbc {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
      //Class.forName("org.gjt.mm.mysql.Driver");
     System.out.println("Success loading Mysql Driver!");
    }
    catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
    try {
      Connection connect = DriverManager.getConnection(
          "jdbc:mysql://119.29.129.44:3306/test","root","password");
           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

      System.out.println("Success connect Mysql server!");
      Statement stmt = connect.createStatement();
      ResultSet rs = stmt.executeQuery("select * from user");
                                                              //user 为你表的名称
while (rs.next()) {
        System.out.println(rs.getString("name"));
      }

		
		// 关闭记录集
		if (rs != null) {
		    try {
		        rs.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		// 关闭链接对象
        if (connect != null) {
            try {
            	connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		

    }
    catch (Exception e) {
      System.out.print("get data error!");
      e.printStackTrace();
    }
  }
}