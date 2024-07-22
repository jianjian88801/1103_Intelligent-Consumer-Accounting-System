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
 * 预算
 *
 * @author 
 * @email
 */
@TableName("yusuan")
public class YusuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YusuanEntity() {

	}

	public YusuanEntity(T t) {
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
     * 预算唯一编号
     */
    @TableField(value = "yusuan_uuid_number")

    private String yusuanUuidNumber;


    /**
     * 预算名称
     */
    @TableField(value = "yusuan_name")

    private String yusuanName;


    /**
     * 预算大类型
     */
    @TableField(value = "yusuan_types")

    private Integer yusuanTypes;


    /**
     * 二级类型
     */
    @TableField(value = "yusuan_erji_types")

    private Integer yusuanErjiTypes;


    /**
     * 预算金额
     */
    @TableField(value = "yusuan_number")

    private Double yusuanNumber;


    /**
     * 预算备注
     */
    @TableField(value = "shangjia_content")

    private String shangjiaContent;


    /**
     * 预算使用时间
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
	 * 设置：预算唯一编号
	 */
    public String getYusuanUuidNumber() {
        return yusuanUuidNumber;
    }


    /**
	 * 获取：预算唯一编号
	 */

    public void setYusuanUuidNumber(String yusuanUuidNumber) {
        this.yusuanUuidNumber = yusuanUuidNumber;
    }
    /**
	 * 设置：预算名称
	 */
    public String getYusuanName() {
        return yusuanName;
    }


    /**
	 * 获取：预算名称
	 */

    public void setYusuanName(String yusuanName) {
        this.yusuanName = yusuanName;
    }
    /**
	 * 设置：预算大类型
	 */
    public Integer getYusuanTypes() {
        return yusuanTypes;
    }


    /**
	 * 获取：预算大类型
	 */

    public void setYusuanTypes(Integer yusuanTypes) {
        this.yusuanTypes = yusuanTypes;
    }
    /**
	 * 设置：二级类型
	 */
    public Integer getYusuanErjiTypes() {
        return yusuanErjiTypes;
    }


    /**
	 * 获取：二级类型
	 */

    public void setYusuanErjiTypes(Integer yusuanErjiTypes) {
        this.yusuanErjiTypes = yusuanErjiTypes;
    }
    /**
	 * 设置：预算金额
	 */
    public Double getYusuanNumber() {
        return yusuanNumber;
    }


    /**
	 * 获取：预算金额
	 */

    public void setYusuanNumber(Double yusuanNumber) {
        this.yusuanNumber = yusuanNumber;
    }
    /**
	 * 设置：预算备注
	 */
    public String getShangjiaContent() {
        return shangjiaContent;
    }


    /**
	 * 获取：预算备注
	 */

    public void setShangjiaContent(String shangjiaContent) {
        this.shangjiaContent = shangjiaContent;
    }
    /**
	 * 设置：预算使用时间
	 */
    public Date getShoruTime() {
        return shoruTime;
    }


    /**
	 * 获取：预算使用时间
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
        return "Yusuan{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", yusuanUuidNumber=" + yusuanUuidNumber +
            ", yusuanName=" + yusuanName +
            ", yusuanTypes=" + yusuanTypes +
            ", yusuanErjiTypes=" + yusuanErjiTypes +
            ", yusuanNumber=" + yusuanNumber +
            ", shangjiaContent=" + shangjiaContent +
            ", shoruTime=" + shoruTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
