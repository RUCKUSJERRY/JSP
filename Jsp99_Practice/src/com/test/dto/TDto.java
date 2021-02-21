package com.test.dto;

public class TDto {

	private int seq;
	private String name;
	private String id;
	private String pw;
	private String addr;
	private String phone;
	private String email;
	private String role;
	private String marrige;
	private String gender;
	private String enabled;
	
	public TDto() {
		
	}

	public TDto(int seq, String name, String id, String pw, String addr, String phone, String email, String role,
			String marrige, String gender, String enabled) {
		super();
		this.seq = seq;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.marrige = marrige;
		this.gender = gender;
		this.enabled = enabled;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMarrige() {
		return marrige;
	}

	public void setMarrige(String marrige) {
		this.marrige = marrige;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
	
}
