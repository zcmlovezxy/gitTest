package s2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *PreparedStatement修改
 *
 *Prepared 准备的，预备的
 *PreparedStatement 预执行语句
 *
 */
public class Kt2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学号：");
		String id = sc.next();
		System.out.println("请输入成绩");
		int cj = sc.nextInt();
		
		//Ctrl c+V
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "t531");
			
			String sql = "update stu set score=? where id=? ";
			//?表示占位符，sql语句有两个参数需要设置
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//设置参数值
				//1,2表示sql语句中的第几个问号
			ps.setInt(1, cj);
			ps.setString(2, id);
			
			int a = ps.executeUpdate();
			
			
			System.out.println("修改完毕，受影响的行："+a);
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
