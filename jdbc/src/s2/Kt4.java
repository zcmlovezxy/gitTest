package s2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Stu;

/**
 * 查询所有的学生记录，并将学生记录放入一个集合中
 * @author mayibo
 *
 */

public class Kt4 {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "t531");
			
			String sql = "select * from stu";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();//执行sql，获取查询结果(结果集)
			
			
			List<Stu> sts = new ArrayList<>();
			//以下是固定写法，遍历结果集，获取结果内容
			while(rs.next()) {
				
				//逐个字段获取内容
					//注意字段名和字段类型
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				double score = rs.getDouble("score");
				double weight = rs.getDouble("weight");
				String xz = rs.getString("xz");
				Date birth = rs.getDate("birth");
				//util.Date是父类， sql.Date是子类，此处多态特性
				//在java中使用的都是util.Date，只有跟数据库交互时，才涉及到sql.Date
				//sql.Date 和 util.Date区别。
				String room = rs.getString("room");
				
				//封装到对象中
				Stu s = new Stu();
				s.setId(id);
				s.setName(name);
				s.setAge(age);
				s.setSex(sex);
				s.setScore(score);
				s.setWeight(weight);
				s.setXz(xz);
				s.setBirth(birth);
				s.setRoom(room);
				
				//将对象放入集合
				sts.add(s);
			}
			
			System.out.println(sts);
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
