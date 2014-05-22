<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>图书管理</title>
</head>
<body>
	<h2>
		<s:if test="null == book">
            增加图书
        </s:if>
		<s:else>
            编辑图书
        </s:else>
	</h2>
	<form name="store" action="store.action" method="post">
		<table>
			<tr>
				<td><label for="store_book_isbn" class="label">ISBN:</label></td>
				<td>
					<!-- 编辑状态下图书编号不可修改 -->
					<input type="text" name="book.isbn" value="${book.isbn}" id="store_book_isbn"  
						<s:if test="null != book">
							readonly
						</s:if>
					/>
				</td>
			</tr>
			<tr>
				<td><label for="store_book_title" class="label">标题:</label></td>
				<td><input type="text" name="book.title" value="${book.title}" id="store_book_title" /></td>
			</tr>
			<tr>
				<td><label for="store_book_price" class="label">价格:</label></td>
				<td><input type="text" name="book.price" value="${book.price}" id="store_book_price" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="right">
							<input type="submit" value="提交" />
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>