package org.tc.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @RequestMapping(value="/main")
    public String main(){
        System.out.println("MainController main方法被调用......");
        // 根据Thymeleaf默认模板，将返回resources/templates/main.html
        return "main";
    }

}
/**
 * @Controller和@RestController区别:
 * 前者返回html，后者返回json数据
 */
