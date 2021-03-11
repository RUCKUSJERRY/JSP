package com.myboard.dao;

import java.util.List;

import com.myboard.dto.MyBoardDto;

public interface MyBoardDao {
	
	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(int seq);
	public int insert(MyBoardDto dto);
	public int update(MyBoardDto dto);
	public int delete(int seq);
	
}
