import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oumyye.model.User;

public class InsertTest {

	
	  public static void main(String args[]) {
		  String resource = "mybatis.xml";
	        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
	        InputStream is = Tests.class.getClassLoader().getResourceAsStream(resource);
	        //构建sqlSession的工厂
	        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	        
	        SqlSession session = sessionFactory.openSession();
	        /**
	         * 映射sql的标识字符串，
	         * com.oumyye.mapping.UserMapping是userMapper.xml文件中mapper标签的namespace属性的值，
	         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "com.oumyye.mapping.UserMapping.addUser";//映射sql的标识字符串
	        //执行查询返回一个唯一user对象的sql
	        int result=  session.insert("xxx");
	        session.commit();
	        System.out.println(""+ result);
	        
	        
	        
	  }
}
