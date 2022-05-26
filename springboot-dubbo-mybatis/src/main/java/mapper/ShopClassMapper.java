package mapper;

import domain.ShopClassDomain;

import java.util.List;

/**
 * 数据访问
 *
 * @author huangdaxian
 * @date 2022/05/22
 * @email 3081476398@qq.com
 **/
public interface ShopClassMapper {
    List<ShopClassDomain> queryAll();
}
