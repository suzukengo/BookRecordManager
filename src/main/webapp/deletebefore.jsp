<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*"%>
<!doctype html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ID確認</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" >

    <!-- CSSの設定ファイル -->
    <link rel="stylesheet" href="css/index.css">
    
</head>

<body class="text-center">
    <main class="form-signin w-100 m-auto">
            <h1>あなたのIDは？</h1>
            <form action="./SearchDe" method="post">
            <div class="card-body">
            <h1 class="h3 mb-3 fw-normal">ID:</h1>
                <div class="form-floating">
                <input required type="number" class="form-control" name="id">
                <label for="floatingInput">ID</label>
                </div>
                <input class="common_button"  type="submit" value="検索" /></br>
            </div>
            </form>
    </main>
    <script src="js/bootstrap.bundle.min.js" ></script>
</body>
</html>