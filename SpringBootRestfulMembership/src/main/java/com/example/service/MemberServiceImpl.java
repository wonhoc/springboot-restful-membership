package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDao;
import com.example.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public void insertMember(MemberVO member) {
		this.memberDao.create(member);
	}

	@Override
	public void selectAllMembers(Map map) {
		this.memberDao.readAll(map);
	}

	@Override
	public void selectMember(Map map) {
		this.memberDao.read(map);
	}

	@Override
	public void updateMember(MemberVO member) {
		this.memberDao.update(member);
	}

	@Override
	public void deleteMember(String userid) {
		this.memberDao.delete(userid);
	}

}
