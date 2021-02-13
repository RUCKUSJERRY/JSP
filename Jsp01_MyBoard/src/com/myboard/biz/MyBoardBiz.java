package com.myboard.biz;

import java.util.List;
import com.myboard.dto.MyBoardDto;

public interface MyBoardBiz {
	
	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(MyBoardDto dto);
	public int insert(MyBoardDto dto);
	public int update(int seq);
	public int delete(int seq);
	
}
