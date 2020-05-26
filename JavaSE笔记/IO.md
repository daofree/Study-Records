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
        ArrayList--> 文本内容,只写不读（遍历集合，直接write(),newLine(),flush()）
        
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
##   其他流
