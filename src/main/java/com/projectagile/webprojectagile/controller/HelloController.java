package com.projectagile.webprojectagile.controller;



import com.projectagile.webprojectagile.entity.TestClass;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.TestClassServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(path = "/test")
public class HelloController {

    @Autowired
    TestClassServiceImpl testClassService;

    @GetMapping("/hello")
    @ResponseBody
    public String helloTest(){
        System.out.println("helloTest called");
        return "Hello world!";
    }

    @GetMapping("/testadd/{text}")
    @ResponseBody
    public BaseResVO testAddTestClass(@PathVariable String text){
        TestClass testClass = testClassService.addTestClass(new TestClass(text));
        if(testClass != null){
            return ResultVOUtils.success(testClass);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    @GetMapping("/testfind/{id}")
    @ResponseBody
    public BaseResVO testFindTestClass(@PathVariable int id){
        TestClass testClass = testClassService.findTestClassById(id);
        if(testClass != null){
            return ResultVOUtils.success(testClass);
        } else {
            return ResultVOUtils.error(ResultEnum.DATA_NOT);
        }
    }

    @GetMapping("/testfindall")
    @ResponseBody
    public BaseResVO testFindAllTestClass(){
        List<TestClass> listTestClass = testClassService.findAllTestClass();
        if(listTestClass != null){
            return ResultVOUtils.success(listTestClass);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }
}
