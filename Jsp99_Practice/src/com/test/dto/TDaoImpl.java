package com.test.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.test.db.JDBCTemplate.*;
import com.test.dao.TDao;

public class TDaoImpl implements TDao {

	@Override
	public TDto loginUser(String id, String pw) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		TDto dto = null;
		
		try {
			pstm = con.prepareStatement(LOGIN_USER);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			System.out.println("3. query 준비 " + LOGIN_USER);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			while(rs.next()) {
				dto = new TDto();
				dto.setSeq(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setId(rs.getString(3));
				dto.setPw(rs.getString(4));
				dto.setAddr(rs.getString(5));
				dto.setPhone(rs.getString(6));
				dto.setEmail(rs.getString(7));
				dto.setRole(rs.getString(8));
				dto.setMarrige(rs.getString(9));
				dto.setGender(rs.getString(10));
				dto.setEnabled(rs.getString(11));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, rs, pstm);
			System.out.println("5. DB 종료");
		}
		
		return dto;
	}
	
	@Override
	public List<TDto> selectList() {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = con.prepareStatement(SELECT_ALL_BOARD);
			System.out.println("3. query 준비 " + SELECT_ALL_BOARD);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			while(rs.next()) {
				TDto dto = new TDto();
				
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		TDto dto = null;
			
		
		return null;
	}

}
