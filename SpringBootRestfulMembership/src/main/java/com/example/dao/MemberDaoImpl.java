package com.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void create(MemberVO member) {
		this.sqlSession.insert("Member.insert", member);
	}

	@Override
	public void readAll(Map map) {
		List<MemberVO> list = this.sqlSession.selectList("Member.selectAll");
		map.put("results", list);
	}

	@Override
	public void read(Map map) {
		MemberVO memberVO = this.sqlSession.selectOne("Member.select", (String)map.get("userid"));
		map.put("result", memberVO);
	}

	@Override
	public void update(MemberVO member) {
		this.sqlSession.update("Member.update", member);
	}

	@Override
	public void delete(String userid) {
		this.sqlSession.delete("Member.delete", userid);
	}

}
