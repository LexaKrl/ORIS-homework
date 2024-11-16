<%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 08.11.2024
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>

<%--<%
    String user = null;
    String sessionUser = (String) session.getAttribute("user");
    if (sessionUser == null) {
        response.sendRedirect("index.html");
    } else {
        user = sessionUser;
    }

    String cookieUser = null;
    String sessionId = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("user".equalsIgnoreCase(c.getName())) {
                cookieUser = c.getValue();
            }
        }
    }
%>--%>

<%
    String user = null;
    String sessionUser = (String) session.getAttribute("user");
    if (sessionUser == null) {
        response.sendRedirect("index.html");
    } else {
        user = sessionUser;
    }

    String cookieUser = null;
    String sessionId = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("user".equalsIgnoreCase(c.getName())) {
                cookieUser = c.getValue();
            } else if ("jsessionid".equalsIgnoreCase(c.getName())){
                sessionId = c.getValue();
            }
        }
    } else {
        sessionId = session.getId();
    }



%>

<h3>
    Hello, <%=user%>! Login Successful!
    <br>
    SessionID: <%=sessionId%>
    <br>
    Cookie user: <%=cookieUser%>
</h3>

</body>
</html>
