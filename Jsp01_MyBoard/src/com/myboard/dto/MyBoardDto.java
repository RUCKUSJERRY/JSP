package com.myboard.dto;
import java.util.Date;

// db 안에 있는 row 하나를 저장해서 전달(전송)
public class MyBoardDto {

	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date date;
	
	public MyBoardDto() {
		
	}
	
	public MyBoardDto(int myno, String myname, String mytitle, String mycontent, String date) {
		
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

	
}
