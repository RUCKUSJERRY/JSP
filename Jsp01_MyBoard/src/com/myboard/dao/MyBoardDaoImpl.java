package com.myboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.board.db.JDBCTemplate.*;
import com.myboard.dto.MyBoardDto;

public class MyBoardDaoImpl implements MyBoardDao {

	@Override
	public List<MyBoardDto> selectList() {
		Connection con = getConnection();
	
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		try {
			MyBoardDto dto = new MyBoardDto();
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			// 3. query 준비
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				// 4. 쿼리 실행 및 리턴
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			// 5. db 종료
			close(rs);
			close(pstm);
			close(con);
		}
		return list;
	}

	@Override
	public MyBoardDto selectOne(MyBoardDto dto) {
		
		Connection con = getConnection();
		return null;
	}

	@Override
	public int insert(MyBoardDto dto) {
		Connection con = getConnection();
		return 0;
	}

	@Override
	public int update(int seq) {
		Connection con = getConnection();
		return 0;
	}

	@Override
	public int delete(int seq) {
		Connection con = getConnection();
		return 0;
	}

}
