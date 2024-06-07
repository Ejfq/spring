package com.yedam.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter //내부값 수정안하기 때문에
public class LoginUserVO implements UserDetails{
	
	
	private UserVO userVO;
	
	public LoginUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	@Override
	// Collection > List 와 Set의 최상위 인터페이스
	public Collection<? extends GrantedAuthority> getAuthorities() { //문자열을 권한으로 인식할 수 있도록 한번 감싼다
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority(userVO.getRoleName()));
		return auths;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userVO.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userVO.getLoginId();
	}

	@Override
	public boolean isAccountNonExpired() { //계정 만료 여부
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { //계정 잠금 여부
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //계정 패스워드 만료 여부
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() { //계정 사용여부
		// TODO Auto-generated method stub
		return true;
	} //UserVO 감싸는 형태
	
}
