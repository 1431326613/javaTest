

import java.io.InputStream;
 
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oumyye.model.User;
import com.oumyye.model.UserMapper;

import java.util.List;

public class Tests {
	
	
	  public static void main(String args[]) {
		  String resource = "mybatis.xml";
	        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
	        InputStream is = Tests.class.getClassLoader().getResourceAsStream(resource);
	        //构建sqlSession的工厂
	        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	        
	        SqlSession session = sessionFactory.openSession();
	        try {
	        	 //xmlGet(session);
	 	      // classGet(session,"jacky");
	 	     // classGet(session,"xx");
	          //addGet(session);
	        	
	        //	addXmlGet(session);
	        
	        	//delete(session,"xx");
	        	xmlGetAll(session);
	        	
			} finally {
				// TODO: handle finally clause
				session.close();
			}
	        
	       
	        
	  }
	  
	  static void addGet(SqlSession session)
	  {
		//执行查询返回一个唯一user对象的sql
		  UserMapper userMapper=  session.getMapper(UserMapper.class);
		  User user=new User();
		  user.setName("xx");
		  userMapper.addUser(user);
		  session.commit();
	        System.out.println(user.toString());
	  }
	  static void addXmlGet(SqlSession session)
	  {
		  
		  User user=new User();
		  user.setName("xx");
		  
		  String statement = "com.oumyye.mapping.UserMapping.addUser";//映射sql的标识字符串
		  int result= session.insert(statement, user);
		 
		  System.out.println(""+ result);
		  
		  
	  }
	  static void xmlGet( SqlSession session)
	  {
		  /**
	         * 映射sql的标识字符串，
	         * com.oumyye.mapping.UserMapping是userMapper.xml文件中mapper标签的namespace属性的值，
	         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "com.oumyye.mapping.UserMapping.getUser";//映射sql的标识字符串
	        //执行查询返回一个唯一user对象的sql
	        User user = session.selectOne(statement, "jacky");
	        System.out.println(user.toString());
	  }
	  
	  static void xmlGetAll( SqlSession session)
	  {
		  /**
	         * 映射sql的标识字符串，
	         * com.oumyye.mapping.UserMapping是userMapper.xml文件中mapper标签的namespace属性的值，
	         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "com.oumyye.mapping.UserMapping.getAllUsers";//映射sql的标识字符串
	        //执行查询返回一个唯一user对象的sql
	        List<User> lstUsers=session.selectList(statement);
	          
	        if(lstUsers!=null&& lstUsers.size()>0)
	        {
	        	for(int i=0;i<lstUsers.size();i++)
		        {
		        	   System.out.println(lstUsers.get(i).getName());
		        }
	        }
	        
	     
	  }
	  
	  
	  static void delete( SqlSession session,String name)
	  {
		  /**
	         * 映射sql的标识字符串，
	         * com.oumyye.mapping.UserMapping是userMapper.xml文件中mapper标签的namespace属性的值，
	         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "com.oumyye.mapping.UserMapping.deleteUser";//映射sql的标识字符串
	        //执行查询返回一个唯一user对象的sql
	        int result=session.delete(statement, name);
	        session.commit();
	          
	        System.out.println(""+result);   
	        
	     
	  }
	  static void classGet( SqlSession session,String name)
	  {
		  
	        //执行查询返回一个唯一user对象的sql
		  UserMapper userMapper=  session.getMapper(UserMapper.class);
		  User user= userMapper.selectUser(name);
	        System.out.println(user.toString());
	  }

}
