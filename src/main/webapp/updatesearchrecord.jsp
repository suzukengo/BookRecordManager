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
<body bgcolor="#e8f7f0">
	<div align="center">
		<%
		if (list.size() == 0) {
		%>
		<p>
			<font size="6"> 該当する記録がありません。</a></br></font>
		</p>
		
		<p>
			<font size="6"><a href = crud.jsp>別の記録を更新する。</a></br></font>
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
			<form action="./UpdateUser" method="post">
				<%
				if (list != null && list.size() > 0) {
				%>
				<table border="1">
					<%
					for (Record record : list) {
					%>
					<tr><td><input	required required type="radio" name="janru" value="<%=record.getJanru()%>"/></td> 
						<td><%=record.getJanru()%></td>
						<td><%=record.getPrivacy()%></td>
						<td><%=record.getThinking()%></td>
						<td><%=record.getIsbn()%></td>
						<td><%=record.getTitle()%></td>
						<td><%=record.getReview()%></td>
						<td><%=record.getId()%></td>
					</tr>
					<%
					}
					%>
				</table>
				<%
				}
				%>
				<%}%>
				<input type="submit" value="削除" />
				</form>
				
			<form action="./UpdateRecord" method="post">
			<font size="6">ID:</font> </br> 
			 <input	required required type="number" name="id"/> </br>
			
			<font size="6">題名:</font> </br> 
			 <input	required required type="text" name="title"/> </br>
			 
			 <font size="6">感想:</font> </br> 
			 <input	required required type="text" name="thinking"/> </br>
			
				<tr>
					<td>評価
			 <input	required required type="radio" name="review" value="1"/><font size="3">1</font> 
			 <input	required required type="radio" name="review" value="2"/><font size="3">2</font> 
				 <input	required required type="radio" name="review" value="3"/><font size="3">3</font> 
			 <input	required required type="radio" name="review" value="4"/><font size="3">4</font> 
				 <input	required required type="radio" name="review" value="5"/><font size="3">5</font></br> 
					</td>
				</tr>
			   
			 	 <input type="submit" value="更新" /></br>
				 
		</form>
	
				</div>
			</body>
			</html>