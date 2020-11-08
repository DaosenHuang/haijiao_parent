package com.haijiao.project.service.impl;

import com.haijiao.project.entity.File;
import com.haijiao.project.mapper.FileMapper;
import com.haijiao.project.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hy
 * @since 2020-10-26
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

}
