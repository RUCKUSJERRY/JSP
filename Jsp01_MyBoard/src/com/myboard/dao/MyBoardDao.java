package com.myboard.dao;

import static com.myboard.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myboard.dto.MyBoardDto;


public class MyBoardDao {
	
	public List<MyBoardDto> selectList() {
		
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE "
				+ " FROM MYBOARD "
				+ " ORDER BY MYNO DESC ";
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		try {
			stmt = con.createStatement();
			System.out.println("3. query 준비 " + sql);
			rs = stmt.executeQuery(sql);
			System.out.println("4. query 실행 및 리턴 ");
			
			while(rs.next()) {
				MyBoardDto temp = new MyBoardDto();
				temp.setMyno(rs.getInt(1));
				temp.setMyname(rs.getString(2));
				temp.setMytitle(rs.getNString(3));
				temp.setMycontent(rs.getString(4));
				temp.setDate(rs.getDate(5));
				
				list.add(temp);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("5. DB 종료 ");
		}
		
		
		return list;
		
	}
	
	public MyBoardDto selectOne(int myno) {
		
		Connection con = getConnection();
		
		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE "
				+ " FROM MYBOARD "
				+ " WHERE MYNO = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyBoardDto dto = new MyBoardDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getNString(3));
				dto.setMycontent(rs.getString(4));
				dto.setDate(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. DB 종료 ");
		}
		
		
		return dto;
		
	}
	
	public int insert(MyBoardDto dto) {
		
		Connection con = getConnection();
		
		String sql = " INSERT INTO MYBOARD "
				   + " VALUES (MYBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			System.out.println("3. query 준비 : " + sql);

			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		
		
		return res;
	}
	
	public int update(MyBoardDto dto) {
		
		Connection con = getConnection();
		
		String sql = " UPDATE MYBOARD "
				   + " SET MYNAME = ? , MYTITLE = ? , MYCONTENT = ? , MYDATE = SYSDATE "
				   + " WHERE MYNO = ? ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			pstm.setInt(4, dto.getMyno());
			System.out.println("3. query 준비 : " + sql);

			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		
		
		return res;
	}
	
	public int delete(int mno) {
		
		Connection con = getConnection();
		String sql = " DELETE FROM MYBOARD " 
				   + " WHERE MYNO = ? ";

		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, mno);
			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}
	
}
