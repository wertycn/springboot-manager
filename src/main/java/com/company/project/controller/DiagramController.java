package com.company.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import com.company.project.common.utils.DataResult;

import com.company.project.entity.DiagramEntity;
import com.company.project.service.DiagramService;



/**
 * 图
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2020-09-22 00:50:58
 */
@Controller
@RequestMapping("/")
public class DiagramController {
    @Autowired
    private DiagramService diagramService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/diagram")
    public String diagram() {
        return "diagram/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("diagram/add")
    @RequiresPermissions("diagram:add")
    @ResponseBody
    public DataResult add(@RequestBody DiagramEntity diagram){
        diagramService.save(diagram);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("diagram/delete")
    @RequiresPermissions("diagram:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        diagramService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("diagram/update")
    @RequiresPermissions("diagram:update")
    @ResponseBody
    public DataResult update(@RequestBody DiagramEntity diagram){
        diagramService.updateById(diagram);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("diagram/listByPage")
    @RequiresPermissions("diagram:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody DiagramEntity diagram){
        Page page = new Page(diagram.getPage(), diagram.getLimit());
        LambdaQueryWrapper<DiagramEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(DiagramEntity::getId, diagram.getId());
        IPage<DiagramEntity> iPage = diagramService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}
