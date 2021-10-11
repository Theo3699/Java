<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<form method="POST" action="repository" autocomplete="off">
    <jsp:useBean id="categories" scope="request" class="com.theo.lab2corect.DTOs.Category"/>
    <label for="categorySelect">Category:</label>
    <select name="categorySelect" id="categorySelect">
        <%
            for (String category : categories.getCategories()) {
                out.println(String.format("<option value=\"%s\" >%s</option>", category, category));
            }
        %>
    </select>
    <br>
        <label for="key">Key:</label><br>
        <input type="text" id="key" name="key"><br>
        <label for="value">Value</label><br>
        <input type="text" id="value" name="value">
    <input type="submit" name="submit" >
</body>
</html>