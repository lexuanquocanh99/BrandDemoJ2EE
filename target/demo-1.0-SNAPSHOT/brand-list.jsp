<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 6/30/2021
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Brand Management Application</title>
</head>
<body>
<center>
    <h1>Brand Management</h1>
    <h2>
        <a href="/newbrand">Add New Brand</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/listbrand">List All Brands</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Brands</h2></caption>
        <tr>
            <th>ID</th>
            <th>Ten</th>
            <th>Trang Thai</th>
            <th>Mo Ta</th>
            <th></th>
        </tr>
        <c:forEach var="brand" items="${listBrand}">
            <tr>
                <td><c:out value="${brand.id}" /></td>
                <td><c:out value="${brand.ten}" /></td>
                <td><c:out value="${brand.trangthai}" /></td>
                <td><c:out value="${brand.mota}" /></td>
                <td>
                    <a href="/editbrand?id=<c:out value='${brand.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/deletebrand?id=<c:out value='${brand.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
