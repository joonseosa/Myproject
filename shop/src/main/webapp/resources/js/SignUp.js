$(function() {
	var idForm = false;
	var passwdForm = false;
	var idButton = false;
	var passwdButton = false;
	$('#signUpSubmit').click(function() {
		if ($('.value_check').val() == null || $('.value_check').val() == "") {
			alert('*  는 필수 입력란 입니다.');
			return false;
		}

		if (!idButton) {
			alert('ID 체크를 해주세요.');
			return false;
		}

		if (!idForm) {
			alert('입력하신 ID를 사용할 수 없습니다.');
			return false;
		}

		$.ajax({
			async : true,
			type : 'post',
			url : "IDDuplicateCheck",
			data : {
				"mem_id" : $("#id").val()
			},
			dataType : "json",
			success : function(data) {
				if (data > 0) {
					alert('이미 사용 중인 ID입니다.');
					idForm = false;
					return false;
				} else {
					idForm = true;
				}
			}
		});

		if (!passwdButton) {
			alert('비밀번호 체크를 해주세요.');
			return false;
		}

		if (!passwdForm) {
			alert('입력하신 비밀번호를 사용할 수 없습니다.');
			return false;
		}

		if (!$('input[class=Terms_of_Use]').prop('checked')) {
			alert('이용 약관 동의를 확인해주세요');
			return false;
		}

	});

	$("#passwdCheck")
			.click(
					function() {
						passwdButton = true;
						var passwd = $('#passwd1').val();
						var check = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,20}$/;

						if (!check.test(passwd)) {
							alert("비밀번호 형식에 맞지 않습니다. \n8자리 ~ 20자리 이내이며 \n하나의 문자 및 하나의 숫자를 입력해주세요. \n특수문자 입력 불가");
							passwdForm = false;
							return false;
						}

						if ($('#passwd1').val() != $('#passwd2').val()) {
							alert("비밀번호 확인이 틀립니다.");
							passwdForm = false;
						} else {
							alert("사용 가능한 비밀번호 입니다.");
							passwdForm = true;
						}
						return false;
					});

	$("#IDDuplicateCheck").click(function() {
		idButton = true;
		var id = $('#id').val();
		var pattern1 = /(^[a-zA-Z])/;
		var pattern2 = /([^a-zA-Z0-9-_])/;

		if (!pattern1.test(id)) {
			alert("아이디의 첫글자는 영문이어야 합니다.\n아이디는 영문, 숫자, -, _ 만 사용할 수 있습니다.");
			idForm = false;
			return false;
		} else if (pattern2.test(id)) {
			alert("아이디는 영문, 숫자, -, _ 만 사용할 수 있습니다.");
			idForm = false;
			return false;
		}

		$.ajax({
			async : true,
			type : 'post',
			url : "IDDuplicateCheck",
			data : {
				"mem_id" : $("#id").val()
			},
			dataType : "json",
			success : function(data) {
				if (data > 0) {
					alert('이미 사용 중인 ID입니다.');
					idForm = false;
				} else {
					alert('사용 가능한 ID입니다.');
					idForm = true;
				}
			}
		});
		return false;
	});

	$("#id").keyup(function() {
		idButton = false;
	});

	$('input[class=birth]').keyup(function() {
		var inputText = $(this).val();
		var number = $(this).val().replace(/[^0-9]/g, '');
		$(this).val(number);
	});

	$('input[class=checkbox_all]').click(function() {
		var chk = $('input[class=checkbox_all]').prop('checked');
		$('input[type=checkbox]').prop('checked', chk);
	});
});

function checkbox(str){
	if($('div[id='+str+']').css('display')=='block'){
		$('div[id='+str+']').css('display','none');
	}else {
		$('div[id='+str+']').css('display','block');
	}
}