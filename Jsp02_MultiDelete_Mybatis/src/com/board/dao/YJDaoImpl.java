package com.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.board.db.SqlMapConfig;
import com.board.dto.YJDto;

public class YJDaoImpl extends SqlMapConfig implements YJDao {
	
	private String namespace = "com.muldel.mapper.";
	
	@Override
	public List<YJDto> selectList() {
		
		SqlSession session = null;
		List<YJDto> list = new ArrayList<YJDto>();
		try {
				
		session = getSqlSessionFactory().openSession(false);
		list = session.selectList(namespace +"selectList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		
		return list;
	}

	@Override
	public YJDto selectOne(int seq) {
		
		SqlSession session = null;
		YJDto dto = new YJDto();
		
		try {
		session = getSqlSessionFactory().openSession();
		dto = session.selectOne(namespace+"selectOne", seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}

	@Override
	public int insert(YJDto dto) {

		return 0;
	}

	@Override
	public int update(YJDto dto) {
	
		return 0;	
	}

	@Override
	public int delete(int seq) {
		
		return 0;
		
		
	}

	@Override
	public int muldel(String[] seq) {
		
		int count = 0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seq);
		
		try (SqlSession session = getSqlSessionFactory().openSession(false);){
			count = session.delete(namespace+"multiDelete", map);
			if(count == seq.length) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return count;

	}

}
