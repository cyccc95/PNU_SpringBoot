package edu.pnu.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// MemberRepository로 회원 정보를 조회하여
		// UserDetails 타입의 객체로 리턴한다.
//		return null;
		
		Optional<Member> optional = memberRepo.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username + "사용자 없음");
		} else {
			Member member = optional.get();
			return new SecurityUser(member);
		}
		
		// SecurityUser 클래스를 추가로 안만드려면
		// else 이후를 없애고
//		Member m = optional.get();
//		return new User(m.getId(), m.getPassword(), AuthorityUtils.createAuthorityList(m.getRole().toString()));
//		return User.builder()
//					.username(m.getId())
//					.password(m.getPassword())
//					.roles(m.getRole().toString())
//					.build();
	}
}
