<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="ja">
    <head>
    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>読書記録編集</title>
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
                <h1>読書記録登録・検索・編集</h1>
                <p><font size="6"><a href="./recordregist.jsp">読書記録登録</a></br></font></font></p>
                <img class="mb-4" src="icons/pencil-square.svg" alt="" width="72" height="57" loading="lazy">
                <p><font size="6"><a href="./searchregist.jsp">読書記録検索</a></br></font></font></p>
                <img class="mb-4" src="icons/search.svg" alt="" width="72" height="57" loading="lazy">
                <p><font size="6"><a href="./deletebefore.jsp">読書記録削除</a></br></font></font></p>
                <img class="mb-4" src="icons/trash3.svg" alt="" width="72" height="57" loading="lazy">
                <p><font size="6"><a href="./updatesearch.jsp">読書記録編集</a></br></font></font></p>
                <img class="mb-4" src="icons/file-earmark-font.svg" alt="" width="72" height="57" loading="lazy">
            </div>
        </div>
    </body>


</html>