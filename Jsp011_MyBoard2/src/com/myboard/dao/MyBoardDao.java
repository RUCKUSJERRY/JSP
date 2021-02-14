package com.myboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.board.db.JDBCTemplate.*;
import com.myboard.dto.MyBoardDto;

public class MyBoardDao {

	public List<MyBoardDto> selectList() {
		Connection con = getConnection();
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
	               + " FROM MYBOARD ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		try {
			
			pstm = con.prepareStatement(sql);
			// 3. query 준비
			System.out.println("3. query 준비");
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				// 4. 쿼리 실행 및 리턴
				MyBoardDto dto = new MyBoardDto();
				System.out.println("4. 쿼리 실행 및 리턴");
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
			System.out.println("5. db 종료");
		}
		return list;
	}

	public MyBoardDto selectOne(int seq) {
		
		Connection con = getConnection();
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				  + " FROM MYBOARD "
			      + " WHERE SEQ = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;		
		MyBoardDto temp = new MyBoardDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			rs = pstm.executeQuery();
			
			
			
			while(rs.next()) {

				temp.setSeq(rs.getInt(1));
				temp.setWriter(rs.getString(2));
				temp.setTitle(rs.getString(3));
				temp.setContent(rs.getString(4));

				
			}
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		
		return temp;
	}

	public int insert(MyBoardDto dto) {
		Connection con = getConnection();
		return 0;
	}

	public int update(int seq) {
		Connection con = getConnection();
		return 0;
	}

	public int delete(int seq) {
		Connection con = getConnection();
		return 0;
	}

}
