package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Stu;

/**
 * DAO类
 * Database Access Object
 * 数据库操作对象
 * 
 * StuDao里面就封装了对Stu表的增删改查操作
 * @author mayibo
 *
 */
public class StuDao {
	
	//方法的三要素： 返回类型 方法名 参数
	
	//查询所有
	public static List<Stu> searchAll(){
		
		List<Stu> sts = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "t531");
			
			String sql = "select * from stu";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();//执行sql，获取查询结果(结果集)
			
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
			rs.close();
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sts;
	}
	
	
	//新增学生
	public static int add(Stu s) {
		
		int a = 0;
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
			
			ps.setString(1, s.getId());
			ps.setString(2, s.getName());
			ps.setInt(3, s.getAge());
			ps.setString(4,s.getSex());
			ps.setDouble(5, s.getScore());
			ps.setDouble(6, s.getWeight());
			ps.setString(7, s.getXz());
			
			//@1 为什么写成 java.sql.Date
			//@2 getTime是弄啥类
			//@3 为什么不直接写成 ps.setDate( 8,s.getBirth() )
			
			ps.setDate(8,   new java.sql.Date(  s.getBirth().getTime()  )     );
			ps.setString(9, s.getRoom());
			
			a = ps.executeUpdate();
			
			
			System.out.println("修改完毕，受影响的行："+a);
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
	
	//删除学生
	public static int delete(String id) {
		
		int a =  0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "T531");
			
			String sql = "  delete from stu where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			a = ps.executeUpdate(sql);//返回值表示受影响的行
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
}
