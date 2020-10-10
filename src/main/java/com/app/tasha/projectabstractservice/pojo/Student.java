package com.app.tasha.projectabstractservice.pojo;

import lombok.Data;

@Data
public class Student {
	private Long id;
	private String rollNumber;
	private String name;
	private String department;
	private Long contact;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRollNumber() {
		return rollNumber;
	}
	
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Long getContact() {
		return contact;
	}
	
	public void setContact(Long contact) {
		this.contact = contact;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNumber=" + rollNumber + ", name=" + name + ", department=" + department
				+ ", contact=" + contact + "]";
	}	
}

