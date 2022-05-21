package com.web.FinalProject.mapper;

import com.web.FinalProject.model.Checkout;
import com.web.FinalProject.model.CheckoutExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CheckoutMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	long countByExample(CheckoutExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	int deleteByExample(CheckoutExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	int deleteByPrimaryKey(Integer id);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	int insert(Checkout row);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	int insertSelective(Checkout row);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	List<Checkout> selectByExample(CheckoutExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	Checkout selectByPrimaryKey(Integer id);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	int updateByExampleSelective(@Param("row") Checkout row, @Param("example") CheckoutExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	int updateByExample(@Param("row") Checkout row, @Param("example") CheckoutExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	int updateByPrimaryKeySelective(Checkout row);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table checkout
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	int updateByPrimaryKey(Checkout row);
	List<Map<String, Object>> checkIdCart(Map<String, Object> result);
	List<Map<String, Object>> listOrderWait();
	int updateSendProduct(Integer id);
	int updateActiveCart(Integer id);


	List<Map<String, Object>> checkExist(Integer id_user);

}