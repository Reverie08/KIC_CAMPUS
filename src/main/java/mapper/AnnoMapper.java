package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Anno;
import model.Skill;

public interface AnnoMapper {

	// 모든 공고 목록 조회
	@Select("SELECT annoid, bid, bname, annotitle, annograde, annoworktype, annoworkplace, annodate FROM anno ORDER BY annoid DESC")
	List<Anno> getAnnoList();

	// 회사id로 해당 회사 공고 개수 조회
	@Select("SELECT COUNT(*) FROM anno WHERE businessid = #{businessId}")
	Anno AnnoCountFromBusinessId(String businessId);

	// 공고id로 해당 공고 1개 조회
	@Select("SELECT * FROM anno WHERE annoid = #{annoId}")
	Anno getAnnoFromAnnoId(int annoId);

	// 회사id로 해당 회사 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE businessid = #{businessId}")
	List<Anno> getAnnoListFromBusinessId(String businessId);

	// 회사명으로 해당 회사 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE businessname = #{businessName}")
	List<Anno> getAnnoListFromBusinessName(String businessName);

	// 공고 제목으로 검색하여 검색어가 포함된 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE annotitle LIKE '%${annoTitle}%' ")
	List<Anno> getAnnoListFromAnnoTitle(String annoTitle);

	// 경력 조건으로 검색하여 검색 조건에 맞는 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE annocareer LIKE '%${annoCareer}%' ")
	List<Anno> getAnnoListFromAnnoCareer(String annoCareer);

	// 연봉 조건으로 검색하여 연봉이 해당 금액 이상인 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE annosalary >= #{annoSalary}")
	List<Anno> getAnnoListFromAnnoSalary(int annoSalary);

	// 학력 조건으로 검색하여 해당 학력이 포함된 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE annoedu LIKE '%${annoEdu}%' ")
	List<Anno> getAnnoListFromAnnoEdu(String annoEdu);

	// 등급 조건으로 검색하여 해당 등급이 포함된 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE annograde LIKE '%${annoGrade}%' ")
	List<Anno> getAnnoListFromAnnoGrade(String annoGrade);

	// 근무지 조건으로 검색하여 검색어가 포함된 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE annoworkplace LIKE '%${annoWorkPlace}%' ")
	List<Anno> getAnnoListFromAnnoWorkPlace(String annoWorkPlace);

	// 공통 조건으로 검색하여 검색어가 포함된 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE annocommon LIKE '%${annoCommon}%' ")
	List<Anno> getAnnoListFromAnnoCommon(String annoCommon);

	// 자격 조건으로 검색하여 검색어가 포함된 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE annoqualification LIKE '%${annoQualification}%' ")
	List<Anno> getAnnoListFromAnnoQualification(String annoQualification);

	// skillid 조건으로 검색하여 검색어가 포함된 공고 리스트 조회
	@Select("SELECT * FROM anno WHERE skillid LIKE '%${skillId}%' ")
	List<Anno> getAnnoListFromSkillId(int skillId);

	// 등록일 순으로 공고 리스트 조회
	@Select("SELECT * FROM anno ORDER BY annodate")
	List<Anno> getAnnoListFromAnnoDate();

	// 최신순으로 공고 리스트 조회
	@Select("SELECT * FROM anno ORDER BY annodate DESC")
	List<Anno> getAnnoListFromAnnoDateDesc();

	// 스킬 삽입
	@Insert("INSERT INTO Skill VALUES"
			+ "(skillseq.nextval, #{java}, #{jsp}, #{html}, #{css}, #{javascript}, #{react}, #{springframework}, #{springboot}, #{python}, #{typescript}, #{express}, #{oracle}, #{mysql}, #{mongodb}, #{memberId}, #{resumeId}, #{annoId})")
	int insertSkill(Skill skill);

	// 모든 스킬 조회
	@Select("SELECT * FROM Skill where annoid = #{annoId}")
	List<Skill> getAllSkills();

	// 공고 삽입
	@Insert("INSERT INTO Anno (annoid, businessname, welfare, annotitle, annocareer, annosalary, annoedu, annograde, annoworktype, annoworkday, annoworkplace, annocommon, annoqualification, annopicknum, annodate, annocontent, businessid, skillid) VALUES"
			+ "(annoseq.nextval, #{businessName}, #{welfare}, #{annoTitle}, #{annoCareer}, #{annoSalary}, #{annoEdu}, #{annoGrade}, #{annoWorkType}, #{annoWorkDay}, #{annoWorkPlace}, #{annoCommon}, #{annoQualification}, #{annoPickNum}, sysdate, #{annoContent}, #{businessId}, #{skillId})")
	int insertAnno(Anno anno);

	@Select("SELECT annoseq.currval FROM dual")
	int getAnnoId();

	// 공고 스킬 삽입
	@Insert("INSERT INTO AnnoSkill (annoid, skillid) VALUES (#{annoId}, #{skillId})")
	int insertAnnoSkill(int annoId, int skillId);

	// 공고 수정
	@Update("UPDATE anno SET" + " businessname=#{businessName}, welfare=#{welfare}, annotitle=#{annoTitle}, annocareer=#{annoCareer},"
			+ " annosalary=#{annoSalary}, annoedu=#{annoEdu}, annograde=#{annoGrade}, annoworktype=#{annoWorkType},"
			+ " annoworkday=#{annoWorkDay}, annoworkplace=#{annoWorkPlace}, annocommon=#{annoCommon},"
			+ " annoQualification=#{annoQualification}, annopicknum=#{annoPickNum},"
			+ " annoContent=#{annoContent}, businessid=#{businessId}, skillid=#{skillId} WHERE annoid=#{annoId}")
	int updateAnno(Anno anno);

	// 공고 삭제
	@Delete("DELETE FROM anno WHERE annoid=#{annoId}")
	int deleteAnno(int annoId);

	// 공고 id로 스킬 조회
	@Select("SELECT * FROM Skill WHERE annoid = #{annoId}")
	List<Skill> getSkillsByAnnoId(int annoId);
}
