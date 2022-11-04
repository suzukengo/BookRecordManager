<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*"%>
<!doctype html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ユーザー情報変更画面</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- CSSの設定ファイル -->
    <link rel="stylesheet" href="css/index.css">
</head>

<body class="text-center">
    <div class="fixed-top">
        <jsp:include page="headerkai.jsp"/>
    </div>
    <div class="form-signin w-100 m-auto">
            <h1>ユーザー情報変更</h1>
        <div class="text-center card">
        <div class="card-body">
        <img class="mb-4" src="icons/person-circle.svg" alt="" width="72" height="57" loading="lazy">
        <h1 class="h3 mb-3 fw-normal">以下の項目を入力してください</h1>
        パスワードは大小含む英数字6文字以上</br>
        性別と年齢は任意です。</br>
        <form action="./UpdateUser" method="post">
            <font size="6">氏名:</font> </br>
			<input	required required type="text" name="name"/> </br>
			<font size="6">性別:</font>
			<input	required required type="radio" name="sex" value="男"/><font size="6">男:</font>
			<input	required required type="radio" name="sex" value="女"/><font size="6">女:</font> </br>
			<font size="6">年齢:</font> </br>
			<input required type="text" name="age" pattern="[0-9]|[1-9][0-9]|[1][0-4][0-9]"/> </br>
			<font size="6">パスワード:</font> </br>
			<input	required required type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" minlength="6" /> </br>
			<font size="6">パスワード(確認):</font> </br>
			<input	required required type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" minlength="6" /> </br>
			<font size="6">ID:</font> </br>
			<input	required required type="number" name="id"/> </br>
			<input class="common_button" type="submit" value="変更" /></br>
		</form>
        </div>
        </div>
        <div class="form-check mb-3">
        </div>
    </div>

    <script src="js/bootstrap.bundle.min.js" ></script>
</body>
</html>