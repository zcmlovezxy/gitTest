package s2;

import java.util.List;

import dao.StuDao;
import model.Stu;

/*
 * 
 * ��ѯ����ѧ����¼��Ȼ��Խ����¼�������򡢱Ƚϡ�ͳ�ƵȲ���
 * 
 * ����һ��ѧ����¼
 * 
 * �޸�ѧ���ɼ�
 * 
 * ...
 * ����Ҫ��k1~k4���룬�ظ��Ŀ����𣿣�
 * 
 * 
 */
public class Kt5 {

	public static void main(String[] args) {
		
		List<Stu> ls = StuDao.searchAll();
		
		System.out.println(ls);
		
		StuDao.delete("100");
	}
	
}
