package com.haijiao.resource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-10-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EcuModule对象", description="")
public class EcuModule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="模块名")
    private String ecuName;

    @ApiModelProperty(value="模块编号")
    private String ecuNum;

    @ApiModelProperty(value="排序")
    private Integer ecuSort;

    @ApiModelProperty(value="对应表")
    private String ecuTable;

    @ApiModelProperty(value="相关条件")
    private String ecuWhere;

    @ApiModelProperty(value="摘要")
    private String ecuSummary;

    @ApiModelProperty(value="应用摘要")
    private String ecuSummarx;

    @ApiModelProperty(value="类型")
    private String ecuType;

    @ApiModelProperty(value="PC端提醒")
    private Boolean ecuPctx;

    @ApiModelProperty(value="APP提醒")
    private Boolean ecuMctx;

    @ApiModelProperty(value="微信提醒")
    private Boolean ecuWxtx;

    @ApiModelProperty(value="是否邮件提醒")
    private Boolean ecuEmtx;

    @ApiModelProperty(value="编号规则")
    private String ecuSericnum;

    @ApiModelProperty(value="是否有流程")
    private Boolean ecuIsflow;

    @ApiModelProperty(value="空")
    private String ecuReceid;

    @ApiModelProperty(value="模块编号")
    private String ecuRecename;

    @ApiModelProperty(value="操作时间")
    private Date ecuOptdt;

    @ApiModelProperty(value="空")
    private Boolean ecuStatus;

    @ApiModelProperty(value="是否可录入")
    private Boolean ecuIslu;

    @ApiModelProperty(value="多行子表")
    private String ecuTables;

    @ApiModelProperty(value="多行子表名称")
    private String ecuNames;

    @ApiModelProperty(value="状态值设置")
    private String ecuStatusstr;

    @ApiModelProperty(value="是否不显示查阅记录")
    private Boolean ecuIsgbcy;

    @ApiModelProperty(value="是否生成列表页")
    private Boolean ecuIsscl;

    @ApiModelProperty(value="更新时是否同步")
    private Boolean ecuIsup;

    @ApiModelProperty(value="是否钉钉提醒")
    private Boolean ecuDdtx;

    @ApiModelProperty(value="录入页面是否不显示流程图")
    private Boolean ecuIsbxs;

    @ApiModelProperty(value="列表页状态搜索显示0默认，1必须显示，2显示")
    private Boolean ecuLbztxs;

    @ApiModelProperty(value="从新提交时0默认，1重新走流程")
    private Boolean ecuIsflowlx;

    @ApiModelProperty(value="是否自定义抄送")
    private Boolean ecuIscs;

    @ApiModelProperty(value="超过分钟自动作废")
    private Integer ecuZfeitime;

    @ApiModelProperty(value="是否开启评论")
    private Boolean ecuIspl;

    @ApiModelProperty(value="是否开启单据提醒设置")
    private Boolean ecuIstxset;

    @ApiModelProperty(value="回执确认0不开启，1必须选择，2可选")
    private Boolean ecuIshz;

    @ApiModelProperty(value="空")
    private String ecuStatisticsinfo;

    @ApiModelProperty(value="模块编号")
    private Boolean ecuIsgbjl;

    @ApiModelProperty(value="模块编号")
    private String ecuModulecol;


}
