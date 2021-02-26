package com.mvc.biz;

import java.sql.Connection;
import java.util.List;

import static com.mvc.db.JDBCTemplate.*;
import com.mvc.dao.MVCDao;
import com.mvc.dao.MVCDaoImpl;
import com.mvc.dto.MVCDto;

public class MVCBizImpl implements MVCBiz {

	private MVCDao dao = new MVCDaoImpl();
	
	@Override
	public List<MVCDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MVCDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(MVCDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MVCDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

	@Override
	public int muldel(String[] seq) {
		return dao.muldel(seq);
	}

}
