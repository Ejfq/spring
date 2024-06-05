package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest
public class TestExample {
	@Autowired
	AaaService aaaService;
	
	@Test
	public void aaaInsert() {
		aaaService.insert();
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void testEncoder() {
		String password = "1234"; // 사용자가 입력
		String password2 = "1234";
		
		//DB에 저장된 암호화된 비밀번호
		String enPwd = passwordEncoder.encode(password);
		String enPwd2 = passwordEncoder.encode(password2);
		System.out.println("enPwd : " + enPwd);
		System.out.println("enPwd2 : " + enPwd2);
		
		// 2개가 같은 지 확인
		boolean matchResult = passwordEncoder.matches(password, enPwd);
		System.out.println("match : " + matchResult);
	}
	
}
