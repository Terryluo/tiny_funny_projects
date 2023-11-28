<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - My Calculator</title>
</head>
<body>
<h1><%= "My Calculator" %>
</h1>
<form action="calculatorServlet" method="get">
    please enter the Integer A <input type="number" name="numberA" value="0" max="2147483647" min="-2147483648"/><br>
    please enter the Integer B <input type="number" name="numberB" value="0" max="2147483647" min="-2147483648"/><br>
    please select the calculation method A
    <select name="operand">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
        <option value="^">^</option>
    </select>&nbsp;B<br>
    <input type="submit"/>
</form>
<span style="color: black; font-size: 16px"><%= request.getAttribute("msg") == null ? "We will get the result here" : request.getAttribute("msg")%></span>
</body>
</html>