package s2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 按照学号，修改学生成绩
 * 
 * 获取用户输入的学号和成绩，进行修改
 * @author mayibo
 *
 */
public class Kt1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学号：");
		String id = sc.nextLine();
		System.out.println("请输入成绩");
		int cj = sc.nextInt();
		
		//Ctrl c+V
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "t531");
			
			String sql = "update stu set score="+cj+" where id='"+id+"'";
			
			System.out.println(sql);
			
			Statement st = conn.createStatement();
			
			int a = st.executeUpdate(sql);//返回值表示受影响的行
			
			System.out.println("修改完毕，受影响的行："+a);
			
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
