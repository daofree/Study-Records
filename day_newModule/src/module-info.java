import com.daofree.service.MyService;
import com.daofree.service.impl.DaRen;
import com.daofree.service.impl.TiRen;

module day.newModule {
    // 导出包名给其他模块用
    exports com.daofree.entity;

    // 提供服务
    exports com.daofree.service;
    exports com.daofree.service.impl;

    // 指定服务实现类
    provides MyService with TiRen;
}