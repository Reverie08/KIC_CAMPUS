package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Resume;
import model.ResumeAnnoConnection;

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
	public List<Resume> getBusinessReumeList(String businessId);
	
	// 공고에 지원한 이력서 목록 가져오기
	@Select("select * from resume where annoid=#{annoId}")
	public List<Resume> getAnnoReumeList(int annoId);
	
	@Select("select profileimage from resume where memberid=#{memberId}")
	public String getProfileImage(String memberId );
	
	// 이력서 삽입
	@Insert("insert into resume values(#{resumeId},#{resumeTitle},#{profileImage},"
			+ "#{name},#{birth},#{phone},#{email},sysdate,#{selfInfo},#{certification},#{language},"
			+ "#{address},#{columnStage},#{evaluStage},#{resumeScore},#{memberId},#{businessId},#{isDefault})")
	public int insertResume(Resume resume);
	
	// 이력서 삭제
	@Delete("delete from resume where resumeid = #{resumeId}")
	public int deleteResume(int resumeId);

	
	// 공고에 이력서등록 -> 이력서에 공고ID 넣기
	@Update("insert into resume_anno_connect values(#{resumeId},#{annoId},sysdate,null)")
	public int intsertAnnoId(Map<String, Integer> map);

	
	@Select("select resumeid, annoid, to_char(resume_register_date,'YYYY-MM-DD PM HH:MI:SS')as resume_register_date from resume_anno_connect"
			+ " where annoid = #{annoId}")
	public List<ResumeAnnoConnection> selectResumeIdfromConnect(int annoId);
	
//	create table resume_anno_connect(
//		    resumeid   number,
//		    annoid   number,
//		    resume_register_date Date,
//		    resume_check_date Date
//		);
	
	
	
	// 회원이 등록한 이력서 갯수 세기
	@Select("select count(*) from resume where memberid = #{memberId}")
	public int getMemberResumeSize(String memberId);

	
	@Update("update resume set resumetitle=#{resumeTitle}, profileimage=#{profileImage}, name=#{name}, birth=#{birth},"
			+ "phone=#{phone},email=#{email},registdate = sysdate,selfinfo=#{selfInfo},certification=#{certification},"
			+ "language=#{language},address=#{address}"
			+ " where resumeid = #{resumeId}")
	public int updateResume(Resume resume);
}
