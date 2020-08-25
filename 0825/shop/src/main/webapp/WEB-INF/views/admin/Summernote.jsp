<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/summernote/lang/summernote-ko-KR.js"></script>
<script src="/resources/summernote/summernote-lite.js"></script>
<link rel="stylesheet" href="/resources/summernote/summernote-lite.css">
<script type="text/javascript">
$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 300,					// 에디터 높이
		  minHeight: null,				// 최소 높이
		  maxHeight: null,				// 최대 높이
		  focus: false,					// 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",				// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
	});
});
</script>
</head>
<body>
	<form method="post">
		<textarea id="summernote" name="content"></textarea>
	</form>
</body>
</html>