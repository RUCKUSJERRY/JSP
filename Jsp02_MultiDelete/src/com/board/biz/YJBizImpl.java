package com.board.biz;

import java.util.List;

import com.board.dao.YJDao;
import com.board.dao.YJDaoImpl;
import com.board.dto.YJDto;

public class YJBizImpl implements YJBiz {

	private YJDao dao = new YJDaoImpl();
	
	@Override
	public List<YJDto> selectList() {
		return dao.selectList();
	}

	@Override
	public YJDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(YJDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(YJDto dto) {
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
