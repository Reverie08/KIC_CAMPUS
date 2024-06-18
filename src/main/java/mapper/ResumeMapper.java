package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Resume;

public interface ResumeMapper {
	
	// 이력서의 다음 ID를 가져오기
	@Select("select resumeidseq.nextval from dual")
	public int selectResumeId();
	
	// 이력서 1개 가져오기
	@Select("select * from resume where resumeid = #{resumeId}")
	public Resume getResume(int resumeId);
	
	// 회원이 작성한 이력서 목록 가져오기
	@Select("select * from resume where memberid=#{memberId}")
	public List<Resume> getMemberReumeList(String memberId);
	
	// 기업이 작성한 이력서 목록 가져오기
	@Select("select * from resume where businessid=#{businessId}")
	public List<Resume> getBusinessReumeList(int businessId);
	
	// 공고에 지원한 이력서 목록 가져오기
	@Select("select * from resume where annoid=#{annoId}")
	public List<Resume> getAnnoReumeList(int annoId);
	
	@Select("select profileimage from resume where memberid=#{memberId}")
	public String getProfileImage(String memberId );
	
	// 이력서 삽입
	@Insert("insert into resume values(#{resumeId},#{resumeTitle},#{profileImage},"
			+ "#{name},#{birth},#{phone},#{email},sysdate,#{selfInfo},#{certification},#{language},"
			+ "#{address},#{columnStage},#{evaluStage},#{resumeScore},#{memberId},#{businessId},#{annoId})")
	public int insertResume(Resume resume);
	
	// 이력서 삭제
	@Delete("delete from resume where resumeid = #{resumeId}")
	public int deleteResume(int resumeId);
}
