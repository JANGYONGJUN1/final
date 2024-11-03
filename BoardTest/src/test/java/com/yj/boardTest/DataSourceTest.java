package com.yj.boardTest;
import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DataSourceTest {
	@Autowired
	DataSource ds;
	
	// 단위테스트 (junit모듈 사용. 스프링 프로젝트에 기본 장착. 4.12) --> 메서드 단위로 테스트 실행 가능.(Tomcat X = 빠름)
	// 단위테스트 할 메서드 바로 위에 @Test 애노테이션 붙여주세요.
	@Test
	public void testConnect() throws Exception {
		Connection conn = ds.getConnection();
		System.out.println("DB 접속됨.");
		conn.close();
	}
}

















