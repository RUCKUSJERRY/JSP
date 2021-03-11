package com.myboard.biz;

import java.util.List;
import com.myboard.dto.MyBoardDto;

public interface MyBoardBiz {
	
	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(int seq);
	public int insert(MyBoardDto dto);
	public int update(MyBoardDto dto);
	public int delete(int seq);
	
}
