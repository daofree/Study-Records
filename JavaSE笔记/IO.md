#   IO流
    处理设备之间的数据传输，比如上传下载
    Java对数据的操作是通过流的方式
    Java用于流的对象都在IO包中
    
### 分类：用程序控制硬盘的文件，先找文件，再读，再写...站在程序的角度！（参照物）
        按流向
            输入  读取数据
            输出  写出数据
        默认按数据类型
            ·字节流byte
            ·字符流char  为了方便操作文本数据
                字节处理中文，要把一个汉字拆分成两个字节，最后再拼接
    使用：windows记事本能打开且读懂的用字符流(文本专用)，其他或者什么都不知道就用字节流。
         
    补充：
          ·数据存储是以“字节”（Byte）为单位，
          数据传输是以大多是以“位”（度bit，又名“比特”）为单位。
        字节表示码有：
          ·ASCII码：一个字符大小是一个字节
          ·UTF-8编码：一个英文字符等于一个字节，一个中文（含繁体）等于三个字节。
          中文标点占三容个字节，英文标点占一个字节。
          ·Unicode编码：一个英文等于两个字节，一个中文（含繁体）等于两个字节。
          中文标点占两个字节，英文标点占两个字节。
          
          
##   字节流-基类InputStream，OutputStream
###        输出  FileInputStream
    创建字节输出流做了几件事？
        1.调用系统功能（基础平台）去创建文件（系统会管理这个文件，打开）
        2.创建输出流对象
        3.把输出流对象指向这个文件
    why close()?
        1.把流对象变成垃圾，回收。不再使用
        2.通知系统去释放与该文件相关的资源，（让平台系统关闭资源，释放内存）
        
        write(int b);字节
        write(byte[] b);字节数组
        ·write(byte b[], int off, int len);
    ·数据换行
        写入换行符号\n,有些文本编辑器实现，
        但windos记事本打开却没换行，而是黑方块！
            不同系统针对不同的换行符号不一样，
            windows：\r\n
            Linux: \n
            mac: \r
        常用记事本软件可以识别所有换行符号！
    ·数据追加--与构造方法有关FileOutputStream(String name, boolean append);
    
###        输入FileInputStream
        ·两种读取方式：
            int read()；一次读取一个字节值（int），游标下移，类似迭代器的next(),
                返回-1，说明到末尾，换行也能读到
                ------强转(char)字节值（int）--(char)fileInputStream.read()
            ·int read(byte[] b); 一次读取一个字节数组
        
        ·注意：控制台中文乱码！ä¸­
            字节流读取中文，把一个汉字拆成两个字节值（int），再强转(char)，然后一个字节一个字节输出到控制台乱码   
                --字符流解决乱码
         
        ·复制文件，读取数据源 + 写入目的地，
            为啥复制中文没有乱码？ 
                IO流读取数据，写入文本文件，读一个字节，写一个字节，没做任何转换，它自己会转换！
        两个字节如何拼接成中文？（自己会转换？怎么做到的？）        
        （计算机中，中文分两个字节，第一个肯定是负数，第二个可能正，可能负，）
                英文字符串转换字节数是正数，中文字符串转换字节数是负数。
                所以如果是正数，不拼，如果是负数才拼接！

        ·备注：复制视频很大时，就会很慢，一次一个字节，16M的视频，1600多万个字节！while 1600多万次！硬盘坏了。。。。

###     一次读取一个字节数组！read(b)--返回的是实际读取的字节个数！
                    --->一次可读取的最大字节数----\r\n是两个字节
        最后一次几个会把上一次前几个覆盖，因为数组长度是5，最后一次只读了3个...所以覆盖了前3个...
        按标准b来读取，但最后一次或者第一次，可能实际读取不会是b！  所以new String(b,0,len)
        备注：字节数组的长度默认设置1024或者整数倍！    因为b-k-m-g转换是1024！               
        
##      字节缓冲区流---BufferedOutputStream/BufferedInputStream 自带缓冲区！
            --用数组缓冲区就是快！对OutputStream进行包装， 设计装饰设计模式！
        BufferedOutputStream(OuS o);默认缓冲区就够了8192
        BufferedOutputStream(OuS o; int size);    
        ·为啥参数是抽象类OutputStream对象？？而不是文件或者文件路径？
        因为字节缓冲区流只提供缓冲区，为高效设计的，真正的读写还得靠基本流！
            
        2种读取(一个字节，一个数组) X 2个操作类(基本类/高效类)
        
       
       
