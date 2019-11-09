package org.tc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/home")
public class TestController {

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";  // 访问http://localhost:8088/home/index 会加载index.jsp页面
    }




}
