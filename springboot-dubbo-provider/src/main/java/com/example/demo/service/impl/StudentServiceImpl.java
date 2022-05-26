package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import service.StudentService;

/**
 * @author 搬砖的码农
 * @date 2022/05/19
 * @email
 **/
@Service(interfaceClass = StudentService.class,timeout = 15000)
public class StudentServiceImpl implements StudentService{

    @Override
    public Integer queryAllStudentCount(){
return 200;
    }


    @Override
    public Integer querySum(){
        return 1701;
    }
}
