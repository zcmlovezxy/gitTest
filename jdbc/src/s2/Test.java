package s2;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Date d = new Date();
		
		//1970 1 1����ǰdate�ĺ����������ֱ�ʾ��ʽ��java�е�һ������������ʽ�����Ϊlong���͵�����
		System.out.println(d.getTime());
		
		//System.currentTimeMillis() ��ǰϵͳʱ��ĺ�����
		System.out.println(System.currentTimeMillis());
	}

}
