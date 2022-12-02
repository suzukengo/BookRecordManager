<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*,control.*,java.util.*"%>
<%
List<Record> list = (List<Record>) request.getAttribute("list");
%>
<%@ page import="beans.Record"%>

<!DOCTYPE html>
<html>
<head>
<title>社会科ドリル</title>
</head>
<jsp:include page="headerkai.jsp" />
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
				<%! int count=0 ; %>
					<%
					for (Record record : list) {
					%>
					<tr>
						<td><%count++ ;%></td>
						<td><%=count%></td>
						<td><%=record.getTitle()%></td>
						<td><%=record.getReview()%></td>
					</tr>
					<%
					}
					%>
					<td><%count=0 ;%></td>
				</table>
				<%
				}
				%>
				<%}%>
				<p>
					<font size="4"><a href="./loginOK.jsp" style="color:#ff6347;" >トップ画面へ</a></br></font>
				</p>
				</div>
			</body>
			</html>