package com.twoplus.apartfriend.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.twoplus.apartfriend.provider.CustomerProvider;
import com.twoplus.apartfriend.vo.UserVO;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private CustomerProvider customerProvider;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserVO memberVo = customerProvider.getAuth(username);
//		SecurityUser securityUser = new SecurityUser();
//		
//		if( memberVo != null ) {
//			// mock data
//			//String role = userVo.getRole();
//			if(!memberVo.getId().equals("admin")) {
//				String role = "ROLE_USER";
//	
//				securityUser.setNo(memberVo.getNo());
//				securityUser.setName(memberVo.getName());         // biz data  
//				securityUser.setBirthDate(memberVo.getBirthDate()); // biz data  				
//				securityUser.setGender(memberVo.getGender()); // biz data  
//				securityUser.setId(memberVo.getId()); // biz data  
//				securityUser.setEmail(memberVo.getEmail()); // biz data  
//				securityUser.setTel(memberVo.getTel()); // biz data  
//				securityUser.setRegdate(memberVo.getRegdate()); // biz data  
//				
//				//////////////////////////////////////////////////////////
//				
//				securityUser.setUsername(memberVo.getId());    // principal
//				securityUser.setPassword(memberVo.getPassword()); // credential
//			
//				securityUser.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(role)));	
//				
//				//System.out.println("=============비회원 장바구니 코드: "+securityUser.getBasketCode());
//				
//				// 로그인 시, 비회원 장바구니 코드를 회원의 장바구니 코드로 변경
//				//basketProvider.updateToLoginBasket(securityUser.getNo(),securityUser.getBasketCode());
//				//securityUser.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userVo.getRole())));
//			} else if(memberVo.getId().equals("admin")){
//				String role = "ROLE_ADMIN";
//				
//				securityUser.setNo(memberVo.getNo());
//				securityUser.setName(memberVo.getName());         // biz data  
//				securityUser.setBirthDate(memberVo.getBirthDate()); // biz data  				
//				securityUser.setGender(memberVo.getGender()); // biz data  
//				securityUser.setId(memberVo.getId()); // biz data  
//				securityUser.setRegdate(memberVo.getRegdate()); // biz data  
//				
//				//////////////////////////////////////////////////////////
//				
//				securityUser.setUsername(memberVo.getId());    // principal
//				securityUser.setPassword(memberVo.getPassword()); // credential
//			
//				
//				securityUser.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(role)));	
//			}
//		}
		
		//UserVO securityUser = new UserVO();
		SecurityUser securityUser = new SecurityUser();
		securityUser.setId("skok1025");
		securityUser.setId("addr");
		
		//return new User();
		return securityUser;
	}
}