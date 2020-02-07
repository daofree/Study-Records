<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>服务器正忙...isErrorPage="true"可以用exception </h1>
    <%
        String message = exception.getMessage();
        out.print(message);

    %>
</body>
</html>
