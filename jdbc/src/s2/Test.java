package s2;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Date d = new Date();
		
		//1970 1 1到当前date的毫秒数，这种表示形式是java中的一种日期描述形式，结果为long类型的数字
		System.out.println(d.getTime());
		
		//System.currentTimeMillis() 当前系统时间的毫秒数
		System.out.println(System.currentTimeMillis());
	}

}
