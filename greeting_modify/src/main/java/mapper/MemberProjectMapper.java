package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.MemberProject;

public interface MemberProjectMapper {

	
	@Insert("insert into memberproject values(memberprojectseq.nextval,#{projectName},#{team},#{isGoing},#{projectPeriod},#{projectInfo},#{resumeId})")
	public int insertProject(MemberProject project);
	
	@Select("select * from memberproject where resumeid=#{resumeId}")
	public MemberProject getProject(int resumeId);
}
