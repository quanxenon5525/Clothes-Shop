package com.web.FinalProject.mapper;

import com.web.FinalProject.model.Categories;
import com.web.FinalProject.model.CategoriesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CategoriesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    long countByExample(CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    int deleteByExample(CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    int deleteByPrimaryKey(Integer idCategories);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    int insert(Categories row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    int insertSelective(Categories row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    List<Categories> selectByExample(CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    Categories selectByPrimaryKey(Integer idCategories);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    int updateByExampleSelective(@Param("row") Categories row, @Param("example") CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    int updateByExample(@Param("row") Categories row, @Param("example") CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    int updateByPrimaryKeySelective(Categories row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sun May 01 22:46:40 ICT 2022
     */
    int updateByPrimaryKey(Categories row);
}