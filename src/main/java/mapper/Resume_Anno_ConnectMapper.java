package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.ResumeAnnoConnection;


public interface Resume_Anno_ConnectMapper {

	
	// 공고에 이력서등록 -> 이력서에 공고ID 넣기
	@Update("insert into resume_anno_connect values(#{resumeId},#{annoId},sysdate,null)")
	public int intsertAnnoId(Map<String, Integer> map);
	
	
	// 기업 입장에서 자기 공고에 지원한 이력서들을 볼 때, 이력서를 DB에서 불러오는 쿼리
	@Select("select resumeid, annoid, to_char(resume_register_date,'YYYY-MM-DD PM HH:MI:SS')as resume_register_date from resume_anno_connect"
			+ " where annoid = #{annoId}")
	public List<ResumeAnnoConnection> selectResumeIdfromConnect(int annoId);
	
	
	// 회원이 지원한 공고인지 아닌지 판별하는 쿼리
	@Select("select count(*) from resume_anno_connect where annoid=#{annoId} and resumeid=#{resumeId}")
	public int isResumeRegister(Map<String, Integer> map);
	
	
}
