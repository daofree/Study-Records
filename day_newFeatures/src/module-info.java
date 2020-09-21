import com.daofree.service.MyService;

module day.newFeatures {
    //明确依赖哪些模块名，才能使用requires 模块名;
    requires day.newModule;
    requires junit;

    uses MyService;
}