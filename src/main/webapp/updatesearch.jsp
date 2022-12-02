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
		<h1>あなたのIDは？</h1>

		<form action="./SearchUp" method="post">

			 <font size="6">ID:</font> </br> 

			 <input	required required type="number" name="id"/> </br>
			 <style>
				.common_button{
					/*追加*/color: #FFF;
					padding: 10px 20px;
					/*変更*/border: none;
					/*変更*/background: #ff6347;
				}
				</style>
				 <input class="common_button"  type="submit" value="検索" /></br>
				 IDは他ユーザとの重複不可</br>
				 パスワードは大小含む英数字6文字以上</br>
		</form>
	</div>
</body>
</html>