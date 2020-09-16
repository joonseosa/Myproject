$(function() {
	$('#writeSubmit').click(function() {
		if ($('select[id=select]').val() == "0") {
			alert("문의 내용을 선택해주세요.");
			return false;
		}
		
//		if ($('div[name=content]').val() == null) {
//			alert("내용을 입력해주세요.");
//			return false;
//		}
	});
});