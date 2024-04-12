<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {max-width:1024px; margin:30px auto;}
.checkTypo input {width:80%;}
</style>
</head>
<body>
<div class="container">
	<h4>명언 필사하기</h4>
	<form action="/check" method="post" class="checkTypo">
		<div>
			<input class="quest" id="quest" type="text" readOnly value="${sent.sent}" name="quest" />
			<label for="quest">${sent.writer}</label>
		</div>
		<div>
			<input class="inputText" type="text" name="inputText" />
			<button type="submit" id="check">완료</button>
		</div>
		<!-- value 로그인값 받아오는걸로 수정하기 -->
		<input type="hidden" value="1" name="mno">
		<input type="hidden" value="${result}">
		<p id="checkResult"></p>
	</form>
	<div>
		<p></p>
	</div>
</div>
<button type="button" onClick='location.href="/"'>종료하기</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
	var queryString = window.location.search;
	var params = {};
	if (queryString) {
		queryString.slice(1).split('&').forEach(function(item) {
			var keyValue = item.split('=');
			params[keyValue[0]] = decodeURIComponent(keyValue[1]);
		});
	}
	var result = params['result'];
	// console.log(result);

	if (result === 'true') {
		$("#checkResult").css("color", "blue").text("잘하고있어요!ദ്ദി*ˊᗜˋ*)");
	} else if (result === 'false') {
		$("#checkResult").css("color", "red").text("조금 더 신중하게!(꒪⌓꒪);;");
	} else {
		$("#checkResult").css("color", "black").text("결과를 가져오지 못했어요...");
	}


</script>

</body>
</html>