package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ChatVo;
import com.google.gson.Gson;

@RestController
public class ChatController {

	
	
	
	@RequestMapping("/chatInsert")
	public String chatInsert(ChatVo c) {
		String str = "ok";
		DBManager.insertChat(c);
		return str;
	}
	
	@RequestMapping(value = "/chatList", produces = "application/json;charset=UTF-8")
	public String chatList() {
		String str= "";
	return (new Gson()).toJson(DBManager.listChat()  );	
	}
}
