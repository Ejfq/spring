package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot02ApplicationTests {
	
	@Autowired
	EmpMapper empMapper;
	
	//@Test
	public void empList() {
		List<EmpVO> list = empMapper.selectEmpAll();
		assertTrue(!list.isEmpty());
//		for(EmpVO empVO : list) {
//			System.out.println(empVO);
//		}
	}
	
	//@Test
	public void empInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King" );
		System.out.println(findVO);
	}
	
	//@Test
	public void empInsert() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("HHOON");
		empVO.setEmail("asdf5@gmail.com");
		empVO.setJobId("IT_PROG");
			
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println(empVO.getEmployeeId());
		assertEquals(result,1);
	}
	
	//@Test
	public void empUpdate() {
		// 대상조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
		
		// 정보수정
		findVO.setLastName("Kang");
		int result = empMapper.updateEmpInfo(findVO.getEmployeeId(), findVO);
		assertEquals(result, 1);
	}
	
	@Test
	public void empDelete() {

		//삭제
		int result = empMapper.deleteEmpInfo(207);
		assertEquals(result, 1);
	}
}
