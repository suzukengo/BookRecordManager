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
			<style>
				.common_button{
					/*追加*/color: #FFF;
					padding: 10px 20px;
					/*変更*/border: none;
					/*変更*/background: #ff6347;
				}
				</style>
			<input class="common_button" type="submit" name="submit" value="ログイン" />
			</br>
		</form>
		</br>
		</br>
		
		<form action="./SearchUser3" method="post">
			<input class="common_button" type="submit" name="submit" value="新規登録" />
		</form>
	</div>
</body>
</html>