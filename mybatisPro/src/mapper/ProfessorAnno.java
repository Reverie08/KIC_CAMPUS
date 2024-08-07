package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import model.Professor;

public interface ProfessorAnno {
	@Select("select count(*) from professor")
	int count();

	@Select("select * from professor")
	List<Professor> list();

	@Select("select * from professor where deptno = #{value}")
	List<Professor> selectdeptno(int deptno);

	@Select("select * from professor where name like '_${name}%'\r\n" + "		and\r\n"
			+ "		position = #{position}")
	List<Professor> selectnameposition(Map map);

	@Select("<script>select * from professor" + "		<trim prefix='where' prefixOverrides='AND || OR'>"
			+ "			<if test='deptno != null'>and deptno = #{deptno}</if>"
			+ "			<if test='position != null'>and position = #{position}</if>"
			+ "			<if test='profno != null'>and profno = #{profno}</if>" + "			"
			+ "			<if test='datas != null'>" + "				and deptno in"
			+ "				<foreach collection ='datas' item='d'"
			+ "				separator=',' open='(' close=')'>#{d}" + "				</foreach>" + "			</if>"
			+ "		</trim> </script>")
	List<Professor> select(Map map);
	
	@Insert("insert into professor"
			+ "		values"
			+ "		(#{profno}, #{name}, #{id}, #{position}, #{pay}, "
			+ "		sysdate, 0, #{deptno}, #{email}, '') ")
	@SelectKey(statement = "select nvl(max(profno)+1,1111) a from professor",
		keyProperty = "profno", resultType = int.class, before = true)
	int insertProfessor(Professor p);

}
