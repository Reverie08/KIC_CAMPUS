package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mapper.BusinessMapper;
import model.Business;
import model.Search;
import util.MybatisConnection;

public class BusinessDAO {
	SqlSession session = MybatisConnection.getConnection();
	
	// 기업 정보 조회
	public Business getBusiness(String bid) {
		Business business = session.getMapper(BusinessMapper.class).getBusiness(bid);
		return business;
	}
	
	// 전체 기업 리스트 조회
	public List<Business> businessList() {
		List<Business> businessList = session.getMapper(BusinessMapper.class).businessList();
		return businessList;
	}

	
	// 기업 정보 기입(회원가입)
	public int insertBusiness(Business business) {
		int bnum = session.getMapper(BusinessMapper.class).insertBusiness(business);
		session.commit();
		return bnum;
	}

	// 기업 정보 수정
	public int updateBusiness(Business business) {
		int bnum = session.getMapper(BusinessMapper.class).updateBusiness(business);
		session.commit();
		return bnum;
	}

	// 기업 정보 삭제
	public int deleteBusiness(String bid) {
		int bnum = session.getMapper(BusinessMapper.class).deleteBusiness(bid);
		session.commit();
		return bnum;
	}

	// 기업의 유형(type)별 리스트 조회
	public List<Business> typeList(String type) {
		List<Business> typeList = session.getMapper(BusinessMapper.class).typeList(type);
		return typeList;
	}

	// 기업이 속한 산업(industry)별 리스트 조회
	public List<Business> industryList(String industry) {
		List<Business> industryList = session.getMapper(BusinessMapper.class).industryList(industry);
		return industryList; 
	}

	// 기업이 속한 상세 산업(industry)별 리스트 조회
	public List<Business> detailIndustryList(String industry, String detailIndustry) {
		List<Business> detailIndustryList = session.getMapper(BusinessMapper.class).detailIndustryList(industry, detailIndustry);
		return detailIndustryList;
	}
	
	
	// 기업 조건 검색
	public List<Business> searchBusinessList(Search search) {
		//검색 결과가 아예 없을수도 있고 정확히 몇개인지 모르니 List로 받는다.
		List<Business> searchBusinessList = session.getMapper(BusinessMapper.class).searchBusinessList(search);
//		session.close();
		return searchBusinessList;
	} 


}
