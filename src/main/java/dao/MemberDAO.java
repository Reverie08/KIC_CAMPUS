package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.MemberMapper;
import model.Member;
import util.MybatisConnection;
  
public class MemberDAO {
	
	SqlSession session = MybatisConnection.getConnection();
	
	// 회원 가입
	public int insertMember(Member mem) {
		int num = session.getMapper(MemberMapper.class).insertMember(mem);
		session.commit();
		return num;
	}
	
	// 회원 가져오기
	public Member getMember(String email) {
		Member mem = session.getMapper(MemberMapper.class).getMember(email);
		session.commit();
		return mem;
	}
	
	// 회원 리스트 가져오기 
	public List<Member> memberList(){
		List<Member> list = session.getMapper(MemberMapper.class).MemberList();
		return list;
	}
	
	// 회원 정보 수정하기
	public int updateMember(Member mem) {
		int num = session.getMapper(MemberMapper.class).updateMember(mem);
		session.commit();
		return num;
	}
	
	// 회원 비밀번호 수정하기
	public int changePw(String memberId, String chgpw) {
		Map map = new HashMap();
		map.put("memberId", memberId);
		map.put("chgpw", chgpw);
		int num = session.getMapper(MemberMapper.class).changePw(map);
		session.commit();
		return num;
	}

	// 회원 탈퇴하기
	public int deleteMember(String memberId) {
		int num = session.getMapper(MemberMapper.class).deleteMember(memberId);
		session.commit();
		return num;
	}
	
	// 회원 사진 삽입
	public int insertProfileImage(String profileImage, String memberId) {
		int num = session.getMapper(MemberMapper.class).insertProfileImage(profileImage, memberId);
		session.commit();
		return num;
	}
	
}
