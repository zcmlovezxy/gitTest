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
 * ��ѯ���е�ѧ����¼������ѧ����¼����һ��������
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
			
			ResultSet rs = ps.executeQuery();//ִ��sql����ȡ��ѯ���(�����)
			
			
			List<Stu> sts = new ArrayList<>();
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
