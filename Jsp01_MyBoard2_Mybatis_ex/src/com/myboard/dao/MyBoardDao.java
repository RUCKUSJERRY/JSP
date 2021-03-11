package com.myboard.dao;

import java.util.List;

import com.myboard.dto.MyBoardDto;

public interface MyBoardDao {
	
	String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
			               + " FROM MYBOARD ";
	String SELECT_ONE_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
						  + " FROM MYBOARD "
					      + " WHERE SEQ = ? ";
	String INSERT_SQL = " INSERT INTO MYBOARD "
			          + " VALUES (MYBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
	String UPDATE_SQL = " UPDATE MYBOARD " 
			          + " SET WRITER = ?, TITLE = ?, CONTENT = ? "
					  + " WHERE SEQ = ? ";
	String DELETE_SQL = " DELETE FROM MYBOARD "
					  + " WHERE SEQ = ? ";
	
	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(int seq);
	public int insert(MyBoardDto dto);
	public int update(MyBoardDto dto);
	public int delete(int seq);
	
}
