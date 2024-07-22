package com.entity.model;

import com.entity.ZhichuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 支出
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhichuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 支出唯一编号
     */
    private String zhichuUuidNumber;


    /**
     * 支出名称
     */
    private String zhichuName;


    /**
     * 支出类型
     */
    private Integer zhichuTypes;


    /**
     * 支出金额
     */
    private Double zhichuNumber;


    /**
     * 支出原因
     */
    private String shangjiaContent;


    /**
     * 支出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shoruTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：支出唯一编号
	 */
    public String getZhichuUuidNumber() {
        return zhichuUuidNumber;
    }


    /**
	 * 设置：支出唯一编号
	 */
    public void setZhichuUuidNumber(String zhichuUuidNumber) {
        this.zhichuUuidNumber = zhichuUuidNumber;
    }
    /**
	 * 获取：支出名称
	 */
    public String getZhichuName() {
        return zhichuName;
    }


    /**
	 * 设置：支出名称
	 */
    public void setZhichuName(String zhichuName) {
        this.zhichuName = zhichuName;
    }
    /**
	 * 获取：支出类型
	 */
    public Integer getZhichuTypes() {
        return zhichuTypes;
    }


    /**
	 * 设置：支出类型
	 */
    public void setZhichuTypes(Integer zhichuTypes) {
        this.zhichuTypes = zhichuTypes;
    }
    /**
	 * 获取：支出金额
	 */
    public Double getZhichuNumber() {
        return zhichuNumber;
    }


    /**
	 * 设置：支出金额
	 */
    public void setZhichuNumber(Double zhichuNumber) {
        this.zhichuNumber = zhichuNumber;
    }
    /**
	 * 获取：支出原因
	 */
    public String getShangjiaContent() {
        return shangjiaContent;
    }


    /**
	 * 设置：支出原因
	 */
    public void setShangjiaContent(String shangjiaContent) {
        this.shangjiaContent = shangjiaContent;
    }
    /**
	 * 获取：支出时间
	 */
    public Date getShoruTime() {
        return shoruTime;
    }


    /**
	 * 设置：支出时间
	 */
    public void setShoruTime(Date shoruTime) {
        this.shoruTime = shoruTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
