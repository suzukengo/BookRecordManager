<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="beans.User" %>
<% 
	User login = (User)session.getAttribute("user_db"); 
%>
<div align="left">
	<a>ログインID:<%=login.getId() %></a></br>
	<a>氏名:<%=login.getName() %></a></br>
	
</div>
<div align="right">
	<a href="./index.jsp" style="color:#b480f0;">前の画面に戻る</a>

</div>