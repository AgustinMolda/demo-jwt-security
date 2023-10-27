package com.demo.jwt.auth;

import org.springframework.stereotype.Service;

import com.demo.jwt.auth.user.Role;
import com.demo.jwt.auth.user.User;
import com.demo.jwt.auth.user.UserRepository;
import com.demo.jwt.demo.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
	private final JwtService jwtService;
	
	public AuthResponse login (LoginRequest request){
		return null;
	}
	
	public AuthResponse register (RegisterRequest request){
		User user = User.builder()
				.username(request.getUsername())
				.password(request.getPassword())
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.country(request.getCountry())
				.role(Role.USER)
				.build();
			
			this.userRepository.save(user);
			
			return AuthResponse.builder()
					.token(jwtService.getToken(user))
					.build();
		
	}
}
