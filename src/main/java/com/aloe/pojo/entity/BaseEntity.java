package com.aloe.pojo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author liu_wp
 * @date 2017年9月30日
 * @see
 */
public class BaseEntity {
	/**
	 * 创建时间
	 */
	@Column(name = "create_time", nullable = false)
	protected int createTime;
	/**
	 * 状态【0：启用，1：停用】
	 */
	@Column(name = "status", nullable = false)
	protected int status;
	/**
	 * 主键id
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "UUID")
	protected String id;
	/**
	 * 更新时间
	 */
	@Column(name = "update_time", nullable = false)
	protected Timestamp updateTime;

	public int getCreateTime() {
		return createTime;
	}

	public String getId() {
		return id;
	}

	public int getStatus() {
		return status;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