##   转换流：字节流操作中文不是很方便,把字节流转换成字符流！
##   编码表：字符+对应的数值组成一张表。ASCII/Unicode/ISO-8859-1/GB2312/GBK/GB18030/BIG5/UTF-8
            UTF-8最多是3个字节表示，分123个字节区间，能1就1，能2就2，不能就3，兼容性广！
            String(byte[] b, String charsetName) 通过指定字符集解码字节数组
            byte[] getBytes(String charsetName) 使用指定字符集把字符串编码为字节数组，无参就是本地默认
            例子：编码不一致，解析就会出现问题
                String s = "你好";
                byte[] b = s.getBytes();// 默认编码(本地GBK)
                byte[] b = s.getBytes("UTF-8");// UTF-8编码
                String ss = new String(b);// 默认解码(本地GBK)(中文2个组合)
                String ss = new String(b, "UTF-8");// UTF-8解码(中文3个组合)
            
##   字符流==字节流+编码表   -基类Reader,Writer--看构造就是一个转换流
        输入 
            OutputStreamWrite(OutputStream o);默认编码，把字节流转换为字符流
            OutputStreamWrite(OutputStream o, String charsetName);指定编码，把字节流转换为字符流
        
        5种写
            write(int s);写一个字符（两个字节）
            write(char[] s);写一个字符数组
            ·write(char[] s, int off, int len);写一个字符数组的一部分
            write(String s);写一个字符串
            write(String s, int off, int len);写一个字符串的一部分
        为什么数据没有进去？
            因为字符=2字节，而文件存储单位是字节。字符在缓冲区里。
            要flush();刷新缓冲区。close()关闭前也会刷新！
        
        输出
            InputStreamRead(InputStream is)
            InputStreamRead(InputStream is, String charsetName)
        4种读
            read();一次读一个字符
            ·read(char[] cbuf);一次读一个字符数组（将字符读入数组）
        复制案例：字符转换流    

### 转换流简化写法，OutputStreamWrite的直接子类FileWrite--便捷FileRead
        由于常见操作都是默认本地编码，不需要指定编码！！又由于转换流名称太长,所以...
        OutputStreamWrite = FileOutputStream + 编码表（默认）
        FileWrite = FileOutputStream + 编码表（默认）
        同理FileRead(File file)
        源码很简单，就是为了简写
        
       OutputStreamWrite ==> FileWrite(File file) ---> BufferedWriter
        
### 字符缓冲流---高效---包装字符流！                
        BufferedWriter(FileWrite fw)
        BufferedRead(FileRead fr)
        字符缓冲流<----转换流<--包装--字节流
        
    复制文本案例：字符流，基本2高效2，字节流，基本2高效2---8种方式
    复制图片案例：字节流，基本2高效2---4种方式
        
####     特殊方法：读一行，写不会换行
        BufferedWriter--newLine();写入一个由系统属性定义的行分隔符，跨平台       
        BufferedRead--readLine();读取一个文本行，即一次读一行，遇到\r\n回车等即该行终止...
                包含字符串，不包含终止符，即不会自动换行... 读不到返null
        ·写一行，换一行，刷一行  
              
     ·备注：字符流复制文本案例: 基本2 + 高效2 + 高特1  （字符，字符数组，一行）
                
##  小结：
        读字节/字符数组时，第一次/最后一次实际读到多少，就写多少。。。write(b, 0 , len);
        int b = 0;
        while((b=fid.read()) != -1){
            fos.write(b);
        }
        
        byte[] b = new byte[1024];
        int len = 0;
        while((len=fis.read(b)) != -1){
            fos.write(b, 0 , len);
        }
        
    案例：
        字符流复制文本5种方式
        复制图片4种方式，字节流
        文本内容--> ArrayList,只读不写（readLine()到，直接add）
        ArrayList--> 文本内容,只写不读（遍历集合，直接write(String s),newLine(),flush()）
        
        ·自实现readLine()案例
        while((ch = r.read()) != -1)){
            if(ch == '\n'){
                continue;
            }
            // 遇到换行就返回值，那么问题来了，最后一行没有换行咋整？（即-1）就没得返了？？
            if(ch == '\n'){
                return sb.toString();
            }else{
                sb.append((char)ch);//hello world java(-1)
            }
        }
        //最后一行没有换行，即遇到-1,终止while(return还在里面)， 即已经拼接好了，就是没返回
        if(sb.length() > 0){
            return sb.toString();
        }
        
### Read--BufferedReader--LineNumberReader
        自己实现特有功能：getLineNumber(),setLineNumber()--可以使用行号功能让代码发到外面加有行号！
        定义变量，读一行，就++。
        自定义类继承BufferedReader，添加LineNumber变量，然后++;更简单
        
        登录注册IO版
        判断：读字节用-1，读一行串string，用null
        static{}让程序一启动，文件已存在，防止高并发！
        
        
        
