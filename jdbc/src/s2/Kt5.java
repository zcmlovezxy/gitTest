package s2;

import java.util.List;

import dao.StuDao;
import model.Stu;

/*
 * 
 * 查询所有学生记录，然后对结果记录进行排序、比较、统计等操作
 * 
 * 新增一条学生记录
 * 
 * 修改学生成绩
 * 
 * ...
 * 我需要将k1~k4代码，重复的拷贝吗？！
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
