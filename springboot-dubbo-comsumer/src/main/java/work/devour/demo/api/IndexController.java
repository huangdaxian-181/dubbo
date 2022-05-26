package work.devour.demo.api;

import com.alibaba.dubbo.config.annotation.Reference;
import domain.ShopClassDomain;
import domain.ShopRotationDomain;
import entity.EntityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IndexService;
import utils.ResponseUtils;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 首页控制器
 *
 * @author 搬砖的码农
 * @date 2022 /05/21
 * @email
 */
@Controller
@CrossOrigin(origins = "*")
public class IndexController {
    @Reference(interfaceClass = IndexService.class )
    private IndexService indexService;

    /**
     * 轮播图
     *
     * @return the object
     */
    @GetMapping(value = "api/rotation")
    @ResponseBody
    public ResponseEntity<Object> rotation() {
        List<ShopRotationDomain> list =  indexService.rotation();

        return ResponseUtils.Success(EntityResponse.SUCCESS_STATUS.getCode(),"查询成功",list);
    }


    /**
     * 分类
     * */
    @GetMapping(value = "api/classList")
    @ResponseBody
    public ResponseEntity<Object> classList(){

        try{
            List<ShopClassDomain> list = indexService.categoryList();

            return ResponseUtils.Success(EntityResponse.SUCCESS_STATUS.getCode(),"查询成功",list);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
