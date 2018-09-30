package ssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhidi.entity.Student;
import com.zhidi.service.IStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSSM {
	
	@Autowired
	private IStudentService studentService;
	
	@Test
	public void test() {
		Student student = new Student();
		student.setStuName("admin2");
		boolean status = studentService.save(student);
		System.out.println(status);
	}
}
