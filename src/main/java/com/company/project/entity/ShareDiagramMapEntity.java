package com.company.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 分享
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2020-09-22 00:50:44
 */
@Data
@TableName("share_diagram_map")
public class ShareDiagramMapEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("id")
	private Integer id;

	/**
	 * 分享 id
	 */
	@TableField("share_id")
	private String shareId;

	/**
	 * 图表 id
	 */
	@TableField("diagram_id")
	private String diagramId;

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


	public ShareDiagramMapEntity(Integer id) {
		this.id = id;
	}
}
