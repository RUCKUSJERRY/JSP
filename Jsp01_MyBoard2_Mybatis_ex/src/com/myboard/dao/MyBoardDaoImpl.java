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
			
			pstm = con.prepareStatement(SELECT_LIST_SQL);
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

	@Override
	public MyBoardDto selectOne(int seq) {
		
		Connection con = getConnection();	
		PreparedStatement pstm = null;
		ResultSet rs = null;		
		MyBoardDto temp = new MyBoardDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			rs = pstm.executeQuery();
			
			while(rs.next()) {

				temp.setSeq(rs.getInt(1));
				temp.setWriter(rs.getString(2));
				temp.setTitle(rs.getString(3));
				temp.setContent(rs.getString(4));
				temp.setRegdate(rs.getDate(5));
				
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

	@Override
	public int insert(MyBoardDto dto) {
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			res = pstm.executeUpdate();
			
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}

	@Override
	public int update(MyBoardDto dto) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());	
			pstm.setString(3, dto.getContent());
			pstm.setInt(4, dto.getSeq());
			
			res = pstm.executeUpdate();
			
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		
		
		return res;
	}

	@Override
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, seq);
			res = pstm.executeUpdate();
			
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		
		return res;
	}

}
