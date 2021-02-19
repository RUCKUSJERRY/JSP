package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.mvc.db.JDBCTemplate.*;

import com.mvc.dto.MVCDto;

public class MVCDaoImpl implements MVCDao {

	@Override
	public List<MVCDto> selectList() {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MVCDto> list = new ArrayList<MVCDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. query 준비" + SELECT_LIST_SQL);
			rs = pstm.executeQuery();
			System.out.println("4. 쿼리 실행 및 리턴");
			while(rs.next()) {
				
				MVCDto dto = new MVCDto();
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
			close(pstm);
			close(rs);
			close(con);
			System.out.println("5. DB 종료");
		}

		
		return list;
	}

	@Override
	public MVCDto selectOne(int seq) {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		MVCDto dto = new MVCDto();
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			System.out.println("3. query 준비 " + SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstm);
			close(rs);
			close(con);
			System.out.println("5. DB 종료");
		}
		
		return dto;
	}

	@Override
	public int insert(MVCDto dto) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			System.out.println("3. query 준비 " + INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
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
			System.out.println("5. DB 종료");
		}

		return res;
	}

	@Override
	public int update(MVCDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			System.out.println("3. query 준비 " + UPDATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
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
			System.out.println("5. DB 종료");
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
			System.out.println("3. query 준비 " + DELETE_SQL);
			pstm.setInt(1, seq);
			
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
			System.out.println("5. DB 종료");
		}
		
		return res;
	}

	@Override
	public int muldel(String[] seq) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		int [] cnt;
		
		
			try {
				pstm = con.prepareStatement(DELETE_SQL);
				
				for (int i = 0; i < seq.length; i++) {
					pstm.setString(1, seq[i]);
					pstm.addBatch();
					System.out.println("3. query 준비 " + DELETE_SQL + "(삭제할 번호 : " + seq[i] + ")");
				}
				
				cnt = pstm.executeBatch();
				System.out.println("4. query 실행 및 리턴");
				for (int i = 0; i < cnt.length; i++) {
					if (cnt[i] == -2) {
						res++;
					}
				}
				
				if (res == seq.length) {
					commit(con);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstm);
				close(con);
				System.out.println("5. DB 종료");
			}

		return res;
	}

}
