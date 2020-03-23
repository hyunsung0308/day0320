package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVo;
import com.example.demo.vo.MemberVo;

@Repository
public class GoodsDao {
	public List<GoodsVo> listAll(){
		return DBManager.listAll();
	}
	public MemberVo loginMember(MemberVo m) {
		return DBManager.getMember(m);
	}
}
