package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName QuickController
 * @Description: controller
 * @Author DaoTianXia
 * @Date 2020-10-16-18:23
 * @Version V1.0
 **/
@Controller
@ConfigurationProperties(prefix = "user")
public class QuickController {

    @Value("${name}")
    private String name;
    private Integer age;
    private String uname;

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        System.out.println(name);
        return name + age + uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
