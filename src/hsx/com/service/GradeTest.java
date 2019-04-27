package hsx.com.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hsx.com.mappers.GradeMapper;
import hsx.com.model.Grade;
import hsx.com.util.SqlSessionFactoryUtil;

public class GradeTest {

	private static Logger logger=Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession=null;
	private GradeMapper gradeMapper=null;
	
	/**
	 * ���Է���ǰ����
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		gradeMapper=sqlSession.getMapper(GradeMapper.class);
	}

	/**
	 * ���Է��������
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	@Test
	public void testFindGradeWithStudents() {
		logger.info("��ѯ�꼶(��ѧ��)");
		Grade grade=gradeMapper.findById(1);
		System.out.println(grade);
	}
	
}
