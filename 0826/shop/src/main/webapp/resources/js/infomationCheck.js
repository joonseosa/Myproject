
(function ($) {
    "use strict";


    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })
  
  
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    $("input[name='']")

})(jQuery);

$(function(){
	$("#id").focusout(function(){
		if($("#id").val() == ""){
			$("#idSpan").html("UserID");
		}else{
			$("#idSpan").html("");
		}
	});
	$("#pwd").focusout(function(){
		if($("#pwd").val() == ""){
			$("#pwdSpan").html("Password");
		}else{
			$("#pwdSpan").html("");
		}
	});
	$(".login100-form-btn").click(function(){
		var mem_id = $("#id").val();
		var mem_password = $("#pwd").val();
		$.ajax({
    		type : "POST",
    		url : "myAccountCheck",
    		data : {mem_id : mem_id, mem_password : mem_password},
    		success: function(data){
    			if(data =="성공"){
    				location.href="InformationUpdate";
    			}else{
    				$(".message").html("비밀번호가 다릅니다.");
    			}
    		}
    	});
		return false;
	});
});