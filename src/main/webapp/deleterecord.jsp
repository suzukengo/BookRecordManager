<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*,control.*,java.util.*"%>
<%
List<Record> list = (List<Record>) request.getAttribute("list");
%>
<%@ page import="beans.Record"%>

<!DOCTYPE html>
<html>
<head>
<title>読書記録削除</title>
</head>
<body bgcolor="#e8f7f0">
	<div align="center">
		<%
		if (list.size() == 0) {
		%>
		<p>
			<font size="6"> 該当する記録がありません．</a></br></font>
		</p>
		<p>
			<font size="6"><a href=crud.jsp style="color:#ff6347;">別の記録を削除する</a> </br></font>
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
					<tr>
						<th>チェック</th>
						<th>ジャンル</th>
						<th>公開設定</th>
						<th>感想</th>
						<th>ISBN</th>
						<th>タイトル</th>
						<th>評価</th>
						<th>ID</th>
						</tr>
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
				<style>
					.common_button{
						/*追加*/color: #FFF;
						padding: 10px 20px;
						/*変更*/border: none;
						/*変更*/background: #ff6347;
					}
					</style>
				
				</form>
				
			<form action="./DeleteRecord" method="post">
			<font size="6">ID:</font> </br> 
			 <input	required required type="number" name="id"/> </br>
			
			<font size="6">題名:</font> </br> 
			 <input	required required type="text" name="title"/> </br>
			 <style>
				.common_button{
					/*追加*/color: #FFF;
					padding: 10px 20px;
					/*変更*/border: none;
					/*変更*/background: #ff6347;
				}
				</style>
			 	 <input class="common_button" type="submit" value="削除" /></br>
		</form>
	
				</div>
			</body>
			</html>