package model;

import java.util.Date;

/**
 * 实体类
 * 跟数据库表对应的
 * @author mayibo
 *
 */
public class Stu {
	private String id;
	private String name;
	private int age;
	private String sex;
	private double score;
	private double weight;
	private String xz;
	private Date birth;
	private String room;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getXz() {
		return xz;
	}
	public void setXz(String xz) {
		this.xz = xz;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return id+"_"+name;
	}
	
}