#   其他流
        背景：之前只能写：字节字节数组字符字符数组字符串
        操作基本数据类型的流--inter/double/boolean/... 
### 数据流
        DataInputStream(InputStream in)/DataOutputStream(OutputStream out)
        8种数据类型都有读写，要一一对应！但显示乱码？？


### 内存操作流----临时信息，程序结束，数据从内存中结束----关闭无效！
        字节数组
            ByteArrayInputStream()
            ByteArrayOutputStream()
        字符数组
            CharArrayReader()
            CharArrayWrite()
        字符串        
            StringReader()        
            StringWriter()


### 打印流---只写不能读
        字节打印/字符打印--PrintStream()/PrintWriter(...)
        操作任意类型---.print()，但println()能自动刷新
        自动刷新。println() == bw.write() + bw.flush() + bw.flush()
        该流可以直接操作文本文件：能传文件/字节流/文件路径/字符流
        
    备注：FileOutputStream/FileInputStream---FileReader/FileWriter都可以直接操作文件
        基本流：能直接读写文件
        高级流: 包装基本流，提供其他功能
        PrintStream()/PrintWriter既能操作基本流，又能操作高级流
        看API，查流的构造方法，如果同时又File/String类型的参数，一般来说就是可以直接操作文件的。        
        
### System类中流
###    标准输入in输出out流-----System类中静态成员变量in out--系统标准输入输出
        是个与IO流结合的类
        
        in: 默认输入设备 == 键盘
        out: 默认输入设备 == 显示器
        
        InputStream is = System.in;
        PrintStream ps = System.out;
        ps.println("hello world!");
    
## 键盘录入数据
    A. main方法的args接收参数
        java HelloWorld hello world java
    
    B. JDK5之后的new Scanner(System.in).nextLine();
    
    C. 字符缓冲流包装字符流，字符流包装标准字节输入流（转换流）
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    
### 随机访问流-不是流的流
    RandomAccessFile在io下但是是Object的子类，
    有InputStream和OutStream的功能。支持文件的随机访问和读写
        new RandomAccessFile(String filename, "rw");
    getFilePointer()  文件指针按数据类型的字节为单位。累计偏移
    readUTF---啥啥啥啥
    seek(4)定位读取
            
### 合并读流 SequenceInputStream--两个文本-->1个文本
        多个输入流串流在一起，合并为一个输入流。且排队读,只读不写,其他流写
    构造函数一
    SequenceInputStream(InputStream s1, InputStream s2);
    
    问多个流怎么办？？
        SequenceInputStream(SequenceInputStream s1, SequenceInputStream s2);
    
    ·另一个构造
    SequenceInputStream(Enumeration e)
    Enumeration的实现类，可有Vector的方法elements()方法.

# 序列化流---对象流----流对象---对象需要Serializable序列化接口，如String
    序列化：把对象按照流一样的方式，写入文件存储或者在网络中传输。对象-->流数据
    反序列化：把文本文件中的流对象数据或者网络中的流对象数据还原成对象。流数据-->对象
    
    序列化流ObjectOutputStream(new FileOutputStream("o.txt"))
        writeObject()  
    反序列化流ObjectIntputStream(new FileInputStream("o.txt"))
        readObject()
    
##  ?类的对象写完后即序列化后，类发生了改动的即类会不断迭代，再反序列化即读数据会报错！  
    不能每次重序列化，旧数据又丢失  
    InvalidClassExcertion-----SerialVersionUID不一样。
    只要类迭代，class文件的SerialVersionUID就会改变，除非写死！
    
    
### 备注
        自定义对象序列化！String 等引用类形已实现Serializable
        标记接口：Serializable-- JVM会在底层帮助实现相应功能！否则自己实现
        把对象转化为字节序列(class-bytes)
        当一个java程序打算将一个用于存储数据的类对像(用于存储学生信息的student类)的数据及属性
        通过网络发送给另一个java程序时如何做最方便？
        那就是将该java类对像序列化为一串连续的string后发送到对端，
        对端在接收到string后根据约定对其执行反序列化得到java类对象。
        
        只要我们对内存中的对象进行持久化或网络传输, 这个时候都需要序列化和反序列化.
