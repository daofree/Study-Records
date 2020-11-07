application.xml 管业务代码

配置文件--反射--无注解不反射，无反射不框架

spring的配置文件，就是他的容器！
容器里面装对象

DAO配置文件--SqlSession工厂 数据源（连接池）扫描生成对象
Service层配置文件 --组件扫描 事务管理（AOP两个切入点，切入点与通知即增强类，框架提供的事务管理器就是增强类组成切面）


aop--幻灭指
spring默认监听器，监听web-inf下的application.xml，而mvn打包后，配置文件在web-inf/classes里面


建议
自己的类用注解，框架的类使用配置文件
结合的方式


编译期间的依赖关系，依赖没有jar包就会编译失败
类之间方法之间

没有jar包
DriverManager.registerDriver(new com.mysql.jdbc.Driver());---编译期异常
Class.forName("com.mysql.jdbc.Driver");---运行期异常

实际开发中，应做到编译期间不依赖，运行期间依赖

解决办法：
    反射创建对象，避免new；
    读取配置文件
    
    
Bean在计算机英语中，有可重用的组件的含义。业务层,持久层,实体类都是
JavaBean 用Java语言编写的可重用组件 (JavaBean > 实体类)

降低耦合，自己解决就是工厂类

让工厂类去读取配置文件，获取全路径，反射创建对象！
注意newInstance()每次都会调用默认构造函数创建对象！多例
如何解决多例问题?
初始化后存入map容器中，根据名称获取对象！key-id对象索引  value-对象

工厂反射，降低依赖---IOC控制反转
自己new -该类本身是知道的---
到 
Bean工厂根据配置的字符串反射拿，对象的产生该类不知的，全由框架负责

spring提供的降低耦合框架--IOC---对象创建交给框架--只解决依赖。
    依赖注入
    依赖查找   

 
核心容器 就是map，里面封装着对象. ApplicationContext对象


获取核心容器对象
ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
根据id获取对象
ac.getBean("");

ApplicationContext顶层BeanFactory,常用3个子类，两个xml，一个注解
历史原因
ApplicationContext-立即加载，读取完就创建对象--单例使用
顶层BeanFactory-  延迟加载 ---

创建bean的三种方式。
    id + class 直接类默认构造
        <constructor-arg>有参构造

        jar包中的类，是class文件，需要里面方法的返回值？
    factory-bean factory-method 指定某（工厂）类中方法创建
    factory-method 指定某（工厂）类中静态方法创建

bean的范围--5个值
    scope--singleton单例（默认），prototype多例，request请求，session会话，global-session全局（集群）
    验证码session。换服务器登录。
bean的生命周期
    单例-生死同容器
    多例-使用时创建，死亡靠垃圾回收
    

DI--依赖关系的维护 称为 依赖注入----（让类中使用的对象有值）解决空引用的问题

控制层调用业务层调用持久层，当前类 需要使用其他类对象，这个依赖
    这个依赖交给spring管理

注入什么？（让哪些对象有值？）最好不常变化的值
    基本类型和string  value
    其他bean         ref
    复杂类型/集合类型
    
注入方式
    构造（赋值） --只能有参构造
        bean中涉及标签<constructor-arg> name value ref-指定容器中其他bean即赋值
    set（属性赋值）--创建对象没有限制，可以直接使用默认构造
        要有set 方法
        <bean class>中涉及标签 <property name="">  name就是class的属性名称。注入属性要有set属性，否则不能触发
        集合类型，只分单列双列
    注解（赋值）@component ，不用set方法


spring容器是一个map容器。

