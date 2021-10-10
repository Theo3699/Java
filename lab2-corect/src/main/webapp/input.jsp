<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<fmt:setBundle basename="com.javatpoint.Message" var="lang"/>
<br/>
<form method="POST" action="store" autocomplete="off">
    <jsp:useBean id="categories" scope="request" class="com.theo.lab2corect.DTO.Category"/>
    <fmt:message key="category" bundle="${msg}"/>:
    <select name="categorySelect" id="categorySelect">
        <%
            for (String category : categories.getCategories()) {
                out.println(String.format("<option value=\"%s\" >%s</option>", category, category));
            }
        %>
    </select>
    <br>
    <fmt:message key="key" bundle="${msg}"/>:
    <input type="text" name="key" size="20" value=""/> <br/>
    <fmt:message key="name" bundle="${msg}"/>:
    <input type="text" name="name" size="20" value=""/> <br/>
</body>
</html>