<%@ page language="java" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>読書記録管理アプリ</title>
</head>
<body bgcolor="#e8f7f0">
	<div align="center">
		<h1>読書記録管理アプリ</h1>
		<h2>ログインIDとパスワードを入力して下さい</h2>
		<form action="./LoginRiyousha" method="post">
			<table class="table_form">
				<tbody>
					<tr>
						<%-- ログイン済みの場合はIDを表示 --%>
						<th>ID</th>
						<td><input required type="number" name="id" /></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input required type="password" name="pass" /></td>
					</tr>
				</tbody>
			</table>
			<input class="common_button" type="submit" name="submit" value="ログイン" />
			</br>
		</form>
		<a href="./register.jsp">新規登録ボタン</a></font> </br> <font size="6">
	</div>
</body>
</html>