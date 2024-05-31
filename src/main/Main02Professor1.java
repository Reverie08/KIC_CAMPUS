package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.Professor;
import util.MybatisConnection;

public class Main02Professor1 {
	
	public static void main(String[] args) {
		SqlSession session = MybatisConnection.getConnection();
		String namespace = "xml.professor1.";
		System.out.println("count====");
		int num = session.selectOne(namespace+"count");
		System.out.println(num);
		
		System.out.println("list====");
		List<Professor> li = session.selectList(namespace+"list");
//		List<KicMember> li1 = session.selectList(namespace+"list");
		print(li);
		
		System.out.println("selectdeptno===");
		li = session.selectList(namespace+"selectdeptno",103);
		print(li);
		
		Map map = new HashMap();
		map.put("name", "명");
		map.put("position", "정교수");
		System.out.println("selectnameposition===");
		li = session.selectList(namespace+"selectnameposition",map);
		print(li);
		
		List<Integer> datas = Arrays.asList(101, 102);
		map.clear();
		map.put("position", "정교수");
		map.put("datas", datas); 
		
		System.out.println("select<scripte>=======");
		li = session.selectList(namespace+"select",map);
		print(li);
		
		map.clear();
		System.out.println("select all=======");
		li = session.selectList(namespace+"select",map);
		print(li);
		
		Professor p = li.get(0);
		p.setName("새로운");
		p.setPosition("임시직");
		num = session.insert(namespace+"insertProfessor",p);
		System.out.println(num+"개 저장");
		
		map.clear();
		System.out.println("select all=======");
		li = session.selectList(namespace+"select",map);
		print(li);
		
		
	}
	public static void print(List li) {
		for(Object o : li) {
			System.out.println(o);
		}
	}
}
