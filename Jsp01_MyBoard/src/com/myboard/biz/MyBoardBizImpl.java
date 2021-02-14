package com.myboard.biz;

import java.util.List;

import com.myboard.dao.MyBoardDao;
import com.myboard.dao.MyBoardDaoImpl;
import com.myboard.dto.MyBoardDto;

public class MyBoardBizImpl implements MyBoardBiz {
	
	private MyBoardDao dao = new MyBoardDaoImpl();
	
	@Override
	public List<MyBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MyBoardDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(MyBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MyBoardDto dto) {		
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {	
		return dao.delete(seq);
	}

}
