<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="ja">
    <head>
    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login失敗</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" >
        <!-- CSSの設定ファイル -->
        <link rel="stylesheet" href="css/common1.css">
    </head>

    <body class="text-center">
        <div class="container">
            <div class="row align-items-center">
                <h1>ログインに失敗しました</h1>
                <p>入力されたユーザは存在しません...</p>
                <img class="mb-4" src="icons/x-lg.svg" alt="" width="72" height="57" loading="lazy">
                <form>
                <input class="common_button" type="button"onclick="location.href='./index.jsp'" value="戻る" />
                </form>
            </div>
        </div>
    </body>


</html>



