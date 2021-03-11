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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.close();
		
		System.out.println(list.size());
		
		return list;
	}

	@Override
	public MyBoardDto selectOne(int seq) {
		
		SqlSession session = null;
		
		MyBoardDto dto = new MyBoardDto();
		
	try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne("boardmapper.selectOne", seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return dto;
	}

	@Override
	public int insert(MyBoardDto dto) {
		
		int res = 0;
		
		// try with resources
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.insert("boardmapper.insert", dto);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return res;
	}

	@Override
	public int update(MyBoardDto dto) {
		
	
		return 0;
	}

	@Override
	public int delete(int seq) {
		return 0;
	}

}
