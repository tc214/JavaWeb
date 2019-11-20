package org.tc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tc.bean.UserInfo;
import org.tc.entiry.Rest;
import org.tc.entiry.RestBody;
import org.tc.service.SysUserService;
import javax.annotation.Resource;



@RestController
@RequestMapping("/test")
public class TestController {


    @Resource
    private SysUserService sysUserService;


    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        System.out.println("---------TestController executed--------");
        return "index";
    }

    @RequestMapping("/getUserInfo")
    public Rest getUserInfo(@RequestParam String userName) {
        UserInfo userInfo = sysUserService.findUserByName(userName);
        return RestBody.okData(userInfo);
    }

    @RequestMapping(value = "/getValue", method= RequestMethod.GET)
    public Rest getValueByKey(@RequestParam(value = "key") String key) {
        String value = sysUserService.getValueByKey(key);
        return RestBody.okData(value);
    }



}
