<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>图书列表</title>
    <style type="text/css">
        table {
            border: 1px solid black;
            border-collapse: collapse;
        }
        table thead tr th {
            border: 1px solid black;
            padding: 3px;
            background-color: #cccccc;
        }
        table tbody tr td {
            border: 1px solid black;
            padding: 3px;
        }
    </style>
</head>
<body>    
    <h2>图书列表</h2>
    <s:form action="remove" >
        <table cellspacing="0">
            <thead>
                <tr>
                    <th>选择</th>
                    <th>ISBN</th>
                    <th>标题</th>
                    <th>价格</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${books }" var="book">
                    <tr>
                        <td><input type="checkbox" name="isbns" value='${book.isbn}' /></td>
                        <td>${book.isbn }</td>
                        <td>${book.title}</td>
                        <td>￥${book.price}</td>
                        <td>
                            <a href='edit.action?isbn=${book.isbn}'>编辑</a>
                            &nbsp;
                            <a href='remove.action?isbn=${book.isbn}'>删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <s:submit value="删除" /><a href="BookEdit.jsp">增加图书</a>
    </s:form>    
</body>
</html>