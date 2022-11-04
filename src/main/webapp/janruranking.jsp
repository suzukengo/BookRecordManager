<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*"%>
<!doctype html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ジャンル別検索</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" >

    <!-- CSSの設定ファイル -->
    <link rel="stylesheet" href="css/index.css">
</head>

    <body class="text-center">
        <div class="fixed-top">
            <jsp:include page="headerkai.jsp" />
        </div>
        <div class="container">
            <div class="row align-items-center">
                <h1>ジャンル別ランキング表示</h1>
                <img class="mb-4" src="icons/search.svg" alt="" width="72" height="57" loading="lazy">
                <form action="./SearchRanking" method="post">
                    <td>ジャンル<select name="janru">
                        <option value="実用書">実用書</option>
                        <option value="ビジネス">ビジネス</option>
                        <option value="芸術">芸術</option>
                        <option value="児童書">児童書</option>
                        <option value="医学">医学</option>
                        <option value="福祉">福祉</option>
                        <option value="理工書">理工書</option>
                        <option value="人文書">人文書</option>
                        <option value="語学">語学</option>
                        <option value="教育">教育</option>
                        <option value="情報">情報</option>
                        <option value="雑誌">雑誌</option>
                        <option value="コミック">コミック</option>
                        </select>
                    </td>
                    <input class="common_button" type="submit"value="検索" />
                </form>
            </div>
        </div>
    </body>


</html>