package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.KicMember;

public interface MemberAnno {
	
	@Select("select * from kicmember where id = #{id}")
	KicMember getMember(String id);
	
	@Select("select * from kicmember")
	List<KicMember> memberList();
	
	@Insert("insert into kicmember values (#{id}, #{pass}, #{name}, #{gender}, "
			+ "#{tel}, #{email}, #{picture}, sysdate)")
	public int insertMember(KicMember kic);
	
}
