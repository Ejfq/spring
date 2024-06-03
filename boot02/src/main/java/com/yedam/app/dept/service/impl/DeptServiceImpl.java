package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

public class DeptServiceImpl implements DeptService{
	@Autowired
	DeptMapper deptMapper;

	@Override
	public List<DeptVO> deptList() {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptAll();
	}

	@Override
	public DeptVO deptInfo(DeptVO deptVO) {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptInfo(deptVO);
	}

	@Override
	public int deptInsert(DeptVO deptVO) {
		// TODO Auto-generated method stub
		int result = deptMapper.insertDeptInfo(deptVO);
		return result == 1 ? deptVO.getDepartmentId;
	}

	@Override
	public Map<String, Object> deptUpdate(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		boolean inSuccessed = false;
		
		int result = deptMapper.updateDeptInfo(deptVO.getDepartmentId(), deptVO);
		
		if(result == 1 ) {
			inSuccessed = true;
		}
		
		map.put("result", inSuccessed);
		map.put("target", deptVO);
		return map;
	}

	@Override
	public Map<String, Object> deptDelete(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		
		int result = deptMapper.deleteDeptInfo(deptVO.getDepartmentId());
		
		if(result == 1) {
			map.put("departmentId", deptVO.getDepartmentId());
		return map;
	}
	
	
}