package com.entity.model;

import com.entity.YusuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预算
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YusuanModel implements Serializable {
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
     * 预算唯一编号
     */
    private String yusuanUuidNumber;


    /**
     * 预算名称
     */
    private String yusuanName;


    /**
     * 预算大类型
     */
    private Integer yusuanTypes;


    /**
     * 二级类型
     */
    private Integer yusuanErjiTypes;


    /**
     * 预算金额
     */
    private Double yusuanNumber;


    /**
     * 预算备注
     */
    private String shangjiaContent;


    /**
     * 预算使用时间
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
	 * 获取：预算唯一编号
	 */
    public String getYusuanUuidNumber() {
        return yusuanUuidNumber;
    }


    /**
	 * 设置：预算唯一编号
	 */
    public void setYusuanUuidNumber(String yusuanUuidNumber) {
        this.yusuanUuidNumber = yusuanUuidNumber;
    }
    /**
	 * 获取：预算名称
	 */
    public String getYusuanName() {
        return yusuanName;
    }


    /**
	 * 设置：预算名称
	 */
    public void setYusuanName(String yusuanName) {
        this.yusuanName = yusuanName;
    }
    /**
	 * 获取：预算大类型
	 */
    public Integer getYusuanTypes() {
        return yusuanTypes;
    }


    /**
	 * 设置：预算大类型
	 */
    public void setYusuanTypes(Integer yusuanTypes) {
        this.yusuanTypes = yusuanTypes;
    }
    /**
	 * 获取：二级类型
	 */
    public Integer getYusuanErjiTypes() {
        return yusuanErjiTypes;
    }


    /**
	 * 设置：二级类型
	 */
    public void setYusuanErjiTypes(Integer yusuanErjiTypes) {
        this.yusuanErjiTypes = yusuanErjiTypes;
    }
    /**
	 * 获取：预算金额
	 */
    public Double getYusuanNumber() {
        return yusuanNumber;
    }


    /**
	 * 设置：预算金额
	 */
    public void setYusuanNumber(Double yusuanNumber) {
        this.yusuanNumber = yusuanNumber;
    }
    /**
	 * 获取：预算备注
	 */
    public String getShangjiaContent() {
        return shangjiaContent;
    }


    /**
	 * 设置：预算备注
	 */
    public void setShangjiaContent(String shangjiaContent) {
        this.shangjiaContent = shangjiaContent;
    }
    /**
	 * 获取：预算使用时间
	 */
    public Date getShoruTime() {
        return shoruTime;
    }


    /**
	 * 设置：预算使用时间
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
