package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-03-21 17:00:08
 */
@TableName("ENT_DISHONEST_STAFF")
public class EntDishonestStaffEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer entId;
	/**
	 * 
	 */
	private String entName;
	/**
	 * 
	 */
	private String creditCode;
	/**
	 * 
	 */
	private String role;
	/**
	 * 
	 */
	private String code;
	/**
	 * 
	 */
	private String name;

	private String casecode;
	/**
	 * 
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 
	 */
	@TableField(value = "data_status", fill = FieldFill.INSERT)
	private Integer dataStatus;
	/**
	 * 
	 */
	@Version
	private Integer version;

	public String getCasecode() {
		return casecode;
	}

	public void setCasecode(String casecode) {
		this.casecode = casecode;
	}

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setEntId(Integer entId) {
		this.entId = entId;
	}
	/**
	 * 获取：
	 */
	public Integer getEntId() {
		return entId;
	}
	/**
	 * 设置：
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：
	 */
	public String getEntName() {
		return entName;
	}
	/**
	 * 设置：
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	/**
	 * 获取：
	 */
	public String getCreditCode() {
		return creditCode;
	}
	/**
	 * 设置：
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 获取：
	 */
	public String getRole() {
		return role;
	}
	/**
	 * 设置：
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
	/**
	 * 设置：
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：
	 */
	public Integer getVersion() {
		return version;
	}
}