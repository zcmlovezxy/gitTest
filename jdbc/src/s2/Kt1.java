package s2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * ����ѧ�ţ��޸�ѧ���ɼ�
 * 
 * ��ȡ�û������ѧ�źͳɼ��������޸�
 * @author mayibo
 *
 */
public class Kt1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ�ţ�");
		String id = sc.nextLine();
		System.out.println("������ɼ�");
		int cj = sc.nextInt();
		
		//Ctrl c+V
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "t531");
			
			String sql = "update stu set score="+cj+" where id='"+id+"'";
			
			System.out.println(sql);
			
			Statement st = conn.createStatement();
			
			int a = st.executeUpdate(sql);//����ֵ��ʾ��Ӱ�����
			
			System.out.println("�޸���ϣ���Ӱ����У�"+a);
			
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
