package com.playdata.eungae.member.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.playdata.eungae.member.domain.Member;
import com.playdata.eungae.member.dto.SignUpMemberRequestDto;
import com.playdata.eungae.member.repository.MemberRepository;

@SpringBootTest
class MemberServiceTest {

	@Autowired
	MemberService memberService;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	// @BeforeEach
	public void createMember() {
		SignUpMemberRequestDto dto = new SignUpMemberRequestDto();
		dto.setName("김수용");
		dto.setEmail("test@gmail.com");
		dto.setAddress("경기도 안양시 만안구");
		dto.setAddressDetail("소곡로 26번길");
		dto.setZipCode("11033");
		dto.setBirthDate("19991213");
		dto.setPhoneNumber("01032626945");
		Member member1 = SignUpMemberRequestDto.toEntity(dto);

		memberService.signUp(member1);
	}

	@Rollback(value = false)
	@DisplayName("signUp: 회원가입을 성공한다.")
	@Test
	public void signUp() throws Exception {
		//Given
		SignUpMemberRequestDto dto = new SignUpMemberRequestDto();
		dto.setName("김수용");
		dto.setEmail("test@gmail.com");
		dto.setPassword("12345");
		dto.setAddress("경기도 안양시 만안구");
		dto.setAddressDetail("소곡로 26번길");
		dto.setZipCode("11033");
		dto.setBirthDate("19991213");
		dto.setPhoneNumber("01032626945");
		Member member = SignUpMemberRequestDto.toEntity(dto);

		//When
		memberService.signUp(member);

		//Then
		assertThat(dto.getName()).isEqualTo(member.getName());
		System.out.println(member.getPassword());
	}

}