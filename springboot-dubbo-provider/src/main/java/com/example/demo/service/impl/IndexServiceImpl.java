package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import domain.ShopClassDomain;
import mapper.ShopClassMapper;
import mapper.ShopRotationMapper;
import service.IndexService;
import pattern.SingleMybatisPattern;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import domain.ShopRotationDomain;

/**
 * 接口业务类
 *
 * @author 搬砖的码农
 * @date 2022/05/21
 * @email
 **/
@Service(interfaceClass = IndexService.class,timeout = 15000)
public class IndexServiceImpl implements IndexService {
    /**
     * 首页轮播图
     */
    @Override
    public List<ShopRotationDomain> rotation() {
        SqlSession ss = SingleMybatisPattern.getInstance().getSingle();

        ShopRotationMapper s = ss.getMapper(ShopRotationMapper.class);

        List<ShopRotationDomain> list = s.queryAll();

        return list;
    }


    /**
     * 分类
     */
    @Override
    public List<ShopClassDomain> categoryList() {

        SqlSession ss = SingleMybatisPattern.getInstance().getSingle();

        ShopClassMapper sc = ss.getMapper(ShopClassMapper.class);

        List<ShopClassDomain> scList = sc.queryAll();

        return scList;
    }
}