使用注解 要配置xml扫描，注解解决不了集合注入 
但注解扫描的标签 在约束xmsn:context=""中（约束文件在spring-aop的jar包中）
        <context:component-scan base-package="">
    创建对象，都在自己写的类上 
        @component(value="") 没写value，默认key就是首字母小写。
        明确三层的注解
        @controller表现层
        @service业务层
        @repository持久层（@Mapper不能丢--不然springBoot不识别）
 
 @Repository需要在Spring中配置扫描地址，然后生成Dao层的Bean才能被注入到Service层中。
 @Mapper不需要配置扫描地址，通过xml里面的namespace里面的接口地址，生成了Bean后注入到Service层中。
 @Mapper 是 Mybatis 的注解，和 Spring 没有关系，@Repository 是 Spring 的注解，用于声明一个 Bean。（重要）

    注入数据（成员对象）
        @Autowired     自动按照类型注入（按类型直接在容器里找值） 类成员上使用。找同伙
            容器里有多个类型匹配，就看变量名与容器里的key是否一样
            @Qualifier(value=用于注入bean的id即key) 解决变量名匹配，辅助Autowired，指定注入谁。注入混乱问题。
            可单独在方法参数上，方法参数隐藏了Autowired。
        @Resource(name="id") 等于上面两个   
        以上两组三个，只能注解其他bean。 不能注入基本类型和String。
        @Value(value="" ${})注入基本类型和String
    改变作用范围 
        @Scope(value="")
    生命周期
        @PreDestroy 指定销毁方法
        @PostConstruct 指定初始化方法


    xml配置类对象时，用谁注谁！ 配置业务层 到 配置持久层（注入驱动，配置驱动，注入ref数据源） 到 配置数据源注入4要素
    配<bean><property name="" ref="">注
    
    
无论xml还是注解，配置扫描或者配置注入数据源，都少不了，只能注解自己写的类！ 数据源jar中的类？只有xml配置？

    @Configuration 作用==有bean.xml  是个配置类
    @ComponentScan(value="类路径")  创建容器指定要扫描,value要扫描的包 
            作用 == xml配置了<context:component-scan base-package="">，注意不能扫配置类！见下
            
    @Bean(name="runner")  把方法返回值作为Bean对象，存入ioc容器中需要的key是属性name。默认key值是方法名。 
          
    new QueryRunner(dataSource);  配置类中写          
            配置方法时，方法有参数，spring容器会找有没有Bean对象，查找方式同Autowired
    
    实现全注解后，要用这个，注意，在参数里的配置类的@Configuration可省，不在的配置类不能省        
    ac = new AnnotationConfigApplicationContext(配置类.class，JDBCUtils.class);
        即使配置了扫描路径，没有@Configuration，也失败。扫描包下所有类，先认配置类 才 扫类中注解。
    不想多写@Configuration，不想参数配置，
    就使用用于导入其他配置类的注解，配置类上@Import(JDBCUtils.class); 谁有@Import谁是父配置         
        
    @PropertySource("classpath:jdbc.porperties") 指定配置文件位置。灵活配置数据源
    
    
    Junit（自己集成main方法@Test）和 spring框架是分开的。不会使用ioc容器。
    解决：在test类上
        1.导入spring-test jar包
        2.@RunWith(SpringJUnit4ClassRunner.class) 换spring的运行器
        3.@ContextConfiguration(class=配置类.class) 提供容器信息
        这样test类中自动装配Autowired就可以生效了，可解决获取容器对象重复的问题
          @ContextConfiguration(locations="classpath:bean.xml")
    spring5以上，匹配junit4.12及以上        
        
        


AOP--动态代理

问题
    转账事务问题--多个数据库操作 需要一个connection控制。否则某个异常。整个事务就异常了
    ThreadLocal绑定与解绑connection
    事务控制一般在业务层控制。许多操作都要事务控制。开启提交回滚释放。大量重复。
        且事务管理类方法名依赖严重，一改全改
        
动态代理（不修改源码的基础上，对方法增强）
    结拜兄弟-基于接口-Proxy-JDK官方--敏感词汇过滤案例
        增强方法，执行任何被代理对象的接口方法都会执行
        限制：被代理对象必须要实现接口
        
    父子关系-基于子类-三方件-cglib
        Enhancer类-creat(字节码.class, 增强方法Callback的子接口 new 方法拦截MethodInterceptor);
        被代理类不能是最终类，能有子类就行       
    
    
动态代理 优化事务控制？ --代理 自己写的事务管理工具类
    这个业务类有很多数据库操作的方法。用动态代理的方式 对 这个类的所有方法进行事务增强！
    工厂类获取动态代理，事务控制和业务方法实现分离。
    
