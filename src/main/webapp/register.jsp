<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社会ドリル</title>
</head>


<body bgcolor="#e8f7f0">
	<jsp:include page="header.jsp" />
	<div align="center">
		<h1>新規登録画面</h1>

		<form action="./RegistUser" method="post">
			<font size="6">氏名:</font> </br> 
			 <input	required required type="text" name="name"/> </br>
			 
			 <font size="6">性別:</font> 
			 <input	required required type="radio" name="sex" value="男"/><font size="6">男:</font> 
			 <input	required required type="radio" name="sex" value="女"/><font size="6">女:</font> </br>
			 
			 <font size="6">年齢:</font> </br> 
			 <input	required required type="text" name="age"/> </br>
			 
			 <font size="6">Passweord:</font> </br> 
			 <input	required required type="text" name="password" /> </br>
			<font size="6">Passweord(確認):</font> </br> 
			 <input	required required type="text" name="password" /> </br>
			 
			 <font size="6">ID:</font> </br> 
			 <input	required required type="number" name="id"/> </br>
				 <input type="submit" value="登録" /></br>
				 IDは他ユーザとの重複不可</br>
				 パスワードは大小含む英数字6文字以上</br>
		</form>
	</div>
</body>
</html>