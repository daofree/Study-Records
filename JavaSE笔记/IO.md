    数据(资源文件)-->永久存储--->IO流(存储打开即读取)---->有问题-->异常
    文件夹与文件
 
 
 
#   异常 Throwable---
    严重问题Error 一般程序处理不了，内存溢出
    普通问题Exception
        编译期间:非RuntimeException- 必须处理。
            比如调用别人的方法，调用的方法本身抛出的。要么继续throws，要么就地try
        运行期间:RuntimeException-问题是代码问题，需要修改（判空判null），无需显示处理，也可作异常处理
    两种方案：
        A-try...catch...finally
        B-throws 
    
    注意：try里面的代码越少越好，why?
         放在try里面就要走异常处理机制，JVM需要开辟新的资源管理它，代码越多，资源开辟越多！
         try里面的代码出问题，就会抛出去，并找catch里对应异常匹配处理！
            catch必须从小到大！
         
    JDK7新特性
    try{
        ...
    }catch(异常1 |异常2 |异常3 ...e){
        ...
    }     
        注意：处理方式不一致，同类型统一处理！
              必须平级关系，不能有父类
        
    注意：
        在try里发现问题后，JVM会生成一个异常对象，然后抛出去和catch里的类进行匹配！
        如果该对象匹配到某个类型，就会执行该catch里的处理信息。
### 异常中的方法   
    
        getMessage();返回字符串
        toString(); 拼接异常信息返回字符串
        printStackTrace();把错误信息输出在控制台，再继续执行
        printStackTrace(PrintStream s); 保存在日志文件中
        
### throws 定义在功能方法时，需要把出现的问题暴露出来让调用者取处理时！
            编译器问题必须要处理！  直至最后抛给JVM处理。方法抛运行期异常可不处理...
             
###  throw + 对象---直接抛对象给JVM
        在功能方法内部出现某种情况，程序不能继续运行，需要继续跳转，就用throw把异常对象抛出。
        用throw + new 异常();  代替代码。  
                 
###  注意：运行时异常，不需要写异常声明！
           throw非运行时异常，就要写！throws       
      
##     throws与throw区别！
    方法声明后加类名        方法体内，加对象
    用逗号隔开多个异常       只抛一个对象
    抛出由调用者处理        抛出异常，由方法体语句处理
    只是可能不一定发生       执行throw一定发生
     
#   如何处理异常？
        功能内部可以处理/想继续运行就try
        处理不了/后续不需要运行就throws--最终抛给JVM，默认处理是停止
        
## finally 之前遇到JVM退出，比如System.exit(0);
            ·final 最终类，变量，方法
            ·finally 异常最后一步
            ·finalize() 是Object的一个方法，用于垃圾回收
      
#  catch里有return！
    ·finally是return前还是return后？在return 的中间！
        只要JVM还在，finally就一定会执行！
        return前执行，因为return后不能有东西！        
        执行的不是return a; 是return 30;
        这个返回路径就形成了！但是还有finally,就继续执行finally的内容。a = 40;
        之后回到以前的返回路径！走return 30;
        
    ·注意：  finally与return关键字之间的协调，return 先装配再返!       
            return a; <===> return 30; -->a = 40; -->return 30;
 
## 自定义异常！ 
        ·继承Exception
        ·继承RuntimeException
   自定义异常类的构造函数的参数-->super(message); -->--> Throwable(String message)
   --> private String detailMessage; 
   -->
    public String getMessage() {
        return detailMessage;
    }
   --> 
   
# 异常总结
   子类重写时，
   父类有异常，子类必须抛出相同异常或者父类异常子类，且不能抛出父类没有的；
   父类没有异常，子类绝不能抛，若有异常，只能try不能throws。
   
   
    
    
    
    
        
#   文件表达技术--File
#   递归
#   字节流
#   转换流
#   字符流
#   其他流

