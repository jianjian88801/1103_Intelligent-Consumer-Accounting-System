package com.entity.vo;

import com.entity.ShouruEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 收入
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shouru")
public class ShouruVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 收入唯一编号
     */

    @TableField(value = "shouru_uuid_number")
    private String shouruUuidNumber;


    /**
     * 收入名称
     */

    @TableField(value = "shouru_name")
    private String shouruName;


    /**
     * 收入类型
     */

    @TableField(value = "shouru_types")
    private Integer shouruTypes;


    /**
     * 收入金额
     */

    @TableField(value = "shouru_number")
    private Double shouruNumber;


    /**
     * 收入备注
     */

    @TableField(value = "shangjia_content")
    private String shangjiaContent;


    /**
     * 收入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shoru_time")
    private Date shoruTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：收入唯一编号
	 */
    public String getShouruUuidNumber() {
        return shouruUuidNumber;
    }


    /**
	 * 获取：收入唯一编号
	 */

    public void setShouruUuidNumber(String shouruUuidNumber) {
        this.shouruUuidNumber = shouruUuidNumber;
    }
    /**
	 * 设置：收入名称
	 */
    public String getShouruName() {
        return shouruName;
    }


    /**
	 * 获取：收入名称
	 */

    public void setShouruName(String shouruName) {
        this.shouruName = shouruName;
    }
    /**
	 * 设置：收入类型
	 */
    public Integer getShouruTypes() {
        return shouruTypes;
    }


    /**
	 * 获取：收入类型
	 */

    public void setShouruTypes(Integer shouruTypes) {
        this.shouruTypes = shouruTypes;
    }
    /**
	 * 设置：收入金额
	 */
    public Double getShouruNumber() {
        return shouruNumber;
    }


    /**
	 * 获取：收入金额
	 */

    public void setShouruNumber(Double shouruNumber) {
        this.shouruNumber = shouruNumber;
    }
    /**
	 * 设置：收入备注
	 */
    public String getShangjiaContent() {
        return shangjiaContent;
    }


    /**
	 * 获取：收入备注
	 */

    public void setShangjiaContent(String shangjiaContent) {
        this.shangjiaContent = shangjiaContent;
    }
    /**
	 * 设置：收入时间
	 */
    public Date getShoruTime() {
        return shoruTime;
    }


    /**
	 * 获取：收入时间
	 */

    public void setShoruTime(Date shoruTime) {
        this.shoruTime = shoruTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
