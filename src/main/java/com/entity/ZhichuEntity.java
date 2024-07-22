package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 支出
 *
 * @author 
 * @email
 */
@TableName("zhichu")
public class ZhichuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhichuEntity() {

	}

	public ZhichuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 支出唯一编号
     */
    @TableField(value = "zhichu_uuid_number")

    private String zhichuUuidNumber;


    /**
     * 支出名称
     */
    @TableField(value = "zhichu_name")

    private String zhichuName;


    /**
     * 支出类型
     */
    @TableField(value = "zhichu_types")

    private Integer zhichuTypes;


    /**
     * 支出金额
     */
    @TableField(value = "zhichu_number")

    private Double zhichuNumber;


    /**
     * 支出原因
     */
    @TableField(value = "shangjia_content")

    private String shangjiaContent;


    /**
     * 支出时间
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：支出唯一编号
	 */
    public String getZhichuUuidNumber() {
        return zhichuUuidNumber;
    }


    /**
	 * 获取：支出唯一编号
	 */

    public void setZhichuUuidNumber(String zhichuUuidNumber) {
        this.zhichuUuidNumber = zhichuUuidNumber;
    }
    /**
	 * 设置：支出名称
	 */
    public String getZhichuName() {
        return zhichuName;
    }


    /**
	 * 获取：支出名称
	 */

    public void setZhichuName(String zhichuName) {
        this.zhichuName = zhichuName;
    }
    /**
	 * 设置：支出类型
	 */
    public Integer getZhichuTypes() {
        return zhichuTypes;
    }


    /**
	 * 获取：支出类型
	 */

    public void setZhichuTypes(Integer zhichuTypes) {
        this.zhichuTypes = zhichuTypes;
    }
    /**
	 * 设置：支出金额
	 */
    public Double getZhichuNumber() {
        return zhichuNumber;
    }


    /**
	 * 获取：支出金额
	 */

    public void setZhichuNumber(Double zhichuNumber) {
        this.zhichuNumber = zhichuNumber;
    }
    /**
	 * 设置：支出原因
	 */
    public String getShangjiaContent() {
        return shangjiaContent;
    }


    /**
	 * 获取：支出原因
	 */

    public void setShangjiaContent(String shangjiaContent) {
        this.shangjiaContent = shangjiaContent;
    }
    /**
	 * 设置：支出时间
	 */
    public Date getShoruTime() {
        return shoruTime;
    }


    /**
	 * 获取：支出时间
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

    @Override
    public String toString() {
        return "Zhichu{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", zhichuUuidNumber=" + zhichuUuidNumber +
            ", zhichuName=" + zhichuName +
            ", zhichuTypes=" + zhichuTypes +
            ", zhichuNumber=" + zhichuNumber +
            ", shangjiaContent=" + shangjiaContent +
            ", shoruTime=" + shoruTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
