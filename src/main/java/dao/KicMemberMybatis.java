package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mapper.MemberAnno;
import model.KicMember;
import util.MybatisConnection;

public class KicMemberMybatis {

	SqlSession session = MybatisConnection.getConnection();

	public KicMember getMember(String id) {
		KicMember mem = session.getMapper(MemberAnno.class).getMember(id);
		return mem;
	}

	public List<KicMember> memberList() {
		List<KicMember> li = session.getMapper(MemberAnno.class).memberList();
		return li;
	}

	public int insertMember(KicMember kic) {
		int num = session.getMapper(MemberAnno.class).insertMember(kic);
		session.commit();
		return num;
	}

}
