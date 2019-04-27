package hsx.com.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hsx.com.mappers.StudentMapper;
import hsx.com.model.Student;
import hsx.com.util.SqlSessionFactoryUtil;

public class StudentTest2 {

	private static Logger logger=Logger.getLogger(StudentTest2.class);
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

	
	@Test
	public void testInsertStudent(){
		logger.info("����ѧ��");
		Student student=new Student();
		student.setName("����4");
		student.setAge(14);
		student.setRemark("�ܳ��ı���...");
		byte []pic=null;
		try{
			File file=new File("d://boy.jpg");
			InputStream inputStream=new FileInputStream(file);
			pic=new byte[inputStream.available()];
			inputStream.read(pic);
			inputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		student.setPic(pic);
		studentMapper.insertStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testGetStudentById(){
		logger.info("ͨ��ID����ѧ��");
		Student student=studentMapper.getStudentById(4);
		System.out.println(student);
		byte []pic=student.getPic();
		try{
			File file=new File("d://boy2.jpg");
			OutputStream outputStream=new FileOutputStream(file);
			outputStream.write(pic);
			outputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearchStudents6() {
		logger.info("����ѧ��(������)");
		List<Student> studentList=studentMapper.searchStudents6("%3%",12);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
}