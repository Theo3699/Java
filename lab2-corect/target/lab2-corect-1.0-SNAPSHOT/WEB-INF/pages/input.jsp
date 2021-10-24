<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<form method="POST" action="repository">
    <jsp:useBean id="categories" scope="request" class="com.theo.lab2.DTOs.Category"/>
    <label for="categorySelect">Category:</label>
    <select name="categorySelect" id="categorySelect">
        <%
            String lastCategorySelected=null;
            Cookie cookies[] = request.getCookies();
            if (cookies!=null){
                for (Cookie cookie: cookies){
                    if (cookie.getName().equals("CategorySelection")){
                        lastCategorySelected = cookie.getValue();
                    }
                }
            }
            //prints the categories
            for (String category : categories.getCategories()) {
                if (category.equals(lastCategorySelected)) {
                    out.println("<option value=" + category + " selected>" + category + "</option>");
                }
                else{
                    out.println("<option value=" + category + ">" + category + "</option>");
                }
            }
        %>
    </select>
    <br>
        <label for="key">Key:</label><br>
        <input type="text" id="key" name="key"><br>
        <label for="value">Value</label><br>
        <input type="text" id="value" name="value"><br>
        To continue, type the characters you see in the picture:<br>
        <img src="captcha"> <br>
        <label for="captchaString">Characters:</label>
        <input type="text" id="captchaString" name="captchaString"><br>
        <input type="submit" name="submit">
</body>
</html>