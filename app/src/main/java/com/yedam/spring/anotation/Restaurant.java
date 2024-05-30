package com.yedam.spring.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	private Chef chef;
	

//	Restaurant(Chef chef){
//		this.chef = chef;
//	}
	
	@Autowired
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}

