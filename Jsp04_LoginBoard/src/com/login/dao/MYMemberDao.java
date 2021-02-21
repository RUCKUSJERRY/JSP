 package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static com.login.db.JDBCTemplate.*;
import com.login.dto.MYMemberDto;

public class MYMemberDao {

	/*
	 * 관리자(ADMIN) 기능
	 * 1. 회원 전체 정보 확인 (탈퇴한 회원도 포함)
	 * 2. 회원 전체 정보 확인 (MYENABLED = 'Y' -> 탈퇴안한 회원들의 정보)
	 * 3. 회원 등급 조정 (ADMIN <-> USER)
	 */
	
	// 1. 전체정보
	public List<MYMemberDto> selectAllUser() {
		return null;
	}
	
	// 2. 전체정보(탈퇴안한)
	
	public List<MYMemberDto> selectEnabledUser() {
		return null;
	}
	
	// 3. 회원 등급 조정
	public int updateRole(int myno, String myrole) {
		return 0;
	}
	
	// 4. 
	
	/*
	 * 사용자(USER) 기능
	 * 1. 로그인
	 * 3. 회원가입 <- 2. 아이디 중복체크
	 * 4. 내 정보 조회
	 * 5. 내 정보 수정
	 * 6. 회원 탈퇴 (delete 안쓸것! update : myenabled를 n으로 바꾸자.)
	 */
	
	// 1. 로그인
	public MYMemberDto login(String myid, String mypw) {
		
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " WHERE MYID = ? "
				   + " AND MYPW = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		// side effect
		MYMemberDto dto = null;
		
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, myid);
				pstm.setString(2, mypw);
				System.out.println("3. query 준비 " + sql);
				
				rs = pstm.executeQuery();
				System.out.println("4. query 실행 및 리턴");
				while(rs.next()) {
					dto = new MYMemberDto();
					dto.setMyno(rs.getInt(1));
					dto.setMyid(rs.getString(2));
					dto.setMypw(rs.getString(3));
					dto.setMyname(rs.getString(4));
					dto.setMyaddr(rs.getString(5));
					dto.setMyphone(rs.getString(6));
					dto.setMyemail(rs.getString(7));
					dto.setMyenabled(rs.getString(8));
					dto.setMyrole(rs.getString(9));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstm);
				close(con);
				System.out.println("5. db 종료");
				
			}
		
		return dto;
	}
	
	// 2. 중복체크
	public MYMemberDto idCheck(String myid) {
		return null;
	}
	
	// 3. 회원가입
	public int insertUser(MYMemberDto dto) {
		return 0;
	}
	
	// 4. 정보 조회
	public MYMemberDto selectUser(int myno) {
		return null;
	}
	
	// 5. 정보 수정
	public int updateUser(MYMemberDto dto) {
		return 0;
	}
	
	// 6. 회원 탈퇴 (update)
	public int deleteUser(int myno) {
		return 0;
	}
	
}
