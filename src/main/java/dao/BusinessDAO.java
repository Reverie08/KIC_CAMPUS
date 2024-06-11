package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mapper.BusinessMapper;
import model.Business;
import util.MybatisConnection;

public class BusinessDAO {
	SqlSession session = MybatisConnection.getConnection();

	public Business getBusiness(String bid) {
		Business business = session.getMapper(BusinessMapper.class).getBusiness(bid);
		return business;
	}

	public int insertBusiness(Business business) {
		int bnum = session.getMapper(BusinessMapper.class).insertBusiness(business);
		return bnum;
	}

	public int updateBusiness(Business business) {
		int bnum = session.getMapper(BusinessMapper.class).updateBusiness(business);
		return bnum;
	}

	public int deleteBusiness(String bid) {
		int bnum = session.getMapper(BusinessMapper.class).deleteBusiness(bid);
		return bnum;
	}

	// 기업의 유형(type)별 리스트
	public List<Business> typeList(String type) {
		List<Business> typeList = session.getMapper(BusinessMapper.class).typeList(type);
		return typeList;
	}

	// 기업이 속한 산업(industry)별 리스트
	public List<Business> industryList(String industry) {
		List<Business> industryList = session.getMapper(BusinessMapper.class).industryList(industry);
		return industryList; 
	}

	// 기업이 속한 상세 산업(industry)별 리스트
	public List<Business> detailIndustryList(String industry, String detailIndustry) {
		List<Business> detailIndustryList = session.getMapper(BusinessMapper.class).detailIndustryList(industry, detailIndustry);
		return detailIndustryList;
	}

}
