package s1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 获取用户输入的学号，
 * 删除stu表中，该学号对应的学生记录
 * @author mayibo
 *
 */
public class Kt1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要删除的学生学号：");
		String id = sc.next();
		
		try {
			//@1 注册驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//@2 创建连接
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "T531");
			
			//@3 编写sql语句
			String sql = "  delete from stu where id='"   +  id  +   "'   ";
			
			//@4 创建执行对象  Statement PreparedStatement
			Statement st = conn.createStatement();
			
			//@5 执行sql  增删改---》executeUpdate    查询----》executeQuery
			int a = st.executeUpdate(sql);//返回值表示受影响的行
			
			//@6 操作结果
			if(a==1) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
			
			//@7关闭资源
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

	}

}
