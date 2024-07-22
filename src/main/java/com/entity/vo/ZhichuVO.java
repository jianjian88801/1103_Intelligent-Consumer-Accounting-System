package com.entity.vo;

import com.entity.ZhichuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 支出
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhichu")
public class ZhichuVO implements Serializable {
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

}
