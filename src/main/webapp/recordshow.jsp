<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*,control.*,java.util.*"%>
<%
List<Record> list = (List<Record>) request.getAttribute("list");
%>
<%@ page import="beans.Record"%>

<!DOCTYPE html>
<html>
<head>
<title>読書記録表示</title>
</head>
<body bgcolor="#e8f7f0">
	<div align="center">
		<%
		if (list.size() == 0) {
		%>
		<p>
			<font size="6"> 該当する解答がありません．</a></br></font>
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
					<tr>
						<th>ジャンル</th>
						<th>感想</th>
						<th>ISBN</th>
						<th>タイトル</th>
						<th>評価</th>
						</tr>
					<%
					for (Record record : list) {
					%>
					<tr>
						<td><%=record.getJanru()%></td>
						<td><%=record.getThinking()%></td>
						<td><%=record.getIsbn()%></td>
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
					<font size="4"><a href="./loginOK.jsp" style="color:#ff6347;">トップ画面へ</a></br></font>
				</p>
				</div>
			</body>
			</html>