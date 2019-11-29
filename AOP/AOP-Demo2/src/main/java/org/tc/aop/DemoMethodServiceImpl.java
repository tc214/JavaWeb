package org.tc.aop;

import org.springframework.stereotype.Service;

/**
 * 使用方法规则的被拦截类
 */

@Service
public class DemoMethodServiceImpl {


    public void add() {
        System.out.println("DemoMethodServiceImpl.add(): add方法执行了！");

    }
}
