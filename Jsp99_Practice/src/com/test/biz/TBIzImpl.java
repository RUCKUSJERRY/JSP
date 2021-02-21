package com.test.biz;

import java.util.List;

import com.test.dao.TDao;
import com.test.dto.TDaoImpl;
import com.test.dto.TDto;

public class TBIzImpl implements TBiz {

	private TDao dao = new TDaoImpl();
	
	@Override
	public TDto loginUser(String id, String pw) {
		return dao.loginUser(id, pw);
	}
	
	@Override
	public List<TDto> selectList() {
		return dao.selectList();
	}

}
