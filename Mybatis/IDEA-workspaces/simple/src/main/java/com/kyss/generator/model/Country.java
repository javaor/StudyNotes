package com.kyss.generator.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table dbo.country
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class Country {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.country.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.country.countryname
     *
     * @mbggenerated
     */
    private String countryname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.country.countrycode
     *
     * @mbggenerated
     */
    private String countrycode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.country.id
     *
     * @return the value of dbo.country.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.country.id
     *
     * @param id the value for dbo.country.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.country.countryname
     *
     * @return the value of dbo.country.countryname
     *
     * @mbggenerated
     */
    public String getCountryname() {
        return countryname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.country.countryname
     *
     * @param countryname the value for dbo.country.countryname
     *
     * @mbggenerated
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname == null ? null : countryname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.country.countrycode
     *
     * @return the value of dbo.country.countrycode
     *
     * @mbggenerated
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.country.countrycode
     *
     * @param countrycode the value for dbo.country.countrycode
     *
     * @mbggenerated
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }
}