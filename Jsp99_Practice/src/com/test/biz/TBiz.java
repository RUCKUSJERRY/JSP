package com.test.biz;

import java.util.List;

import com.test.dto.TDto;

public interface TBiz {

	public TDto loginUser(String id, String pw);
	public List<TDto> selectList();
	
}
