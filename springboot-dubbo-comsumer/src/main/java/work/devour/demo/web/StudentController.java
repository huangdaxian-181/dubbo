package work.devour.demo.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import entity.EntityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentService;
import utils.KafkaUtils;
import utils.ResponseUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.consumer.KafkaConsumer;


/**
 * @author 搬砖的码农
 * @date 2022/05/19
 * @email
 **/
@Controller
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Reference
    private StudentService studentService;


    @GetMapping(value = "/count")
    @ResponseBody
    public Object count() {
        Integer i = studentService.queryAllStudentCount();
        return "学生总人数：" + i;
    }

    @GetMapping(value = "/sum")
    @ResponseBody
    public Object sum() {
        Object sum = studentService.querySum();

        return "班级:" + sum;
    }


    @GetMapping(value = "/test")
    @ResponseBody
    public Object test() {
        return ResponseUtils.Success(EntityResponse.SUCCESS_STATUS.getCode(), "查询成功", 200);
    }


    @GetMapping(value = "/demo1")
    @ResponseBody
    public void demo1() {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name","李四");
        jsonObject.put("date","2022-5-25 10:9:89");
        jsonObject.put("message","王武");

        String servers = "localhost:9092";
        String topic = "dubbo-kafka-logger";

        KafkaProducer<String, String> producer = KafkaUtils.createProducer(servers);

        KafkaUtils.send(producer, topic, jsonObject.toJSONString());

        //kafka消费者
        KafkaConsumer<String, String> consumer = KafkaUtils.createConsumer(servers, topic);

        KafkaUtils.readMessage(consumer, 100);

    }
}
