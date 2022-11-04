<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>読書記録検索画面</title>
</head>


<body bgcolor="#e8f7f0">
	<jsp:include page="headerkai.jsp" />
	<div align="center">
		<h1></h1>

		<form action="./SearchRecord" method="post">
			  </br> 
					<td>評価
			 <input	required required type="radio" name="review" value="1"/><font size="3">1</font> 
			 <input	required required type="radio" name="review" value="2"/><font size="3">2</font> 
				 <input	required required type="radio" name="review" value="3"/><font size="3">3</font> 
			 <input	required required type="radio" name="review" value="4"/><font size="3">4</font> 
				 <input	required required type="radio" name="review" value="5"/><font size="3">5</font></br> 
					</td></br> 
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
</select></td></br>
<style>
	.common_button{
		/*追加*/color: #FFF;
		padding: 10px 20px;
		/*変更*/border: none;
		/*変更*/background: #ff6347;
	}
	</style>
				<input class="common_button" type="submit"value="検索" />
		</form>
		
	</div>
</body>
</html>