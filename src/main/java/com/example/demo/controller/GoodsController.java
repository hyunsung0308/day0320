package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GoodsDao;
import com.example.demo.db.DBManager;
import com.example.demo.vo.CartVo;
import com.example.demo.vo.MemberVo;
import com.google.gson.Gson;

@RestController
public class GoodsController {
	
	@Autowired
	private GoodsDao dao;
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}


	@RequestMapping(value = "/goodsList",produces = "application/json;charset=UTF-8")
	public String goodsList() {
		return (new Gson()).toJson(dao.listAll());
	}
	@RequestMapping("/insertCart")
	public String insertCart(CartVo c) {
		String str="ok";
		DBManager.insertCart(c);
		return str;
	}
	
	@RequestMapping("/login")
	public String login(MemberVo m) {
		String str="no";
		MemberVo r = DBManager.getMember(m);
		if (r != null) {
			System.out.println("로그인 성공");
			str = m.getId();
		}
		else {
			System.out.println("로그인 실패");
		}
		System.out.println("결과"+ str);
		return str;
	}
	
}
