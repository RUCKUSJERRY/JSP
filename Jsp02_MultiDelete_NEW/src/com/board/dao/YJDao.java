package com.board.dao;

import java.util.List;
import com.board.dto.YJDto;

public interface YJDao {

	String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
	                       + " FROM YJBOARD "
	                       + " ORDER BY SEQ DESC ";
	String SELECT_ONE_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
    					  + " FROM YJBOARD "
    					  + " WHERE SEQ = ? ";
	String INSERT_SQL = " INSERT INTO YJBOARD "
			          + " VALUES (YJBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
	String UPDATE_SQL = " UPDATE YJBOARD "
			          + " SET TITLE = ?, CONTENT = ? "
			          + " WHERE SEQ = ? ";
	String DELETE_SQL = " DELETE FROM YJBOARD "
			          + " WHERE SEQ = ? ";
	
	public List<YJDto> selectList();
	public YJDto selectOne(int seq);
	public int insert(YJDto dto);
	public int update(YJDto dto);
	public int delete(int seq);
	public int muldel(String []seq);
	
}
