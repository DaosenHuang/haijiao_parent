package com.ecust.resource.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ecust.resource.entity.EcustPost;
import com.ecust.resource.service.EcustPostService;
import com.haijiao.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/resource/ecust-post")
public class EcustPostController {

    @Autowired
    private EcustPostService postService;

    @ApiOperation(value = "获取岗位分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            EcustPost post) {
        Page< EcustPost> pageParam = new Page<>(page, limit);
        QueryWrapper<EcustPost> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(post.getPostName())) {
            wrapper.like("role_name",post.getPostName());
        }
        postService.page(pageParam,wrapper);
        return Result.ok().data("items", pageParam.getRecords()).data("total", pageParam.getTotal());
    }


    @ApiOperation(value = "获取岗位")
    @GetMapping("get/{id}")
    public Result get(@PathVariable String id) {
        EcustPost  post = postService.getById(id);
        return Result.ok().data("item", post);
    }



    @ApiOperation(value = "新增岗位")
    @PostMapping("save")
    public Result save(@RequestBody  EcustPost post) {
        postService.save(post);
        return Result.ok();
    }

    @ApiOperation(value = "修改岗位")
    @PutMapping("update")
    public Result updateById(@RequestBody EcustPost role) {
        postService.updateById(role);
        return Result.ok();
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id) {
        postService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除角色")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<String> idList) {
        postService.removeByIds(idList);
        return Result.ok();
    }

}

