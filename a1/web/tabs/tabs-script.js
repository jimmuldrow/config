$(document).ready(function(){
	$(".tab:gt(0)").removeClass("active");
	$(".tab:gt(0)").addClass("inactive");
	$(".tab:eq(0)").removeClass("inactive");
	$(".tab:eq(0)").addClass("active");	
	$(".tabContent:gt(0)").hide();
	$(".tabContent:first").show();

	$(".tab").click(function(e){
		$(".tabContent").hide();
		$(".tab").removeClass("active");
		$(".tab").addClass("inactive");	
		$(this).removeClass("inactive");
		$(this).addClass("active");	
		var a = $(this).find("input[type=hidden]");
		var b = $(a).val();
		var c = $("#" + b);
		$(c).show();
		e.preventDefault();
	});
});