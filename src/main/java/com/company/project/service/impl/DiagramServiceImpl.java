package com.company.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.company.project.mapper.DiagramMapper;
import com.company.project.entity.DiagramEntity;
import com.company.project.service.DiagramService;


@Service("diagramService")
public class DiagramServiceImpl extends ServiceImpl<DiagramMapper, DiagramEntity> implements DiagramService {


}