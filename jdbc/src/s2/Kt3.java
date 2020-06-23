package s2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Kt3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "t531");
			
			String sql = "insert into stu(id,name,age,sex,score,weight,xz,birth,room)"
					+ " values (?,?,?,?,?,?,?,?,?)";
			//?表示占位符，sql语句有两个参数需要设置
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//设置参数值
				//注意值和参数对应准确，数据类型准确
			
			ps.setString(1, "666");
			ps.setString(2, "张三");
			ps.setInt(3, 18);
			ps.setString(4,"男");
			ps.setInt(5, 98);
			ps.setDouble(6, 175.0);
			ps.setString(7, "金牛");
			ps.setDate(8, new Date(System.currentTimeMillis()));
			ps.setString(9, "201");
			
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
