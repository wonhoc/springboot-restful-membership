package com.example.service;

import java.util.Map;

import com.example.vo.MemberVO;

public interface MemberService {
	void insertMember(MemberVO member);
	void selectAllMembers(Map map);
	void selectMember(Map map);
	void updateMember(MemberVO member);
	void deleteMember(String userid);
}
