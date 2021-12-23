package com.example.dao;

import java.util.Map;

import com.example.vo.MemberVO;

public interface MemberDao {
	void create(MemberVO member);
	void readAll(Map map);
	void read(Map map);
	void update(MemberVO member);
	void delete(String userid);
}
