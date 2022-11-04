<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="ja">
    <head>
    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>トップメニュー</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" >
        <!-- CSSの設定ファイル -->
        <link rel="stylesheet" href="css/common1.css">
    </head>

    <body class="text-center">
        <div class="fixed-top">
            <jsp:include page="headerkai.jsp"/>
        </div>
        <div class="container">
            <div class="row align-items-center">
                <h1>メニュー画面</h1>
                <p><font size="6"><a href="./janruranking.jsp">ジャンル別ランキング表示</a></br></font></font></p>
                <p><font size="6"><a href="./allranking.jsp">全種類ランキング表示</a></br></font></font></p>
                <img class="mb-4" src="icons/list-ol.svg" alt="" width="72" height="57" loading="lazy">
                <p><font size="6"><a href="./crud.jsp">読書記録登録・検索・編集</a></br></font></font></p>
                <img class="mb-4" src="icons/book.svg" alt="" width="72" height="57" loading="lazy">
                <p><font size="6"><a href="./userupdate.jsp">ユーザ基本情報変更</a></br></font></font></p>
                <img class="mb-4" src="icons/person-circle.svg" alt="" width="72" height="57" loading="lazy">
            </div>
        </div>
    </body>


</html>