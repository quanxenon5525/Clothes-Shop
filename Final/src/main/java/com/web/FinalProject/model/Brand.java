package com.web.FinalProject.model;

public class Brand {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column brand.id_brand
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	private Integer idBrand;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column brand.brandName
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	private String brandname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column brand.active
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	private Integer active;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column brand.img
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	private String img;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column brand.id_brand
	 * @return  the value of brand.id_brand
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	public Integer getIdBrand() {
		return idBrand;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column brand.id_brand
	 * @param idBrand  the value for brand.id_brand
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	public void setIdBrand(Integer idBrand) {
		this.idBrand = idBrand;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column brand.brandName
	 * @return  the value of brand.brandName
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	public String getBrandname() {
		return brandname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column brand.brandName
	 * @param brandname  the value for brand.brandName
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column brand.active
	 * @return  the value of brand.active
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	public Integer getActive() {
		return active;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column brand.active
	 * @param active  the value for brand.active
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	public void setActive(Integer active) {
		this.active = active;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column brand.img
	 * @return  the value of brand.img
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	public String getImg() {
		return img;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column brand.img
	 * @param img  the value for brand.img
	 * @mbg.generated  Wed May 18 19:20:19 ICT 2022
	 */
	public void setImg(String img) {
		this.img = img;
	}

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brand(String brandname, Integer active, String img) {
		super();
		this.brandname = brandname;
		this.active = active;
		this.img = img;
	}

	public Brand(Integer idBrand, String brandname, Integer active, String img) {
		super();
		this.idBrand = idBrand;
		this.brandname = brandname;
		this.active = active;
		this.img = img;
	}
}