package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Anno;

public interface AnnoMapper {

    // ===================== only select =====================

	// 모든 공고 목록을 가져옴 (공고 리스트) 공고명, 공고내용, 공고시작일, 공고종료일
    @Select("select annoid, bid, bname, annotitle, annograde, annoworktype, annoworkplace,annodate from anno order by annoid desc")
    List<Anno> getAnnoList();
	
    // 회사id로 해당 회사 공고 개수 가져옴
    @Select("select count(*) from anno where bid = #{bId}")
    Anno AnnoCountFromBid(String bId);

    // 공고id로 해당 공고 1개 가져옴
    @Select("select * from anno where annoid = #{annoId}")
    Anno getAnnoFromAnnoId(int annoId);

    // 회사id로 해당 회사 공고 리스트 가져옴
    @Select("select * from anno where bid = #{bId}")
    List<Anno> getAnnoListFromBid(String bId);

    // 회사명으로 해당 회사 공고 리스트 가져옴
    @Select("select * from anno where bname = #{bName}")
    List<Anno> getAnnoListFromBname(String bName);

    // 공고 제목으로 검색하여 검색어가 포함된 공고 리스트 가져옴
    @Select("select * from anno where annoTitle like '%${annoTitle}%' ")
    List<Anno> getAnnoListFromAnnoTitle(String annoTitle);

    // 경력 조건으로 검색하여 검색 조건에 맞는 공고 리스트 가져옴
    @Select("select * from anno where annoCareer like '%${annoCareer}%' ")
    List<Anno> getAnnoListFromAnnoCareer(String annoCareer);

    // 연봉 조건으로 검색하여 연봉이 해당 금액 이상인 공고 리스트 가져옴
    @Select("select * from anno where annoSalary >= #{annoSalary}")
    List<Anno> getAnnoListFromAnnoSalary(int annoSalary);

    // 학력 조건으로 검색하여 해당 학력이 포함된 공고 리스트 가져옴
    @Select("select * from anno where annoEdu like '%${annoEdu}%' ")
    List<Anno> getAnnoListFromAnnoEdu(String annoEdu);

    // 등급 조건으로 검색하여 해당 등급이 포함된 공고 리스트 가져옴
    @Select("select * from anno where annoGrade like '%${annoGrade}%' ")
    List<Anno> getAnnoListFromAnnoGrade(String annoGrade);

    // 근무지 조건으로 검색하여 검색어가 포함된 공고 리스트 가져옴
    @Select("select * from anno where annoWorkPlace like '%${annoWorkPlace}%' ")
    List<Anno> getAnnoListFromAnnoWorkPlace(String annoWorkPlace);

    // 공통 조건으로 검색하여 검색어가 포함된 공고 리스트 가져옴
    @Select("select * from anno where annoCommon like '%${annoCommon}%' ")
    List<Anno> getAnnoListFromAnnoCommon(String annoCommon);

    // 자격 조건으로 검색하여 검색어가 포함된 공고 리스트 가져옴
    @Select("select * from anno where annoQualification like '%${annoQualification}%' ")
    List<Anno> getAnnoListFromAnnoQualification(String annoQualification);
    
    // skillid 조건으로 검색하여 검색어가 포함된 공고 리스트 가져옴
    @Select("select * from anno where skillid like '%${skillId}%' ")
    List<Anno> getAnnoListFromSkillId(int skillId);

    // 등록일 순으로 공고 리스트 가져옴
    @Select("select * from anno order by annoDate")
    List<Anno> getAnnoListFromAnnoDate();

    // 최신순으로 공고 리스트 가져옴
    @Select("select * from anno order by annoDate desc")
    List<Anno> getAnnoListFromAnnoDateDesc();

    // ===================== only insert =======================
    @Insert("insert into anno values"
            + "(annoseq.nextval, #{bname}, #{welfare}, #{annoTitle}, #{annoCareer},"
            + "#{annoSalary}, #{annoEdu}, #{annoGrade}, #{annoWorkType}, #{annoWorkDay},"
            + "#{annoWorkPlace}, #{annoCommon}, #{annoQualification}, #{annoPickNum},"
            + "sysdate, #{annoContent}, #{bId}, #{skillId})")
    public int insertAnno(Anno anno);

    // ===================== only update =======================

    // 공고 수정
    @Update("update anno set"
            + " bname=#{bname}, welfare=#{welfare}, annoTitle=#{annoTitle}, annoCareer=#{annoCareer},"
            + " annoSalary=#{annoSalary}, annoEdu=#{annoEdu}, annoGrade=#{annoGrade}, annoWorkType=#{annoWorkType},"
            + " annoWorkDay=#{annoWorkDay}, annoWorkPlace=#{annoWorkPlace}, annoCommon=#{annoCommon},"
            + " annoQualification=#{annoQualification}, annoPickNum=#{annoPickNum},"
            + " annoContent=#{annoContent}, bid=#{bId} where annoid=#{annoId}")
    public int updateAnno(Anno anno);

    // ===================== only delete =======================
    // 공고 삭제
    @Delete("delete from anno where annoid=#{annoId}")
    public int deleteAnno(int annoId);
}
