package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.emp.service.EmpVO;
@Mapper
public interface EmpMapper {
	//DAO - Data Accept Object 를 위한 Interface
	
	// 전체조회 - SELECT문, 조건X, 결과가 여러건
	public List<EmpVO> slectEmpAll();
	
	// 단건조회
	// 등록
	// 수정
	// 삭제
	
	
}
