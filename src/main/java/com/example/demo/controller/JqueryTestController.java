package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBManager;
import com.example.demo.vo.JqueryTestVo;
import com.google.gson.Gson;

@RestController
public class JqueryTestController {

	@RequestMapping("/jquerytestInsert")
	public String jquerytestInsert(JqueryTestVo j) {
		String str="ok";
		DBManager.insertJquery(j);
		return str;
	}
	
	
	@RequestMapping(value = "/jquerytestList", produces = "application/json;charset=UTF-8")
	public String jquerytestList() {
		String str="";
		return (new Gson()).toJson(DBManager.listJqueryTest());
		
	}
}
