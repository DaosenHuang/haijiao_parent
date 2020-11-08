package com.haijiao.project.controller;



import com.haijiao.R;
import com.haijiao.project.entity.File;
import com.haijiao.project.service.FileService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hy
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/project/file")
public class FileController {

    private FileService fileService;

    //---1、新增文件----
    @PostMapping
    @ApiModelProperty(value="新增文件")
    public R addFile(@ApiParam(name="file", value="文件对象", required =true)
                     @RequestBody File file) {

        boolean save= fileService.save(file);

        if (save) {
            return R.ok();
        }
        else {
            return R.error();
        }
    }


    //-----3、根据id删除文件-----
    @ApiOperation(value = "根据id删除文件")
    @DeleteMapping("{id}")
//    //@PreAuthorize("hasAuthority('order:delete')")
    public R removeById(
            @ApiParam(name = "id", value = "文件ID", required = true)
            @PathVariable Integer id){
        boolean flag = fileService.removeById(id);
        if (flag) {
            return R.ok();
        }else {
            return R.error();
        }
    }




}

