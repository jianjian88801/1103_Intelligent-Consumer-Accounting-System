package com.entity.model;

import com.entity.ShouruEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 收入
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShouruModel implements Serializable {
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
     * 收入唯一编号
     */
    private String shouruUuidNumber;


    /**
     * 收入名称
     */
    private String shouruName;


    /**
     * 收入类型
     */
    private Integer shouruTypes;


    /**
     * 收入金额
     */
    private Double shouruNumber;


    /**
     * 收入备注
     */
    private String shangjiaContent;


    /**
     * 收入时间
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
	 * 获取：收入唯一编号
	 */
    public String getShouruUuidNumber() {
        return shouruUuidNumber;
    }


    /**
	 * 设置：收入唯一编号
	 */
    public void setShouruUuidNumber(String shouruUuidNumber) {
        this.shouruUuidNumber = shouruUuidNumber;
    }
    /**
	 * 获取：收入名称
	 */
    public String getShouruName() {
        return shouruName;
    }


    /**
	 * 设置：收入名称
	 */
    public void setShouruName(String shouruName) {
        this.shouruName = shouruName;
    }
    /**
	 * 获取：收入类型
	 */
    public Integer getShouruTypes() {
        return shouruTypes;
    }


    /**
	 * 设置：收入类型
	 */
    public void setShouruTypes(Integer shouruTypes) {
        this.shouruTypes = shouruTypes;
    }
    /**
	 * 获取：收入金额
	 */
    public Double getShouruNumber() {
        return shouruNumber;
    }


    /**
	 * 设置：收入金额
	 */
    public void setShouruNumber(Double shouruNumber) {
        this.shouruNumber = shouruNumber;
    }
    /**
	 * 获取：收入备注
	 */
    public String getShangjiaContent() {
        return shangjiaContent;
    }


    /**
	 * 设置：收入备注
	 */
    public void setShangjiaContent(String shangjiaContent) {
        this.shangjiaContent = shangjiaContent;
    }
    /**
	 * 获取：收入时间
	 */
    public Date getShoruTime() {
        return shoruTime;
    }


    /**
	 * 设置：收入时间
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
