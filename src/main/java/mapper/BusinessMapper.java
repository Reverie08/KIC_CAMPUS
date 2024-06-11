package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Business;

public interface BusinessMapper {

	@Select("select * from business where bid = #{bid}")
	Business getBusiness(String bid);
	
	@Insert("insert into business values(#{bid}, #{bpw}, #{bname}, #{address}, #{salary}, #{welfare}, #{ceo}, #{sales}, #{employees}, #{type}, #{industry}, #{detailIndustry}, #{homepage}, #{content})")
	int insertBusiness2(Business business);

	@Update("update business set bid=#{bid}, bpw=#{bpw}, bname=#{bname}, address=#{address}, salary=#{salary}, welfare=#{welfare}, ceo=#{ceo}, sales=#{sales}, employees=#{employees}, type=#{type}, industry=#{industry}, detailindustry=#{detailIndustry}, homepage=#{homepage}, content=#{content}")
	int updateBusiness(Business business);

	@Delete("delete from business where bid = #{bid}")
	int deleteBusiness(String bid);

	// 기업의 유형(type)별 리스트
	@Select("select * from business where type=#{type}")
	List<Business> typeList(String type);

	// 기업이 속한 산업(industry)별 리스트
	@Select("select * from business where industry=#{industry}")
	List<Business> industryList(String industry);

	// 기업이 속한 상세 산업(industry)별 리스트
	@Select("select * from business where industry=#{industry} and detailindustry=#{detailIndustry}")
	List<Business> detailIndustryList(String industry, String detailIndustry);
	
	
	
	
	
	
	

}
