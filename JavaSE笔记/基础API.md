##现学现用
难在不知道要做什么---需求问题

#Object--万类之祖
    Java，不需要import就能引用到的类
    第一种：java.lang下面的包。
    Java语言中的java.lang包是由编译器直接自动导入的，
    java.lang包是Java语言的核心类库，包括了运行Java程序必不可少的系统类，
    如基本数据类型、基本数学函数、字符串处理、线程、异常处理类等。
    每个Java程序运行时，系统都会自动地引入java.lang包，所以这个包的加载是缺省的。
    有没有注意到，你使用System/Exception/Math/String不需要import，因为这些类在java.lang下。
    java.lang是Java的基础类，唯一的，基础类，Java默认会import，
    所以java.lang下面的类不需要import。
    
    第二种：同包。

###     hashcode()  哈希值是根据哈希算法将地址值换算出来的整数值.不是实际地址值     
        不同对象的哈希值,可同可不同(存在引用赋值,同一个对象肯定相等)
###     getClass() 字节码文件对象(运行时类)
            ||
###     toString()  对象字符串表示(object中是getClass@16(hashcode)组合)
        直接输出对象名称  其实就是  输出对象的toString方法
###     equals()    比对象相等?  比的是引用类型  ，基本类型不能调用方法！
    但源码用  return(this == obj) 默认比的是地址值,意义不大
        == 比较的是 值,地址值
        重写:比较成员变量的内容是否相同.用==和String的equals()
        引用类型不能用==(地址值)比较.应该用equals比较(String类的equals重写了Object,比的是内容)
        
        对象 instanceof 类
        
###     protected finalize()    用于垃圾回收，什么时候回收，不知道。
###     protected close()     

##      protected访问范围是在异包子类中，不是其他类中，子类对象在其他类中也不行！！
###        重写可以解决无法调用object中的protected问题？？
        使用范围最高到异包子类，异包非子类就不行了，lang包和自定义的包为异包。
        testDemo里的main方法就是异包非子类。所以无法调用close() ！！
        重写clone()后,就变为同包非子类了，可以调用。
        
        
        没有方法的接口：标记接口，Cloneable，
        告诉我们：实现该接口的类就可以实现对象复制！
        使用标记接口的唯一目的是使得可以用instanceof进行类型查询。
###     浅克隆，与原来是独立的，改动不受影响。而两个引用指向同一个，改动有关系。











