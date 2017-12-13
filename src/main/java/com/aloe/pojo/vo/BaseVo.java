package com.aloe.pojo.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author liu_wp
 * @date 2017年9月30日
 * @see
 */
public class BaseVo implements Serializable {

	/*** */
	private static final long serialVersionUID = 1L;
	/**
	 * 创建时间
	 */
	protected int createTime;
	/**
	 * 状态【0：启用，1：停用】
	 */
	protected int status;
	/**
	 * 主键id
	 */
	protected String id;
	/**
	 * 更新时间
	 */
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
