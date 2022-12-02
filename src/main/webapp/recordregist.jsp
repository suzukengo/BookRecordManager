<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社会ドリル</title>
</head>
<body bgcolor="#e8f7f0">
	<jsp:include page="headerkai.jsp" />
	<div align="center">
		<h1>読書記録登録画面</h1>
		<form action="RegistRecord" method="post">
			<table style="with: 80%">
				<tr>
					<td>ID</td>
					<td><input required type="number" name="id" /></td>
				</tr>
			
				<tr>
					<td>題名</td>
					<td><input required type="text" name="title" /></td>
				</tr>
				<tr>
					<td>評価
			 <input	required required type="radio" name="review" value="1"/><font size="3">1</font> 
			 <input	required required type="radio" name="review" value="2"/><font size="3">2</font> 
				 <input	required required type="radio" name="review" value="3"/><font size="3">3</font> 
			 <input	required required type="radio" name="review" value="4"/><font size="3">4</font> 
				 <input	required required type="radio" name="review" value="5"/><font size="3">5</font></br> 
					</td>
				</tr>
				<tr>
					<td>感想</td>
					<td><input required type="text" name="thinking" /></td>
				</tr>
				<tr>
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
</select></td>
					
				</tr>
					<td>プライバシー
			 <input	required required type="radio" name="privacy" value="公開"/><font size="3">公開</font> 
			 <input	required required type="radio" name="privacy" value="非公開"/><font size="3">非公開</font> 
				</tr>
				<tr>
					<td>ISBN</td>
					<td><textarea required type="text" name="isbn" /></textarea></td>

				</tr>
				


			</table>
			注意:問題文は200文字以内です。 </br> 
			<style>
				.common_button{
					/*追加*/color: #FFF;
					padding: 10px 20px;
					/*変更*/border: none;
					/*変更*/background: #ff6347;
				}
				</style>
			<input class="common_button" type="submit" value="登録" />
		</form>

	</div>
</body>
</html>