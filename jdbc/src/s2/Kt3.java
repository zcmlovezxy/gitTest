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
			//?��ʾռλ����sql���������������Ҫ����
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//���ò���ֵ
				//ע��ֵ�Ͳ�����Ӧ׼ȷ����������׼ȷ
			
			ps.setString(1, "666");
			ps.setString(2, "����");
			ps.setInt(3, 18);
			ps.setString(4,"��");
			ps.setInt(5, 98);
			ps.setDouble(6, 175.0);
			ps.setString(7, "��ţ");
			ps.setDate(8, new Date(System.currentTimeMillis()));
			ps.setString(9, "201");
			
			int a = ps.executeUpdate();
			
			
			System.out.println("�޸���ϣ���Ӱ����У�"+a);
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
