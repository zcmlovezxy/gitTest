package s2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *PreparedStatement�޸�
 *
 *Prepared ׼���ģ�Ԥ����
 *PreparedStatement Ԥִ�����
 *
 */
public class Kt2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ�ţ�");
		String id = sc.next();
		System.out.println("������ɼ�");
		int cj = sc.nextInt();
		
		//Ctrl c+V
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "t531");
			
			String sql = "update stu set score=? where id=? ";
			//?��ʾռλ����sql���������������Ҫ����
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//���ò���ֵ
				//1,2��ʾsql����еĵڼ����ʺ�
			ps.setInt(1, cj);
			ps.setString(2, id);
			
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
