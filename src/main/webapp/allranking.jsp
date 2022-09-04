<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社会ドリル</title>
</head>


<body bgcolor="#e8f7f0">
	<jsp:include page="headerkai.jsp" />
	<div align="center">
		<h1></h1>

		<form action="./SearchAllRecord" method="post">

				<input type="submit"value="検索" />
		</form>
	</div>
</body>
</html>