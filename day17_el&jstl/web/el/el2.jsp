<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的值</title>
</head>
<body>
    <%
        // 在域中存储数据
        session.setAttribute("name","李四");
        request.setAttribute("name","zhangsan");
        session.setAttribute("age","23");


        request.setAttribute("str","");
    %>

<h3>el 获取域中的值</h3>
${requestScope.get("name")}
${requestScope.name}
    ${sessionScope.haha}

    ${name}
    ${sessionScope.name}
</body>
</html>
