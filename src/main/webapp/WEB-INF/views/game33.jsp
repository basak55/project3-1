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
		<div>
			<input class="quest" id="quest" type="text" readOnly value="${sent.sent}" name="quest" />
			<label for="quest">${sent.writer}</label>
		</div>
		<div>
			<input class="inputText" type="text" name="inputText" />
			<button type="button" id="check" onclick="getNewSent()">완료</button>
		</div>
</div>
<a href="#" id="endGame" class="btn" value="playTime">종료하기</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
function getNewSent() {
	var quest = $(".quest").val();
	var inputText = $(".inputText").val();
	console.log("quest: ", quest);
	console.log("inputText: ", inputText);
	$.ajax({
		type: "post",
		url: "/check",
		data:{
			"quest": quest,
			"inputText": inputText
		},
		success: function (data){
			console.log("결과:", data);
		},
		error(err){
			console.log("실패:", err);
		}
	});
}
</script>

</body>
</html>