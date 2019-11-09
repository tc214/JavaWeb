package org.tc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("index start...");
        // 根据Thymeleaf默认模板，将返回resources/templates/index.html
        return "index";
    }
}
