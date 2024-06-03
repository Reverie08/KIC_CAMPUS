package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.ProfessorAnno;
import model.Professor;
import util.MybatisConnection;

public class Main04ProfessorAnno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisConnection.getConnection();

		System.out.println("count========================");
		int num = session.getMapper(ProfessorAnno.class).count();
		System.out.println(num);

		System.out.println("list========================");
		List<Professor> li = session.getMapper(ProfessorAnno.class).list();
		print(li);

		System.out.println("selectdeptno========================");
		li = session.getMapper(ProfessorAnno.class).selectdeptno(103);
		print(li);

		Map map = new HashMap();
		map.put("name", "명");
		map.put("position", "정교수");
		System.out.println("selectnameposition========================");
		li = session.getMapper(ProfessorAnno.class).selectnameposition(map);
		print(li);

		List<Integer> datas = Arrays.asList(101, 102);
		map.clear();
		map.put("position", "정교수");
		map.put("datas", datas);

		System.out.println("select<script>========================");
		li = session.getMapper(ProfessorAnno.class).select(map);
		print(li);

		map.clear();
		System.out.println("select all========================");
		li = session.getMapper(ProfessorAnno.class).select(map);
		print(li);

		Professor p = li.get(0);
		p.setName("새로운");
		p.setPosition("임시직");
		num = session.getMapper(ProfessorAnno.class).insertProfessor(p);
		System.out.println(num+"개 저장");
		
		map.clear();
		System.out.println("select all=======");
		li = session.getMapper(ProfessorAnno.class).select(map);
		print(li);
	}

	public static void print(List li) {
		for (Object o : li) {
			System.out.println(o);
		}
	}
}
