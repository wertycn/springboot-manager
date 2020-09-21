package com.company.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.company.project.mapper.ShareDiagramMapMapper;
import com.company.project.entity.ShareDiagramMapEntity;
import com.company.project.service.ShareDiagramMapService;


@Service("shareDiagramMapService")
public class ShareDiagramMapServiceImpl extends ServiceImpl<ShareDiagramMapMapper, ShareDiagramMapEntity> implements ShareDiagramMapService {


}