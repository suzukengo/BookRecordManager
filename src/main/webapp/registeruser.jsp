<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*,control.*,java.util.*"%>
<%
User list = (User) request.getAttribute("list");
%>
<%@ page import="beans.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社会ドリル</title>
</head>


<body bgcolor="#e8f7f0">
	<jsp:include page="beforeheader.jsp" />
	<div align="center">

	
		<h1>新規登録画面</h1>
		
		

		<form action="./RegistUser" method="post">
			<font size="6">氏名:</font> </br> 
			 <input	required required type="text" name="name"/> </br>
			 
			 <font size="6">性別:</font> 
			 <input type="radio" name="sex" value="男"/><font size="6">男:</font> 
			 <input	 type="radio" name="sex" value="女"/><font size="6">女:</font> </br>
			 
			 <font size="6">年齢:</font> </br> 
			 <input required type="text" name="age" pattern="[0-9]|[1-9][0-9]|[1][0-4][0-9]"/> </br>
			 
			 <font size="6">Password:</font> </br> 
			 <input	required required type="password" name="password1" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" minlength="6" /> </br>
			<font size="6">Password(確認):</font> </br> 
			 <input	required required type="password" name="password2" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" minlength="6" /> </br>
			 
			 <input	required required type="hidden" name="id" value="<%=list.getId()+1%>"/> </br>
			 <style>
				.common_button{
					/*追加*/color: #FFF;
					padding: 10px 20px;
					/*変更*/border: none;
					/*変更*/background: #f08080;
				}
				</style>	
			 <input class="common_button" type="submit" value="登録" /></br>
				 
				 パスワードは大小含む英数字6文字以上</br>
				 性別と年齢は任意です。</br>
		</form>
	</div>
</body>
</html>