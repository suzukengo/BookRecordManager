<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="ja">
    <head>
    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>registcheck</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" >
        <!-- CSSの設定ファイル -->
        <link rel="stylesheet" href="css/common1.css">
    </head>

    <body class="text-center">
        <div class="fixed-top">
            <jsp:include page="header2.jsp" />
        </div>
        <div class="container">
            <div class="row align-items-center">
                <h1>本当に削除してもよろしいですか</h1>
                <img class="mb-4" src="icons/patch-question.svg" alt="" width="72" height="57" loading="lazy">
                <font size="6"><a href="./loginOK.jsp" style="color:#ff6347;">完了</a></br></font>
            </div>
        </div>
    </body>


</html>