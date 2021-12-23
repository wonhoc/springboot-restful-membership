package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {
	@Autowired
	private MemberService memberService;

	@PostMapping("register")
	public  Map register(@RequestBody MemberVO member) {
		this.memberService.insertMember(member);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}

	@GetMapping("members")
	public Map members() {
		Map<String, Object> map = new HashMap<String, Object>();
		this.memberService.selectAllMembers(map);
		List<MemberVO> list = (List<MemberVO>) map.get("results");
		map.remove("results");
		map.put("code", "success");
		map.put("data", list);
		return map;
	}

	@GetMapping("members/{userid}")
	public Map display(@PathVariable String userid, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		this.memberService.selectMember(map);
		MemberVO member = (MemberVO) map.get("result");
		map.remove("result");
		map.remove("userid");
		map.put("data", member);
		return map;
	}

	@PutMapping("members") // 게시글 수정
	public Map update(@RequestBody MemberVO member) {
		this.memberService.updateMember(member);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}

	@DeleteMapping("members/{userid}")
	public Map delete(@PathVariable String userid) {
		this.memberService.deleteMember(userid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		return map;
	}
}