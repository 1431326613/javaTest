package xx;



import java.sql.*;
public class MysqlJdbc {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
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
           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

      System.out.println("Success connect Mysql server!");
      Statement stmt = connect.createStatement();
      ResultSet rs = stmt.executeQuery("select * from user");
                                                              //user Ϊ��������
while (rs.next()) {
        System.out.println(rs.getString("name"));
      }

		
		// �رռ�¼��
		if (rs != null) {
		    try {
		        rs.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		// �ر����Ӷ���
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