### 补充：
###     什么时候需要用到序列化和反序列化呢?

        当我们只在本地JVM里运行下Java实例, 这个时候是不需要什么序列化和反序列化的,
        但当我们需要将内存中的对象持久化到磁盘, 数据库中时, 当我们需要与浏览器进行交互时, 
        当我们需要实现RPC时, 这个时候就需要序列化和反序列化了.
        
        前两个需要用到序列化和反序列化的场景, 是不是让我们有一个很大的疑问? 
        我们在与浏览器交互时, 还有将内存中的对象持久化到数据库中时,
        好像都没有去进行序列化和反序列化, 因为我们都没有实现Serializable接口, 但一直正常运行.
        理由:
        服务器与浏览器交互时真的没有用到Serializable接口吗? 
        JSON格式实际上就是将一个对象转化为字符串, 所以服务器与浏览器交互时的数据格式其实是字符串, 
        我们来看来String类型的源码
        String类型实现了Serializable接口, 并显示指定serialVersionUID的值.
        然后我们再来看对象持久化到数据库中时的情况, Mybatis数据库映射文件里的insert代码
        <insert id="insertUser" parameterType="org.tyshawn.bean.User">
            INSERT INTO t_user(name, age) VALUES (#{name}, #{age})
        </insert>
        实际上我们并不是将整个对象持久化到数据库中, 而是将对象中的属性持久化到数据库中, 
        而这些属性都是实现了Serializable接口的基本属性.
        
        
###     实现序列化和反序列化为什么要实现Serializable接口?
        在Java中实现了Serializable接口后, JVM会在底层帮我们实现序列化和反序列化, 
        如果我们不实现Serializable接口, 那自己去写一套序列化和反序列化代码也行, 
        至于具体怎么写, Google一下你就知道了.
        
###     实现Serializable接口就算了, 为什么还要显示指定serialVersionUID的值?
        如果不显示指定serialVersionUID, JVM在序列化时会根据属性自动生成一个serialVersionUID, 
        然后与属性一起序列化, 再进行持久化或网络传输. 
        在反序列化时, JVM会再根据属性自动生成一个新版serialVersionUID, 
        然后将这个新版serialVersionUID与序列化时生成的旧版serialVersionUID进行比较, 
        如果相同则反序列化成功, 否则报错.
        
        如果显示指定了serialVersionUID, JVM在序列化和反序列化时仍然都会生成一个serialVersionUID, 
        但值为我们显示指定的值, 这样在反序列化时新旧版本的serialVersionUID就一致了.
        在实际开发中, 不显示指定serialVersionUID的情况会导致什么问题? 
        如果我们的类写完后不再修改, 那当然不会有问题,
        但这在实际开发中是不可能的, 我们的类会不断迭代, 一旦类被修改了, 那旧对象反序列化就会报错. 
        所以在实际开发中, 我们都会显示指定一个serialVersionUID, 值是多少无所谓, 只要不变就行.
        
        被transient关键字修饰的属性不会被序列化, static属性也不会被序列化.
        敏感数据序列化，先签名，后加密，再序列化!
        
###     static属性为什么不会被序列化?
        因为序列化是针对对象而言的, 而static属性优先于对象存在, 
        随着类的加载而加载, 所以不会被序列化.
        看到这个结论, 是不是有人会问, serialVersionUID也被static修饰, 
###     为什么serialVersionUID会被序列化? 
        其实serialVersionUID属性并没有被序列化, 
        JVM在序列化对象时会自动生成一个serialVersionUID, 
        然后将我们显示指定的serialVersionUID属性值赋给自动生成的serialVersionUID.
        
        
#       类中流-->Properties类--->HashTable的子类-->Map集合啊
        Properties可保存流中，可流中加载，是个与IO流结合的属性集合类
        new Properties().put(Object, Object);
        
###        特有功能：看底层实现，换名限制入参，再调用put
        setProperty(String key, String value);只添加字符串
        getProperty(String key);获取
        stringPropertyNames();键集
        
###        Properties与IO流结合
        load(Reader reader);读文件数据到Properties集合
        store(Writer w; String comments);存储Properties集合中的数据到文件.comments注释
        
        
# NIO 即 newIO
           使用不同的方式来处理输入输出，采用内存映射文件的方式，
           将文件或者文件的一段区域映射到内存中，就可以像访问内存一样的来访问文件了。
           效率很高。 
###        JDK4出现的类：Buffer缓冲, Channer通道
###        JDK7的NIO的使用
                Path接口
                final class Paths---static get(URL );
                操作文件工具类
                final class Files---copy(Path source, OutputStream out);复制文件
                write(Path p, Iterable l, Charset cs, OpenOption ... options)
                把集合（Iterable）中的数据写到文件中                  
           Files.copy(Paths.get("XX.txt"), new FileOutputStream("copy.txt"));

           Files.write(Paths.get("array.txt"), array, Charset.forName("GBK"));
           
           
##  借鸡生蛋 Iterable + Enumeration + Path
        Properties prop = System.getProperties();
    
    
           