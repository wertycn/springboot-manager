package com.company.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.company.project.entity.BaseEntity;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 图
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2020-09-22 00:50:58
 */
@Data
@TableName("diagram")
public class DiagramEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("id")
	private Integer id;

	/**
	 * 图表 id
	 */
	@TableField("diagram_id")
	private String diagramId;

	/**
	 * 图表名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 创建者
	 */
	@TableField("creator")
	private String creator;

	/**
	 * 修改人
	 */
	@TableField("modifier")
	private String modifier;

	/**
	 * 所属团队 id
	 */
	@TableField("team_id")
	private String teamId;

	/**
	 * 创建时间
	 */
	@TableField("gmt_created")
	private Date gmtCreated;

	/**
	 * 更新时间
	 */
	@TableField("gmt_modified")
	private Date gmtModified;

	/**
	 * 缩略图 id
	 */
	@TableField("kanoFileId")
	private String kanoFileId;

	/**
	 * 图内容
	 */
	@TableField("content")
	private String content;

	/**
	 * minder 代表思维导图，drawio 代表其他图
	 */
	@TableField("type")
	private String type;


}
