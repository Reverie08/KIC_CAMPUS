package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mapper.AnnoMapper;
import model.Anno;
import model.Skill;
import util.MybatisConnection;

public class AnnoDAO {
	SqlSession session = MybatisConnection.getConnection();
	
	public List<Anno> getAnnoList() {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoList();
		return li;
	}
	
	public Anno annoCountFromBusinessId(String businessId) {
		Anno anno =  session.getMapper(AnnoMapper.class).AnnoCountFromBusinessId(businessId);
		return anno;
	}
	
	public Anno getAnnoFromAnnoId(int annoId) {
		Anno anno =  session.getMapper(AnnoMapper.class).getAnnoFromAnnoId(annoId);
		return anno;
	}
	
	public List<Anno> getAnnoListFromBusinessId(String businessId) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromBusinessId(businessId);
		return li;
	}
	
	public List<Anno> getAnnoListFromBusinessName(String businessName) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromBusinessName(businessName);
		return li;
	}
	
	public List<Anno> getAnnoListFromAnnoTitle(String annoTitle) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromAnnoTitle(annoTitle);
		return li;
	}

	public List<Anno> getAnnoListFromAnnoCareer(String annoCareer) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromAnnoCareer(annoCareer);
		return li;
	}
	
	public List<Anno> getAnnoListFromAnnoSalary(int annoSalary) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromAnnoSalary(annoSalary);
		return li;
	}
	
	public List<Anno> getAnnoListFromAnnoEdu(String annoEdu) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromAnnoEdu(annoEdu);
		return li;
	}
	
	public List<Anno> getAnnoListFromAnnoGrade(String annoGrade) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromAnnoGrade(annoGrade);
		return li;
	}
	
	public List<Anno> getAnnoListFromAnnoCommon(String annoCommon) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromAnnoCommon(annoCommon);
		return li;
	}
	
	public List<Anno> getAnnoListFromAnnoQualification(String annoQualification) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromAnnoQualification(annoQualification);
		return li;
	}
	
	public List<Anno> getAnnoListFromSkillId(int skillId) {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromSkillId(skillId);
		return li;
	}
	
	public List<Anno> getAnnoListFromAnnoDate() {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromAnnoDate();
		return li;
	}
	
	public List<Anno> getAnnoListFromAnnoDateDesc() {
		List<Anno> li =  session.getMapper(AnnoMapper.class).getAnnoListFromAnnoDateDesc();
		return li;
	}
	
	public int insertAnno(Anno anno) {
		int num = session.getMapper(AnnoMapper.class).insertAnno(anno);
		session.commit();
		return num;
	}
	
	public int updateAnno(Anno anno) {
		int num = session.getMapper(AnnoMapper.class).updateAnno(anno);
		session.commit();
		return num;
	}
	
	public int deleteAnno(int annoId) {
		int num = session.getMapper(AnnoMapper.class).deleteAnno(annoId);
		session.commit();
		return num;
	}

	public int insertSkill(Skill skill) {
		int num = session.getMapper(AnnoMapper.class).insertSkill(skill);
		session.commit();
		return num;
	}
	
	public List<Skill> getAllSkills() {
		List<Skill> li =  session.getMapper(AnnoMapper.class).getAllSkills();
		return li;
	}
	
	public int insertAnnoSkill(int annoId, int skillId) {
		int num = session.getMapper(AnnoMapper.class).insertAnnoSkill(annoId, skillId);
		session.commit();
		return num;
	}

    public int getAnnoId() {
        int annoId = session.getMapper(AnnoMapper.class).getAnnoId();
        return annoId;
    }
    
    public List<Skill> getSkillsByAnnoId(int annoId) {
        List<Skill> skills = session.getMapper(AnnoMapper.class).getSkillsByAnnoId(annoId);
        return skills;
    }
    
    
}
