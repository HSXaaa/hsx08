package hsx.com.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hsx.com.mappers.StudentMapper;
import hsx.com.model.Student;
import hsx.com.util.SqlSessionFactoryUtil;

public class StudentTest3 {

	private static Logger logger=Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession=null;
	private StudentMapper studentMapper=null;
	
	/**
	 * ���Է���ǰ����
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);
	}

	/**
	 * ���Է��������
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

/*	@Test
	public void testFindStudentWithAddress() {
		logger.info("��ѯѧ��(����ַ)");
		Student student=studentMapper.findStudentWithAddress(2);
		System.out.println(student);
	}*/
	
}
