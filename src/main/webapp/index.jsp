<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>読書記録管理アプリ</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" >

    <!-- CSSの設定ファイル -->
    <link rel="stylesheet" href="css/index.css">
</head>

<body class="text-center">
    <main class="form-signin w-100 m-auto">
            <h1>読書記録管理アプリ</h1>
        <form class="text-center card" action="./LoginRiyousha" method="post">
        <div class="card-body">
        <img class="mb-4" src="icons/book.svg" alt="" width="72" height="57" loading="lazy">
        <h1 class="h3 mb-3 fw-normal">ログインIDとパスワードを入力してください</h1>
            <div class="form-floating">
            <input required type="number" class="form-control" name="id">
            <label for="floatingInput">ID</label>
            </div>
            <div class="form-floating">
            <input required type="password" class="form-control" name="pass">
            <label for="floatingPassword">パスワード</label>
            </div>
            <input class="common_button" type="submit" name="submit" value="ログイン" />
        </div>
        </form>
        <div class="form-check mb-3">
        </div>
        <form action="./SearchUser3" method="post">
			<input class="common_button" type="submit" name="submit" value="新規登録はこちら" />
		</form>
    </main>

    <script src="js/bootstrap.bundle.min.js" ></script>
</body>
</html>