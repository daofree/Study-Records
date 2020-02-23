<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello maven!--再查找资料，发现Maven中的Tomcat是6.0.29,这个版本的不支持jdk1.8。我…
    不慌，加上一个插件，tomcat7…接着来！用的是tomcat7:run;
    如果继续用tomcat:run还是会使用Maven的Tomcat6;会继续出错…</h2>
https://blog.csdn.net/gaoxin_gx/article/details/100085161
<hr>
The full stack trace of the root cause is available in the Apache Tomcat/6.0.29 logs.
-DarchetypeCatalog=internal
<hr>
Unable to import Maven project
<hr>
后面发现好像是我用的maven版本问题（可能版本高了），<hr>
我用的3.6.2，然后我用idea自带的maven3.6.1或者去下个低版本的maven，解决问题。
</body>
</html>
