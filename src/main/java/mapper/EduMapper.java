package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Edu;

public interface EduMapper {

	@Insert("insert into edu values(eduseq.nextval,#{schoolType},#{schoolName},#{admissionDate},"
			+ "#{graduateDate},#{graduateState},#{major},#{score},#{totalScore},#{resumeId})")
	public int insertEdu(Edu edu);
	

	// 최종 학력 정보를 가져오기
	@Select("select * from edu where resumeid = #{resumeId}")
	public Edu getEdu(int resumeId);
}

