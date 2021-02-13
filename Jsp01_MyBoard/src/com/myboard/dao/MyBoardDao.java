package com.myboard.dao;

import java.util.List;

import com.myboard.dto.MyBoardDto;

public interface MyBoardDao {
	
	String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
			               + " FROM MYBOARD ";
	String SELECT_ONE_SQL = "";
	String INSERT_SQL = "";
	String UPDATE_SQL = "";
	String DELETE_SQL = "";
	
	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(MyBoardDto dto);
	public int insert(MyBoardDto dto);
	public int update(int seq);
	public int delete(int seq);
	
}
