package utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * 返回提示公共类
 *
 * @author 搬砖的码农
 * @date 2022/05/21
 * @email
 **/
public class ResponseUtils {
      public static ResponseEntity Success(int status, String message, Object data){
           Map<String,Object> map = new HashMap<>(3);

           map.put("code",status);

           map.put("message",message);

           map.put("data",data);

           return new ResponseEntity<>(map, HttpStatus.OK);
      }
}
