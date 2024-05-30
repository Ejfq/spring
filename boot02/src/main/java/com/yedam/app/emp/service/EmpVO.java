package com.yedam.app.emp.service;

import java.sql.Date;

import lombok.Data;

@Data
public class EmpVO {
	private Integer employeeId; //PK 이거나 Not null 인 경우 Integer -> 공백처리 가능함
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	
	
}
