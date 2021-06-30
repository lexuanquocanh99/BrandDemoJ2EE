<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 6/30/2021
  Time: 2:49 PM
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
        <a href="newbrand">Add New Brand</a>
        &nbsp;&nbsp;&nbsp;
        <a href="listbrand">List All Brands</a>

    </h2>
</center>
<div align="center">
    <c:if test="${brand != null}">
    <form action="/updatebrand" method="post">
        </c:if>
        <c:if test="${brand == null}">
        <form action="/insertbrand" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${brand != null}">
                            Edit Brand
                        </c:if>
                        <c:if test="${brand == null}">
                            Add New Brand
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${brand != null}">
                    <input type="hidden" name="id" value="<c:out value='${brand.id}' />" />
                </c:if>
                <tr>
                    <th>Ten: </th>
                    <td>
                        <input type="text" name="ten" size="45"
                               value="<c:out value='${brand.ten}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Trang Thai: </th>
                    <td>
                        <input type="text" name="trangthai" size="1"
                               value="<c:out value='${brand.trangthai}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Mo Ta: </th>
                    <td>
                        <input type="text" name="mota" size="255"
                               value="<c:out value='${brand.mota}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
