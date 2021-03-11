package com.board.db;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

		private SqlSessionFactory sqlSessionFactory;
		
		public SqlSessionFactory getSqlSessionFactory() {
			
			// 경로일 때는 /
			String resource = "com/board/db/mybatis-config.xml";
			
			try {
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
				inputStream.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return sqlSessionFactory;
			
		}
	
}
