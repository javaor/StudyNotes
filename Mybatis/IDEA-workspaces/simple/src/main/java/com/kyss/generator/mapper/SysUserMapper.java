package com.kyss.generator.mapper;

import com.kyss.generator.model.SysUser;
import com.kyss.generator.model.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int countByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int deleteByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int insertSelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    List<SysUser> selectByExampleWithBLOBs(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    List<SysUser> selectByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    SysUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.sys_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUser record);
}