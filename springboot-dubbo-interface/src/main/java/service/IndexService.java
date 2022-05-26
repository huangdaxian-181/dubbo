package service;

import java.util.List;

import domain.ShopClassDomain;
import domain.ShopRotationDomain;
/**
 * 首页接口类
 *
 * @author huangdaxian
 * @date 2022/05/21
 * @email 3081476398@qq.com
 **/
public interface IndexService {
    /**
     * 轮播图IndexService
     * */
    List<ShopRotationDomain> rotation();

    /**
     * 分类
     * */
    List<ShopClassDomain> categoryList();
 }
