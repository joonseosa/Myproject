// $(".plus").click(function(){
//   var num = $(".numBox").val();
//   var plusNum = Number(num) + 1;
//   if(plusNum >=${view.gdsStock}){
//	   $(".numBox").val(num);
//   }
//   if(plusNum >= ${view.gdsStock}) {
//    $(".numBox").val(num);
//   }else{
//    $(".numBox").val(plusNum);          
//   }
//  });
//  
//  $(".minus").click(function(){
//   var num = $(".numBox").val();
//   var minusNum = Number(num) - 1;
//   
//   if(minusNum <= 0) {
//    $(".numBox").val(num);
//   } else {
//    $(".numBox").val(minusNum);          
//   }
//  });
$(function(){
	$(".plus").click(function(){
		var num = Number($(".numBox").val());
			$(".numBox").val(num+1);			
	});
	$(".minus").click(function(){
		var num = Number($(".numBox").val());
		if(num <= 1){
			$(".numBox").val(1);			
		}else{
			$(".numBox").val(num-1);
		}
	});
});