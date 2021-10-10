<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<fmt:setBundle basename="com.theo.lab2corect.DTO.Message" var="lang"/>
<br/>
<form method="POST" action="store" autocomplete="off">
    <jsp:useBean id="categories" scope="request" class="com.theo.lab2corect.DTO.Category"/>
    <fmt:message key="Category" bundle="${lang}"/>Category:
    <select name="categorySelect" id="categorySelect">
        <%
            for (String category : categories.getCategories()) {
                out.println(String.format("<option value=\"%s\" >%s</option>", category, category));
            }
        %>
    </select>
    <br>
    <fmt:message key="Key" bundle="${lang}"/>Key:
    <input type="text" name="key" size="20" value=""/> <br/>
    <fmt:message key="Value" bundle="${lang}"/>Value:
    <input type="text" name="name" size="20" value=""/> <br/>
    <input type="submit" name="submit" >
</body>
</html>