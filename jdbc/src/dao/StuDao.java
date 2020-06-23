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
 * DAO��
 * Database Access Object
 * ���ݿ��������
 * 
 * StuDao����ͷ�װ�˶�Stu�����ɾ�Ĳ����
 * @author mayibo
 *
 */
public class StuDao {
	
	//��������Ҫ�أ� �������� ������ ����
	
	//��ѯ����
	public static List<Stu> searchAll(){
		
		List<Stu> sts = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "t531");
			
			String sql = "select * from stu";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();//ִ��sql����ȡ��ѯ���(�����)
			
			//�����ǹ̶�д�����������������ȡ�������
			while(rs.next()) {
				
				//����ֶλ�ȡ����
					//ע���ֶ������ֶ�����
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				double score = rs.getDouble("score");
				double weight = rs.getDouble("weight");
				String xz = rs.getString("xz");
				Date birth = rs.getDate("birth");
				//util.Date�Ǹ��࣬ sql.Date�����࣬�˴���̬����
				//��java��ʹ�õĶ���util.Date��ֻ�и����ݿ⽻��ʱ�����漰��sql.Date
				//sql.Date �� util.Date����
				String room = rs.getString("room");
				
				//��װ��������
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
				
				//��������뼯��
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
	
	
	//����ѧ��
	public static int add(Stu s) {
		
		int a = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "t531");
			
			String sql = "insert into stu(id,name,age,sex,score,weight,xz,birth,room)"
					+ " values (?,?,?,?,?,?,?,?,?)";
			//?��ʾռλ����sql���������������Ҫ����
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//���ò���ֵ
				//ע��ֵ�Ͳ�����Ӧ׼ȷ����������׼ȷ
			
			ps.setString(1, s.getId());
			ps.setString(2, s.getName());
			ps.setInt(3, s.getAge());
			ps.setString(4,s.getSex());
			ps.setDouble(5, s.getScore());
			ps.setDouble(6, s.getWeight());
			ps.setString(7, s.getXz());
			
			//@1 Ϊʲôд�� java.sql.Date
			//@2 getTime��Ūɶ��
			//@3 Ϊʲô��ֱ��д�� ps.setDate( 8,s.getBirth() )
			
			ps.setDate(8,   new java.sql.Date(  s.getBirth().getTime()  )     );
			ps.setString(9, s.getRoom());
			
			a = ps.executeUpdate();
			
			
			System.out.println("�޸���ϣ���Ӱ����У�"+a);
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
	
	//ɾ��ѧ��
	public static int delete(String id) {
		
		int a =  0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "T531");
			
			String sql = "  delete from stu where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			a = ps.executeUpdate(sql);//����ֵ��ʾ��Ӱ�����
			
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