动态代理 解决了重复代码。解除了方法之间的依赖。但是配置有点繁琐。    
    
    
    AOP-在程序运行期间，不修改源码的基础上，对方法增强
    连接点Joinpoint-指类中所有方法
    切入点Pointcyt-对哪些连接点进行拦截的定义---不是所有方法都增强。被增强的方法叫切入点
    通知-动态代理invoke能拦截被代理对象中所有方法。公共代码。
            拦截后干的事。开启事务-前置通知。关闭事务-后置通知，异常通知，最终通知。整个invoke就是环绕通知（里面有切入点）
    织入--这个动态代理过程（把增强应用到目标对象来创建新的代理对象的过程）
            AspectJ采用编译器织入和类装载期织入
    目标对象
    代理对象
    切面-- 建立 切入点方法 和 通知方法 执行调用的对应关系。自己写就是增强方法的过程。配置呢？事务通知类，事务方法             
                
    公共代码制作成通知
    
    配置通知<bean id class>
    使用aop标签-- +约束文件 + 解析切入点表达式的jar---aspectjwarve
        <aop:config> 配aop
            <aop:aspect id="" ref="通知类id">--配切面
                <aop:before method="" pointcut="execution(切入点表达式)">  配置通知，建立切入点和通知方法关联关系（给切入表达式配通知）
                            method指定公共类的方法，即前置通知方法
                            切入点表达式(aspectjwarve解析): 指定增强哪些方法。全通配写法 * *..*.*(..)  
                            public(可省) void(*) 全路径类名.方法（参数）
                            * *..类.方法（参数）  包名用..表示当前包及其子包
                            类* 方法* 代替
                            参数 基本类型int，引用类型java.lang.string  *任意类型，但必有参数 ..有无参数均可
                         实际中：表达式切到业务实现类下的所有方法 * com.service.impl.*.*(..)
                 <aop:before method="" pointcut-ref="ss">           
                 <aop:pointcut id="ss" expression="execution(* com.service.impl.*.*(..))">    注意位置，否则报错。要先
        配置了环绕通知方法后，发现切入表达式方法不执行，执行的是环绕通知方法，为什么业务方法没执行？
        分析：对比动态代理invoke环绕过程，里面有切入点方法。 环绕通知方法里没有切入点方法 
                         环绕通知方法需要改造（ProceedingJoinPoint pjp）pjp.proceed()
        一个环绕通知方法 里面手动编码实现增强方法，可取代配置 前后异终通知。  环绕与4个不共存               
    切入点+通知=切面关系要建立                            

    注解aop <aop:aspectj-autoproxy>开启aop注解支持 == 配置类上增加 @EnableSspectJAutoProxy
        --注意，spring中，aop注解有顺序调用问题--最终(释放)在后置(提交)之前，顺序跑前面去了，操作不提交就关闭都白整。环绕没顺序问题
    @Aspect--当前类是一个切面类
    @Pointcut("execution(* com.service.impl.*.*(..))")private void pt(){}
    @Before("pt()")
     


声明式事务--增加约束xmlns:tx
    因为事务控制操作都是固定的！开启提交关闭等
    所以spring自己有事务通知，不用自己写通知类了（提交回滚）。spring自己提供的tx没有顺序问题。
    带有事务代码的具体实现类DataSourceTransactionManager
    
    配置事务管理器<bean id="tM" class="....DataSourceTransactionManager">注入数据源<property ref="">
    配置事务通知标签<tx:advice id="tA" transaction-manager="tM">
    配置aop<aop:config>
    切入点表达式<aop:pointcut id="pt" expression="...">
        对应关系<aop:advisor advice-ref="tA" pointcut-ref="pt">
    配置事务属性 <tx:advice><tx:attributes><tx:method name="切入点方法find*" 许多属性>
    

    开启事务注解支持 <tx:annotation-driven transaction-manager="">
    配置事务管理器
    @Transactional 属性都默认了。哪个业务方法需要事务，哪里方法上@
    
全注解需要配置类代替bean.xml，用new AnnotationConfigApplicationContext(配置类.class，JDBCUtils.class);
@ComponentScan("com.XXX.XXX") 指定扫描注解位置
@Import({JdbcConfig.class, TransactionConfig.class}) 子配置
@PropertySource("jdbcconfig.properties")
@EnableSspectJAutoProxy 开启事务注解支持
总配置类

事务相关配置类（创建事务管理器对象 new DataSourceTransactionManager(DataSource ds)） 
jdbc配置类 @Value("${jdbc.driver}")  @Bean(name="jdbcTmp")方法返回值 
       
       
编程式事务控制 每个业务方法都要事务模板对象 重写TransactionTemplate的execute()方法，又不灵活了，且重复---故了解
开启事务==关闭事务自动提交       