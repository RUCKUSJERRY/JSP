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
	public MyBoardDto selectOne(MyBoardDto dto) {
		return dao.selectOne(dto);
	}

	@Override
	public int insert(MyBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(int seq) {		
		return dao.update(seq);
	}

	@Override
	public int delete(int seq) {	
		return dao.delete(seq);
	}

}
