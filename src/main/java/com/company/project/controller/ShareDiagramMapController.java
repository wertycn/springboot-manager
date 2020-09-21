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

import com.company.project.entity.ShareDiagramMapEntity;
import com.company.project.service.ShareDiagramMapService;



/**
 * 分享
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2020-09-22 00:50:44
 */
@Controller
@RequestMapping("/")
public class ShareDiagramMapController {
    @Autowired
    private ShareDiagramMapService shareDiagramMapService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/shareDiagramMap")
    public String shareDiagramMap() {
        return "sharediagrammap/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("shareDiagramMap/add")
    @RequiresPermissions("shareDiagramMap:add")
    @ResponseBody
    public DataResult add(@RequestBody ShareDiagramMapEntity shareDiagramMap){
        shareDiagramMapService.save(shareDiagramMap);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("shareDiagramMap/delete")
    @RequiresPermissions("shareDiagramMap:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        shareDiagramMapService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("shareDiagramMap/update")
    @RequiresPermissions("shareDiagramMap:update")
    @ResponseBody
    public DataResult update(@RequestBody ShareDiagramMapEntity shareDiagramMap){
        shareDiagramMapService.updateById(shareDiagramMap);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("shareDiagramMap/listByPage")
    @RequiresPermissions("shareDiagramMap:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody ShareDiagramMapEntity shareDiagramMap){
        Page page = new Page(shareDiagramMap.getPage(), shareDiagramMap.getLimit());
        LambdaQueryWrapper<ShareDiagramMapEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(ShareDiagramMapEntity::getId, shareDiagramMap.getId());
        IPage<ShareDiagramMapEntity> iPage = shareDiagramMapService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}
