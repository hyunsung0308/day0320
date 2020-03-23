package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CartVo;
import com.example.demo.vo.ChatVo;
import com.example.demo.vo.GoodsVo;
import com.example.demo.vo.JqueryTestVo;
import com.example.demo.vo.MemberVo;

public class DBManager {

	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
	public static int insertJquery(JqueryTestVo j) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("jquerytest.insert", j);
		session.close();
		return re;
	}
	public static List<JqueryTestVo> listJqueryTest(){
		SqlSession session = factory.openSession();
		List<JqueryTestVo> list = session.selectList("jquerytest.selectAll");
		session.close();
		return list;
	}
	public static int insertChat(ChatVo c) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("chat.insert",c);
		session.close();
		return re;
	}
	
	public static List<ChatVo> listChat(){
		SqlSession session = factory.openSession();
		List<ChatVo> list = session.selectList("chat.selectAll");
		session.close();
		return list;
	}
	
		public static List<GoodsVo> listAll(){
			SqlSession session = factory.openSession();
			List<GoodsVo> list = session.selectList("goods.selectAll");
			session.close();
			return list;
		}
		
	public static int insertCart(CartVo c) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("cart.insert", c);
		session.close();
		return re;
	}
	
	public static MemberVo getMember(MemberVo m) {
		SqlSession session = factory.openSession();
		MemberVo mv = session.selectOne("member.login", m);
		session.close();
		return mv;
	}
}
