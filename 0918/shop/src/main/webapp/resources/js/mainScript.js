
$(function(){
//	var regFormObj = $("form[name='regForm']");
//	var idck;
//   $('#inputCheck').click(function(){
//	   if(idck==1 ) {
//		   alert("아이디 중복");
//		   return false;
//	   }
//		if(fn_valiChk()){
//			return false;
//		}
//	 regFormObj.submit();
//	});
   
$('#inputCheck').click(function(){
		if($('.null_check').val()==null||$('.null_check').val()==""){
			alert('* 내용을 입력해주세요');
			return false;
		}
});
   
   
   
   
   
   
   
   
   //#에 아이디 입력 , 'login' 이라는 id를 갖고있는 버튼을 눌렀을때 ~
   //  id 와 passwd 2가지의 값을 가져가야함 
   // admincontroller에  logincheck 생성 (url에 해당됨)   , @responsebody를 사용해야 data만 가져오고 이동하지않음
   // data:  string pw, string id  에 선언된값 입력 
   /* @ResponseBody
		@PostMapping("loginCheck")
		public String loginCheck(String pw, String id) {
		System.out.println("pw : "+pw);
		System.out.println("id : "+id);
		return "asd";
	} */
   
   
   
   
   // #은 아이디 , . 은 클래스 
   //val 은   .val()은 값을 가져온다 
   //url 은  controller에 mapping 값 
   
   $("#login").click(function(){
	      var id = $("#id").val();
	      var pw = $("#password").val();
	      $.ajax({
	         async : true,
	         type : 'post',
	         url : "loginCheck",
	         data : {
	            id : id, pw : pw
	         },
	         success : function(data) {
	            if(data == ""){
	            	alert("로그인실패");
	            }else{
	            	location.href="/";
	            }
	         }
	      });
	      
	   });
   
   $('#passwd').keyup(function(){
     $('font[id=check]').text('');
     if($('#passwd').val()!=$('#passwd2').val()){
         $('font[id=check]').text('');
        }else{
         $('font[id=check]').text('');
         $('font[id=check]').text("비밀번호 같음");
        }
    });
    $('#passwd2').keyup(function(){
	     if($('#passwd').val()!=$('#passwd2').val()){
	      $('font[id=check]').text('');
	      $('font[id=check]').text("비밀번호 다름");
	     }else{
	      $('font[id=check]').text('');
	      $('font[id=check]').attr('color','blue');
	      $('font[id=check]').text("비밀번호 같음");
	     }
     });
    
    //id check
     $("#idchk").on("propertychange change input paste", function() {
    	 $.ajax({
          	  async: true,
              type : 'post',
              url : "idcheck",
              data: { "mem_id" : $("#idchk").val()},
              dataType : "json",
              success : function(data) {
            	  if (data > 0) {
                    	$('font[id=warning]').text('');
                        $('font[id=warning]').attr('color','red');
                        $('font[id=warning]').text('이미 존재하는 아이디 입니다.');
                        $("#idchk").focus();
                        idck=1;//
                    } else {
                    	$('font[id=warning]').text('');
                        $('font[id=warning]').attr('color','blue');
                        $('font[id=warning]').text('사용가능한 아이디입니다.');
                        $("#idchk").focus();
                        idck = 0; // idck 1이 아니면 submit못하게 하려고 
                    }
              }
         });
    });
     
     $("#login").click( function(){
    	 var loginObj = $("form[name='loginForm']");
		   if($("input[name='mem_id']").val() == ""){
		       alert("아이디를 입력해 주세요.");
		       $("input[name='mem_id']").focus();
					return false;
		       }
		   if($("input[name='m_passwd']").val() == ""){
		       alert("패스워드를 입력해 주세요.");
		       $("input[name='m_passwd']").focus();
					return false;
		       }
			loginObj.submit();	
     });
     
     
     $("#deleteChk").click( function(){
    	 pwCheck('D');
     });
  });


	function fn_valiChk(){
			var regForm = $("form[name='regForm'] .chk").length;
			for(var i = 0; i<regForm; i++){
				if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
					alert($(".chk").eq(i).attr("title")+"은/는 필수입력입니다.");
					$(".chk").eq(i).focus();
					return true;
				}
			}
			var str=document.regForm.m_email.value;	   
			var atPos = str.indexOf('@');
			var atLastPos = str.lastIndexOf('@');
			var dotPos = str.indexOf('.'); 
			var spacePos = str.indexOf(' ');
			var commaPos = str.indexOf(',');
			var eMailSize = str.length;
			if (atPos > 1 && atPos == atLastPos && 
			   dotPos > 3 && spacePos == -1 && commaPos == -1 
			   && atPos + 1 < dotPos && dotPos + 1 < eMailSize);
			else {
				  alert('E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!');
				  document.regForm.m_email.focus();
				  return ;
			}		
		}
	
	function pwCheck(s){
		window.name = "update";
		if(s=='U'){
			document.postF.action='memberUpdate';  
		}else if(s=='D'){
			document.postF.action='memberDelete' 
		}
		openWin=window.open("/idCheck", "idCheck",
		"width=500, height=200, toolbar=no, location=no, menubar=no, resizable = no, scrollbars = no");
				
	}
	
	 function setParentText(object){
		   opener.document.postForm.cpass.value
		       = document.getElementById("pwCheck").value;
		   window.close();
		   compare();
	 }
		 
	 function compare(){
		   var pw = opener.document.postForm.passwd.value;
		   var cpw = opener.document.postForm.cpass.value;
		  if(pw==cpw){
			  var f = opener.document.postF;
			  f.submit();
			  idCheck.window.close();
		    }else{
		      alert("비밀번호 오류");
		      idCheck.window.close();
		    }
		 }
	 
	 
	 function shopMgrDetail(no){
		 document.detail.no.value=no;
		 document.detail.submit();
	 }
	 
	function Update(mem_id){
		document.update.mem_id.value=mem_id;
		document.update.submit();
	}
	
	 
	 
	function shopMgrDetail(no) {
		document.detail.no.value=no;
		document.detail.submit();
	}
	
	function productUpdate(no, flag) {
		if(flag=='U'){
      	 document.update.no.value=no;
      	 document.update.action = "/productUpdate";
		 document.update.submit();
 		}else if(flag=='D'){
			 document.update.no.value=no;
	      	 document.update.action = "/productMgrProcDelete?flag=delete";
			 document.update.submit();	
		}
	}
	
	
	function productUpdate(no, flag) {
		if(flag=='U'){
      	 document.update.no.value=no;
      	 document.update.action = "/productUpdate";
		 document.update.submit();
 		}else if(flag=='D'){
			 document.update.no.value=no;
	      	 document.update.action = "/productMgrProcDelete?flag=delete";
			 document.update.submit();	
		}
	}
	
	
	function updateOrderCancel(flag) {
		if(flag=='U'){
		$('form[name=orderCancel]').attr('action','/OrderCancelUpdate');
		$('form[name=orderCancel]').submit();
 		}else if(flag=='D'){
 			$('form[name=orderCancel]').attr('action','/OrderCancelDelete');
 			$('form[name=orderCancel]').submit();
		}
	}
	
	
	
	
	
	
	
	function orderUpdate(form, flag){
		form.flag.value=flag;
		form.submit();
	}
	
	function cartUpdate(form){
		form.flag.value="update"
		form.submit();
	}
	
	function cartDelete(form) {
		form.flag.value="del";
		form.submit();
	}
	
	
