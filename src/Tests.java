

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
	        //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
	        InputStream is = Tests.class.getClassLoader().getResourceAsStream(resource);
	        //����sqlSession�Ĺ���
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
		//ִ�в�ѯ����һ��Ψһuser�����sql
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
		  
		  String statement = "com.oumyye.mapping.UserMapping.addUser";//ӳ��sql�ı�ʶ�ַ���
		  int result= session.insert(statement, user);
		 
		  System.out.println(""+ result);
		  
		  
	  }
	  static void xmlGet( SqlSession session)
	  {
		  /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * com.oumyye.mapping.UserMapping��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "com.oumyye.mapping.UserMapping.getUser";//ӳ��sql�ı�ʶ�ַ���
	        //ִ�в�ѯ����һ��Ψһuser�����sql
	        User user = session.selectOne(statement, "jacky");
	        System.out.println(user.toString());
	  }
	  
	  static void xmlGetAll( SqlSession session)
	  {
		  /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * com.oumyye.mapping.UserMapping��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "com.oumyye.mapping.UserMapping.getAllUsers";//ӳ��sql�ı�ʶ�ַ���
	        //ִ�в�ѯ����һ��Ψһuser�����sql
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
	         * ӳ��sql�ı�ʶ�ַ�����
	         * com.oumyye.mapping.UserMapping��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "com.oumyye.mapping.UserMapping.deleteUser";//ӳ��sql�ı�ʶ�ַ���
	        //ִ�в�ѯ����һ��Ψһuser�����sql
	        int result=session.delete(statement, name);
	        session.commit();
	          
	        System.out.println(""+result);   
	        
	     
	  }
	  static void classGet( SqlSession session,String name)
	  {
		  
	        //ִ�в�ѯ����һ��Ψһuser�����sql
		  UserMapper userMapper=  session.getMapper(UserMapper.class);
		  User user= userMapper.selectUser(name);
	        System.out.println(user.toString());
	  }

}
