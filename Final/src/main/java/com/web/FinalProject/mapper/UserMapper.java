package com.web.FinalProject.mapper;

import com.web.FinalProject.model.User;
import com.web.FinalProject.model.UserExample;
import com.web.FinalProject.model.UserKey;
import com.web.FinalProject.model.UserWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	long countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	int insert(User row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	int insertSelective(User row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sun May 01 22:46:40 ICT 2022
	 */
	int updateByExample(@Param("row") User row, @Param("example") UserExample example);
	List<Map<String, Object>> checkEmailUser(String email);
	List<Map<String, Object>> checkPhoneUser(String phone);
	List<Map<String, Object>> getUserByName(String username);

}