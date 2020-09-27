package com.haijiao.resource.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2020-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Module对象", description="")
public class EcuModule implements Serializable {


    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="逻辑删除：1已删除，0未删除")
    @TableLogic  //表示做逻辑删除
    private boolean isDeleted;

    @ApiModelProperty(value="模块名称")
    private String name;

    @ApiModelProperty(value="模块编号")
    private String num;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="对应表")
    private String table;

    @ApiModelProperty(value="相关条件")
    private String where;

    @ApiModelProperty(value="摘要")
    private String summary;

    @ApiModelProperty(value="应用摘要")
    private String summarx;

    @ApiModelProperty(value="类型")
    private String type;

    @ApiModelProperty(value="是否pc端提醒")
    private Boolean pctx;

    @ApiModelProperty(value="是否app提醒")
    private Boolean mctx;

    @ApiModelProperty(value="是否微信提醒")
    private Boolean wxtx;

    @ApiModelProperty(value="是否邮箱提醒")
    private Boolean emtx;

    @ApiModelProperty(value="编号规则")
    private String sericnum;

    @ApiModelProperty(value="是否有流程")
    private Boolean isflow;

    @ApiModelProperty(value="空")
    private String receid;

    @ApiModelProperty(value="针对对象")
    private String recename;

    @ApiModelProperty(value="操作时间")
    private Date optdt;

    @ApiModelProperty(value="空")
    private Boolean status;

    @ApiModelProperty(value="是否可录入")
    private Boolean islu;

    @ApiModelProperty(value="多行子表")
    private String tables;

    @ApiModelProperty(value="多行子表名称")
    private String names;

    @ApiModelProperty(value="状态值设置")
    private String statusstr;

    @ApiModelProperty(value="是否不显示查阅记录")
    private Boolean isgbcy;

    @ApiModelProperty(value="是否生成列表页")
    private Boolean isscl;

    @ApiModelProperty(value="更新时是否同步")
    private Boolean isup;

    @ApiModelProperty(value="是否钉钉提醒")
    private Boolean ddtx;

    @ApiModelProperty(value="录入页面是否不显示查阅记录")
    private Boolean isbxs;

    @ApiModelProperty(value="列表页状态搜索显示0默认，1必须显示，2显示")
    private Boolean lbztxs;

    @ApiModelProperty(value="重新提交时0默认，1重新走流程")
    private Boolean isflowlx;

    @ApiModelProperty(value="是否自定义抄送")
    private Boolean iscs;

    @ApiModelProperty(value="超过分钟自动作废")
    private Integer zfeitime;

    @ApiModelProperty(value="是否开启评论")
    private Boolean ispl;

    @ApiModelProperty(value="是否开启单据提醒设置")
    private Boolean istxset;

    @ApiModelProperty(value="回执确认0不开启，1必须选择，2可选")
    private Boolean ishz;

    @ApiModelProperty(value="空")
    private String statisticsinfo;

    @ApiModelProperty(value="是否关闭操作记录")
    private Boolean isgbjl;

    @ApiModelProperty(value="创建时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    @ApiModelProperty(value="修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
