springmvc.xml 管controller代码

web.xml 管servlet容器的-编码，监听，servlet分发器

与浏览器交互
M-模型-JavaBean-封装数据
V-视图-jsp-html-显示
C-控制器-Servlet--接受请求

表现层框架中一个注解就可代替servlet接口

依赖spring-web spring-webmvc


web.xml里面配置 前端控制器<servlet-class>DispatcherServlet
                                    <init-param>--要加载mvc配置文件
                                        属性<param-name>contextConfigLocation
                                        <param-value>classpath:springmvc.xml
mvc配置文件springmvc.xml
            -注解扫描--让ioc的注解生效 @Controller
            -视图解析器<bean id="" class="InternalResourceViewResolver"> -跳转
                            <property name="prefix" value="/WEB-INF/pages/"></property> 文件所在目录
                            <property name="suffix" value=".jsp"></property> 
            -开启mvc框架注解支持<mvc:annotation-driven />--让mvc的注解生效 @RequestMapping
            
@Controller创建对象-ioc容器
类
@RequestMapping(path="/hello")
方法return"success";mvc默认规则，返回字符串，就是jsp文件名

前端控制器--映射器--适配器--视图解析器


 @RequestMapping("/saveAccount")  用于建立请求 URL 和处理请求方法之间的对应关系
 saveAccount(Account acc)类型可直接封装在方法参数里，传递基本类型。
    请求参数封装默认名称一致，否则方法参数 (@RequestParam("name") String username)
    
 JavaBean里包含引用类型User咋整？表单里name=user.name 集合类型List[0].name  map["one"].age
 中文乱码？ post请求
 web.xml配置过滤器 CharacterEncodingFilter
 日期2020-11-11提交封装异常。
    自定义类型转换器实现Converter 
    mvc.xml里给类型转换器工厂ConversionServiceFactoryBean注入自定义类型转换类（自定义新增一个）
    mvc注解再支持<mvc:annotation-driven conversion-service=""/> 让增加这个类型转换生效（处理器映射器已生效了）
    
 
 
 @RequestBody获取请求体内容 get不适用。  方法参数(@RequestBody("name") String body)  会封装成name=hehe&age=20
 @PathVaribale 路径变量（绑定url的占位符）   方法参数(@PathVaribale("id") Integer id)  获取rest路径带来的参数
    @RequestMapping(value="/testurl/{id}", method=Request.POST)
        方法参数(@PathVaribale("id") String id)  可获取占位符的值（请求路径testurl/testurl/10传过来的）
 restful风格--请求地址都一样（利缓存），根据请求方式执行不同方法。（对各种请求方式有要求）
 浏览器form表单只支持get/post HiddenHttpMethodFilter可以将浏览器器请求改为指定方式（其余7种），发送给我们的控制方法。
 
 @RequestHeader("accept")  获取请求消息头  方法参数(@RequestHeader("accept") String header)
 @CookieValue("JSESSIONID")  获得Cookie值
 @ModelAttribute 
    在方法上会在控制器的方法(请求参数进行覆盖封装！)之前执行。
    若ModelAttribute在无返回值的方法上，方法里需要map.put("abc", user)里。再在控制器方法参数里 (@ModelAttribute("abc") User user)
 @SessionAttributes 控制器方法间参数共享，写在类上
 
 
第二天---
响应
    String
        存到Model（JavaBean）中，帮存到request域中
    void 没有return字符串，默认返回映射路径.jsp，要么请求转发，要么重定向，要么直接响应 
    ModelAndView 
    
    return "forward:/WEB-INF/pages/success.jsp";
    return "redirect:/index.jsp";
    
    json mvc框架帮助封装 
        接收参数 （@ResponseBody User u）
        返回值 @ResponseBody User

mvc提供文件上传  >10K 产生临时文件。<10K生成缓存
    配置文件解析器对象 CommonsMultipartResolver
    跨服Jersey包 WebResource  Client.creat().resource(path + filename).put(upload.getBytes());
    
    
异常。默认上抛到浏览器。
    DispatcherServlet找异常处理器
    自定义实现HandlerExceptionResolver

拦截器--是SpringMVC框架独有的。拦截器只会对控制器中的方法进行拦截 ，预处理+后处理（视图跳转之前）+ 终处理
    <mvc:interceptors> 实现HandlerInterceptor接口三个方法预后终
     HandlerInterceptor接口中的方法 
    1. preHandle方法是controller方法执行前拦截的方法 
        可以使用request或者response跳转到指定的页面 
        return true放行，执行下一个拦截器，如果没有拦截器，执行controller中的方法。
        return false不放行，不会执行controller中的方法。 
    2. postHandle是controller方法执行后执行的方法，在JSP视图执行前。 
        可以使用request或者response跳转到指定的页面 
        如果指定了跳转的页面，那么controller方法跳转的页面将不会显示。
    3. postHandle方法是在JSP执行后执行 
        request或者response不能再跳转页面了


DispatcherServlet会拦截所有的请求，包括静态资源，比如js文件。
mvc.xml配置放行 <mvc:resources location="/js/" mapping="/js/**"/> 




