package com.myboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.db.SqlMapConfig;
import com.myboard.dto.MyBoardDto;

public class MyBoardDaoImpl extends SqlMapConfig implements MyBoardDao {

	@Override
	public List<MyBoardDto> selectList() {
		
		SqlSession session = null;
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList("boardmapper.selectList");

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public MyBoardDto selectOne(int seq) {
		SqlSession session = null;
		MyBoardDto dto = new MyBoardDto();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne("boardmapper.selectOne", seq);

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(MyBoardDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
		session = getSqlSessionFactory().openSession(true);
		res = session.insert("boardmapper.insert", dto);
				
		session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(MyBoardDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
		session = getSqlSessionFactory().openSession(true);
		res = session.insert("boardmapper.update", dto);
				
		session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int seq) {
		SqlSession session = null;
		int res = 0;
		
		try {
		session = getSqlSessionFactory().openSession(true);
		res = session.insert("boardmapper.delete", seq);
				
		session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
