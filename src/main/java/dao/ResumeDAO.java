package dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.CareerMapper;
import mapper.EduMapper;
import mapper.MemberPortfolioMapper;
import mapper.MemberProjectMapper;
import mapper.ResumeMapper;
import model.Career;
import model.Edu;
import model.MemberPortfolio;
import model.MemberProject;
import model.Resume;
import model.ResumeAnnoConnection;

@Component
public class ResumeDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	
	public String getProfileImage(String memberId ) {
		
		String profileImage = session.getMapper(ResumeMapper.class).getProfileImage(memberId);
		
		return profileImage;
	
	}
	
	// 이력서 1개 가져오기
	public Resume getResume(int resumeId) {
		Resume resume = session.getMapper(ResumeMapper.class).getResume(resumeId);
		
		Edu edu = session.getMapper(EduMapper.class).getEdu(resumeId);
		MemberProject project = session.getMapper(MemberProjectMapper.class).getProject(resumeId);
		MemberPortfolio portfoio= session.getMapper(MemberPortfolioMapper.class).getPortfolio(resumeId);
		Career career = session.getMapper(CareerMapper.class).getCareer(resumeId);
		
		resume.setEdu(edu);
		resume.setProject(project);
		resume.setCareer(career);
		resume.setPortfolio(portfoio);
		
		return resume;
	}
	
	public Resume resumeInfo(int resumeId) {
		
		Resume resume = session.getMapper(ResumeMapper.class).getResume(resumeId);
		
		
		return resume; 
	}
	
	
	
	// 이력서 여러 개 리스트로 가져오기, 회원 자신이 작성한 이력서 목록 가져오기
	public List<Resume> getMemberReumeList(String memberid){
		List<Resume> memberResumeList = session.getMapper(ResumeMapper.class).getMemberReumeList(memberid);
		return memberResumeList;
	}
	
	
	
	// 이력서 여러 개 리스트로 가져오기, 기업에 들어온 이력서 목록 가져오기 getBusinessReumeList
	public List<Resume> getBusinessReumeList(String businessId){
		List<Resume> businessResumeList = session.getMapper(ResumeMapper.class).getBusinessReumeList(businessId);
		return businessResumeList;
	}
	
	
	// 
	public List<Resume> getAnnoResumeList(int annoId){
		
		List<ResumeAnnoConnection> resumeAnnoConnectionList = session.getMapper(ResumeMapper.class).selectResumeIdfromConnect(annoId);
		
		List<Resume> resumeList = new ArrayList();
		
		for(int i=0;i<resumeAnnoConnectionList.size();i++) {
			int resumeId = resumeAnnoConnectionList.get(i).getResumeId();
			String registDate = resumeAnnoConnectionList.get(i).getResume_register_date();
			System.out.println("==================registDate : "+registDate);
			Resume resume = session.getMapper(ResumeMapper.class).getResume(resumeId);
			if(resume != null) {
				resume.setRegisterToCompanyDate(registDate);
			}
			resumeList.add(resume);
		}
		return resumeList;
	}
	
	public int selectResumeId() {
		return session.getMapper(ResumeMapper.class).selectResumeId();
	}
	
	
	// 이력서 작성하기 insertResume
	public int insertResume(Resume resume) {
		
		// 학력 테이블에 데이터 insert
		int num1 = session.getMapper(EduMapper.class).insertEdu(resume.getEdu());
		System.out.println("num1 = "+num1);
		
		// 포트폴리오 테이블에 데이터 insert
		int num2 = session.getMapper(MemberPortfolioMapper.class).insertPortfolio(resume.getPortfolio());
		System.out.println("num2 = "+num2);
		
		// 프로젝트 테이블에 데이터 insert
		int num3 = session.getMapper(MemberProjectMapper.class).insertProject(resume.getProject());
		System.out.println("num3 = "+num3);
		
		// 경력 테이블에 데이터 insert
		int num4 = session.getMapper(CareerMapper.class).insertCareer(resume.getCareer());
		System.out.println("num4 = "+num4);
		
		
		int num = session.getMapper(ResumeMapper.class).insertResume(resume);
		System.out.println("num = "+num);
		
		session.commit();
		
		return num;
	}
	
	
	
	
	
	
	// 이력서 수정하기 updateResume
	public int updateResume(Resume resume) {
		
		// 학력 테이블에 데이터 update
		int num1 = session.getMapper(EduMapper.class).updateEdu(resume.getEdu());
		System.out.println("num1 = "+num1);
		
		// 포트폴리오 테이블에 데이터 update
		int num2 = session.getMapper(MemberPortfolioMapper.class).updatePortfolio(resume.getPortfolio());
		System.out.println("num2 = "+num2);
		
		// 프로젝트 테이블에 데이터 update
		int num3 = session.getMapper(MemberProjectMapper.class).updateProject(resume.getProject());
		System.out.println("num3 = "+num3);
		
		// 경력 테이블에 데이터 update
		int num4 = session.getMapper(CareerMapper.class).updateCareer(resume.getCareer());
		System.out.println("num4 = "+num4);
		
		// 이력서 테이블 최종 업데이트
		int num = session.getMapper(ResumeMapper.class).updateResume(resume);
		System.out.println("num = "+num);
		
		session.commit();
		
		return num;
	}
	
	
	// 이력서 삭제하기 deleteResume
	public int deleteResume(int resumeId) {
		int num = session.getMapper(ResumeMapper.class).deleteResume(resumeId);
		session.commit();
		return num;
	}

	public int updateAnnoId(int resumeId, int annoId) {
		Map<String,Integer> map = new HashMap<>();
		map.put("resumeId", resumeId);
		map.put("annoId", annoId);
		int result = session.getMapper(ResumeMapper.class).intsertAnnoId(map);
		session.commit();
		return 0;
	}

	public int getMemberResumeSize(String memberId) {
		int memberResumeSize = session.getMapper(ResumeMapper.class).getMemberResumeSize(memberId);
		// TODO Auto-generated method stub
		return memberResumeSize;
	}
	
}
