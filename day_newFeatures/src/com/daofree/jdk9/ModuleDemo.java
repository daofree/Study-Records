package com.daofree.jdk9;


import com.daofree.entity.LvShi;
import com.daofree.service.MyService;
import com.daofree.service.impl.TiRen;

import java.util.ServiceLoader;

/**
 * @ClassName ModuleDemo
 * @Description: 模块化新特性---限制用其他模块里的代码
 *              描述性文件使用模块导出模块依赖进行配置并使用module_info.java
 * @Author DaoTianXia
 * @Date 2020-09-21-9:12
 * @Version V1.0
 **/
public class ModuleDemo {
    public static void main(String[] args) {
        LvShi lvShi = new LvShi("袁圣琼");
        lvShi.study();
        LvShi.suSong();

        System.out.println("--------------------");
        // 使用其他模块提供的服务化接口
        MyService ms = new TiRen();

        // 加载服务
        ServiceLoader<MyService> msload = ServiceLoader.load(MyService.class);
        // 遍历服务
        for (MyService myService : msload) {
            myService.service();
        }

    }
}
