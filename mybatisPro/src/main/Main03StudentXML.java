package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.Student;
import util.MybatisConnection;

public class Main03StudentXML {

	public static void main(String[] args) {
		String namespace = "xml.student.";
		SqlSession session = MybatisConnection.getConnection();
		System.out.println("select===");
		List<Student> li = session.selectList(namespace + "select");
		print(li);

		Student st = li.get(0);
		st.setStudno(1111);
		st.setName("새로운");
		st.setGrade(1);
		st.setId("kic01");
		st.setJumin("1111111111");
		st.setMajor1(101);
		int num = session.insert(namespace + "insertStudent", st);
		System.out.println(num);

		System.out.println("select====");
		li = session.selectList(namespace + "select");
		print(li);

		// insertStudent

		System.out.println("update =========");
		st = new Student();
		st.setGrade(2);
		st.setWeight(60);
		st.setHeight(80);
		st.setProfno(2222);
		st.setStudno(1111);
		num = session.insert(namespace + "update", st);
		li = session.selectList(namespace + "select");
		print(li);

		System.out.println("delete =========");
		num = session.delete(namespace + "delete", 1111);
		li = session.selectList(namespace + "selectRMap");
		print(li);

		System.out.println("selectIf==========");
		Map map = new HashMap();
//		map.put("grade", 2); 
		map.put("height", 180); 
		li = session.selectList(namespace + "selectIf", map);
		print(li);

//		Map map = new HashMap();
		System.out.println("selectChoose =========");
		map.clear();
		map.put("height", 180);
		li = session.selectList(namespace + "selectChoose", map);
		print(li);

	}

	public static void print(List li) {
		for (Object o : li) {
			System.out.println(o);
		}
	}
}
