package ssm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class InsertData {
	
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_hibernate", "root", "root");
		//设置手动提交
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("INSERT INTO `emp` (`ename`, `job`, `mgr`, `hiredate`, `sal`, `comm`, `deptno`) VALUES (?, ?, ?, ?, ?, ?, ?)");
		for (int i=0;i<100000;i++) {
			ps.setString(1, "╮(╯_╰):" + i);
			ps.setString(2, "程序媛");
			ps.setInt(3, 2);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(4, sdf.format(new Date()));
			ps.setDouble(5, 4422d);
			ps.setDouble(6, 1d);
			ps.setInt(7, 2);
			ps.execute();
		}
		//提交事务
		conn.commit();
		ps.close();
		conn.close();
	}

}
