package s1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * ��ȡ�û������ѧ�ţ�
 * ɾ��stu���У���ѧ�Ŷ�Ӧ��ѧ����¼
 * @author mayibo
 *
 */
public class Kt1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫɾ����ѧ��ѧ�ţ�");
		String id = sc.next();
		
		try {
			//@1 ע������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//@2 ��������
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "T531", "T531");
			
			//@3 ��дsql���
			String sql = "  delete from stu where id='"   +  id  +   "'   ";
			
			//@4 ����ִ�ж���  Statement PreparedStatement
			Statement st = conn.createStatement();
			
			//@5 ִ��sql  ��ɾ��---��executeUpdate    ��ѯ----��executeQuery
			int a = st.executeUpdate(sql);//����ֵ��ʾ��Ӱ�����
			
			//@6 �������
			if(a==1) {
				System.out.println("ɾ���ɹ�");
			}else {
				System.out.println("ɾ��ʧ��");
			}
			
			//@7�ر���Դ
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

	}

}
