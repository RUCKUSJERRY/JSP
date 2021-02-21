package com.test.dao;

import java.util.List;

import com.test.dto.TDto;

public interface TDao {

	/*
	 * 관리자(ADMIN) 기능
	 * 1. 회원 전체 정보 확인 (탈퇴한 회원도 포함)
	 * 2. 회원 전체 정보 확인 (MYENABLED = 'Y' -> 탈퇴안한 회원들의 정보)
	 * 3. 회원 등급 조정 (ADMIN <-> USER)
	 */
	
	/*
	 * 사용자(USER) 기능
	 * 1. 로그인
	 * 3. 회원가입 <- 2. 아이디 중복체크
	 * 4. 내 정보 조회
	 * 5. 내 정보 수정
	 * 6. 회원 탈퇴 (delete 안쓸것! update : myenabled를 n으로 바꾸자.)
	 */
	
	String SELECT_ALL_USER = "";
	String SELECT_ALL_USER_ENABLED = "";
	String UPDATE_ROLE = "";
	String LOGIN_USER = " SELECT SEQ, NAME, ID, PW, ADDR, PHONE, EMAIL, ROLE, MARRIGE, GENDER, ENABLED "
					  + " FROM TUSER "
					  + " WHERE ID = ? "
		 			  + " AND PW = ? ";
	String ID_CHECK_USER = "";
	String INSERT_USER = "";
	String UPDATE_USER = "";
	String DELETE_USER = "";
	
	String SELECT_ALL_BOARD = " SELECT SEQ, NAME, ID, TITLE, CONTENT, EMAIL, GENDER "
						    + " FROM TBOARD "
						    + " ORDER BY SEQ DESC ";
	String SELECT_ONE_BOARD = "";
	String INSERT_BOARD = "";
	String UPDATE_BOARD = "";
	String DELETE_BOARD = "";
	
	public TDto loginUser(String id, String pw);
	public List<TDto> selectList();
	
	
	
	
}
