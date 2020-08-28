$(function(){
	$("#allCheck").click(function(){
		if($("#allCheck").is(':checked')){
			$("input[name=check]").prop("checked", true);
		}else{
			$("input[name=check]").prop("checked", false);
		}
	});
	$("#selectDelete").click(function(){
		var arrayParam = new Array();
		if(confirm("삭제하시겠습니까?")){
			$("input:checkbox[name=check]:checked").each(function(){
				arrayParam.push($(this).val());
			});
			location.href="myInterestedDelete?selectDelete="+arrayParam;
		}
	});
});
function numberWithCommas(x) {
	document.write(x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
}
function deleteBtn(no){
	if(confirm("삭제하시겠습니까?")){
		location.href="myInterestedDelete?item_no="+no;
	}else{
		alert("아니오")
	}
}