/*	 

	function memberReg(){
		document.location="Register.jsp";
	}
	
	function inputCheck(){
		if(document.regForm.mem_id.value==""){
			alert("아이디를 입력해 주세요.");
			document.regForm.mem_id.focus();
			return;
		}
		if(document.regForm.mem_passwd.value==""){
			alert("비밀번호를 입력해 주세요.");
			document.regForm.mem_passwd.focus();
			return;
		}
		if(document.regForm.mem_repasswd.value==""){
			alert("비밀번호를 확인해 주세요");
			document.regForm.mem_repasswd.focus();
			return;
		}
		if(document.regForm.mem_name.value==""){
			alert("이름을 입력해 주세요.");
			document.regForm.mem_name.focus();
			return;
		}
		if(document.regForm.mem_num1.value==""){
			alert("주민번호을 입력해 주세요.");
			document.regForm.mem_num1.focus();
			return;
		}
		if(document.regForm.mem_num2.value==""){
			alert("주민번호을 입력해 주세요.");
			document.regForm.mem_num2.focus();
			return;
		}
		if(document.regForm.mem_email.value==""){
			alert("이메일을 입력해 주세요.");
			document.regForm.mem_email.focus();
			return;
		}
		if(document.regForm.mem_phone.value==""){
			alert("연락처를 입력해 주세요.");
			document.regForm.mem_phone.focus();
			return;
		}
		if(document.regForm.mem_job.value=="0"){
			alert("직업을 선택해 주세요.");
			document.regForm.mem_job.focus();
			return;
		}
		
		if(document.regForm.mem_passwd.value != document.regForm.mem_repasswd.value){
			alert("비밀번호가 일치하지 않습니다.");
			document.regForm.mem_repasswd.focus();
			return;
		}

		var jumin1=regForm.mem_num1.value;
		var jumin2=regForm.mem_num2.value;
		var jumin=jumin1+jumin2;
		var index="234567892345";
		var total=0;
		for(var i=0;i<12;i++)
			total+=parseInt(jumin.charAt(i)*index.charAt(i));

		total=11-total%11;
		if(total==10)
			total=0;
		else if(total==11)
			total=1;


		document.regForm.submit();
	}
	
	function idCheck(id){
		if(id == ""){
			alert("아이디를 입력해 주세요.");
			document.regForm.mem_id.focus();
		}else{
			url="IdCheck.jsp?mem_id=" + id;
			window.open(url,"post","width=300,height=150");
		}
	}
	*/
	/*function zipCheck(){
			url="zipCheck?check=y";
			window.open(url,"post","toolbar=no ,width=500 ,height=300 ,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
*/
	
