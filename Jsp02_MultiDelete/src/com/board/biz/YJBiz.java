package com.board.biz;

import java.util.List;

import com.board.dto.YJDto;

public interface YJBiz {

	public List<YJDto> selectList();
	public YJDto selectOne(int seq);
	public int insert(YJDto dto);
	public int update(YJDto dto);
	public int delete(int seq);
	public int muldel(String []seq);
	
}
