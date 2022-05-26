package mapper;

import domain.ShopRotationDomain;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 轮博mapper层
 *
 * @author huangdaxian
 * @date 2022/05/21
 * @email 3081476398@qq.com
 **/
@Mapper
public interface ShopRotationMapper {
    List<ShopRotationDomain> queryAll();
}
