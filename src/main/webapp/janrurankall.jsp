<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*,control.*,java.util.*"%>
<%
List<Record> list = (List<Record>) request.getAttribute("list");
%>
<%@ page import="beans.Record"%>
未使用
<!DOCTYPE html>
<html>
<head>
<title>社会科ドリル</title>
</head>
<body bgcolor="#e8f7f0">
	<div align="center">
		<%
		if (list.size() == 0) {
		%>
		<p>
			<font size="6"> 読書記録がありません．</a></br></font>
		</p>
		<%
		} else {
		%>

		<table class="table">
			<thead>
			<tbody>
			</thead>
			<meta charset="UTF-8">
			<title>結果セット</title>
			</head>
			<body>
				<%
				if (list != null && list.size() > 0) {
				%>
				<table border="1">
					<%
					for (Record record : list) {
					%>
					<tr>
						<td><%=record.getTitle()%></td>
						<td><%=record.getReview()%></td>
					</tr>
					<%
					}
					%>
				</table>
				<%
				}
				%>
				<%}%>
				<p>
					<font size="4"><a href="./index.jsp" style="color:#ff6347;">トップ画面へ</a></br></font>
				</p>
				</div>
			</body>
			</html>