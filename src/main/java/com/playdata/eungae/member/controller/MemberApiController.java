package com.playdata.eungae.member.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.playdata.eungae.member.dto.RequestFavoriesDto;
import com.playdata.eungae.member.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/my")
public class MemberApiController {

	private final MemberService memberService;

	@PostMapping("/hospital")
	public ResponseEntity appendFavorites(@RequestBody @Valid RequestFavoriesDto requestFavoriesDto) {
		memberService.appendFavorites(requestFavoriesDto);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}

	@PatchMapping("/hospital")
	public ResponseEntity removeFavorites(@RequestBody @Valid RequestFavoriesDto requestFavoriesDto) {
		memberService.removeFavorites(requestFavoriesDto);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}

}
