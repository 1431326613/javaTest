import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oumyye.model.User;

public class InsertTest {

	
	  public static void main(String args[]) {
		  String resource = "mybatis.xml";
	        //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
	        InputStream is = Tests.class.getClassLoader().getResourceAsStream(resource);
	        //����sqlSession�Ĺ���
	        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	        
	        SqlSession session = sessionFactory.openSession();
	        /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * com.oumyye.mapping.UserMapping��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "com.oumyye.mapping.UserMapping.addUser";//ӳ��sql�ı�ʶ�ַ���
	        //ִ�в�ѯ����һ��Ψһuser�����sql
	        int result=  session.insert("xxx");
	        session.commit();
	        System.out.println(""+ result);
	        
	        
	        
	  }
}
