package com.aloe.pojo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文件 Entiry
 *
 * @author liu_wp
 * @date 2017年11月3日
 * @see
 */
@Table(name = "file_info")
public class FileInfoEntity {
	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 文件名称
	 */
	@Column(name = "file_name")
	private String fileName;

	/**
	 * 文件原来名称
	 */
	@Column(name = "file_original_name")
	private String fileOriginalName;

	/**
	 * 文件类型
	 */
	@Column(name = "file_type")
	private String fileType;

	/**
	 * 文件绝对路径
	 */
	@Column(name = "file_path")
	private String filePath;

	/**
	 * 文件相对路径
	 */
	@Column(name = "file_relative_path")
	private String fileRelativePath;

	/**
	 * 文件大小
	 */
	@Column(name = "file_size")
	private Long fileSize;

	/**
	 * 更新人
	 */
	@Column(name = "update_by")
	private String updateBy;
	/**
	 * 创建人
	 */
	@Column(name = "create_by")
	private String createBy;
	/**
	 * 文件状态 【0：有效；1：无效】
	 */
	private Integer status;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Integer createTime;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	private Date updateTime;

	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_time - 创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}

	/**
	 * @return file_name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @return file_original_name
	 */
	public String getFileOriginalName() {
		return fileOriginalName;
	}

	/**
	 * 获取文件绝对路径
	 *
	 * @return file_path - 文件绝对路径
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * 获取文件相对路径
	 *
	 * @return file_relative_path - 文件相对路径
	 */
	public String getFileRelativePath() {
		return fileRelativePath;
	}

	/**
	 * 获取文件大小
	 *
	 * @return file_size - 文件大小
	 */
	public Long getFileSize() {
		return fileSize;
	}

	/**
	 * 获取文件类型
	 *
	 * @return file_type - 文件类型
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	public Integer getStatus() {
		return status;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 获取更新时间
	 *
	 * @return update_time - 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	/**
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName == null ? null : fileName.trim();
	}

	/**
	 * @param fileOriginalName
	 */
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName == null ? null : fileOriginalName.trim();
	}

	/**
	 * 设置文件绝对路径
	 *
	 * @param filePath
	 *            文件绝对路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath == null ? null : filePath.trim();
	}

	/**
	 * 设置文件相对路径
	 *
	 * @param fileRelativePath
	 *            文件相对路径
	 */
	public void setFileRelativePath(String fileRelativePath) {
		this.fileRelativePath = fileRelativePath == null ? null : fileRelativePath.trim();
	}

	/**
	 * 设置文件大小
	 *
	 * @param fileSize
	 *            文件大小
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * 设置文件类型
	 *
	 * @param fileType
	 *            文件类型
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType == null ? null : fileType.trim();
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 设置更新时间
	 *
	 * @param updateTime
	 *            更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}