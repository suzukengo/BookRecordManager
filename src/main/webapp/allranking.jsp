<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*"%>
<!doctype html>
<html lang="ja">
    <head>
    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>全種類ランキング検索</title>
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
                <h1>全種類ランキング表示</h1>
                <img class="mb-4" src="icons/search.svg" alt="" width="72" height="57" loading="lazy">
                <form action="./SearchAllRecord" method="post">
                    <input class="common_button" type="submit"value="検索" />
                </form>
            </div>
        </div>
    </body>


</html>