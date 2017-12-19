package cn.qblank.entity;

public class Employee {
	private Integer id;
	private String name;
	private String gender;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Employee(Integer id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	public Employee() {
	}
	
	
}
