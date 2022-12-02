<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>中学社会ドリル</title>
</head>
<body bgcolor="#e8f7f0">
	<div align="center">
		<h1>ログインエラー</h1>
		<p>入力されたユーザは存在しません...</p>
		<form>
			<style>
				.common_button{
					/*追加*/color: #FFF;
					padding: 10px 20px;
					/*変更*/border: none;
					/*変更*/background: #ff6347;
				}
				</style>
			<input class="common_button" type="button"
				onclick="location.href='./index.jsp'" value="戻る" />
		</form>
	</div>
</body>
</html>