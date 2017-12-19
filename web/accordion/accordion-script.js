
$(document).ready(function(){
	$(".accordionContent:gt(0)").hide();
	var hold = "accordionButton1";
	$("#accordionButton1").addClass("acc-orange");

	$(".accordionButton").mouseenter(function(){		
		if($(this).hasClass("acc-orange") === false){
			$(this).removeClass("acc-notSelected");
			$(this).addClass("acc-selected");
		}
	});

	$(".accordionButton").mouseleave(function(){
		if($(this).hasClass("acc-orange") === false){
			$(this).removeClass("acc-selected");
			$(this).addClass("acc-notSelected");
		}
	});	

	$(".accordionButton").click(function(){
		$(".accordionButton").addClass("acc-notSelected");
		$(this).removeClass("acc-notSelected");
		$(this).removeClass("acc-selected");
		$(this).addClass("acc-orange");
		var btn = $(this).attr("id");
	
		if(btn !== hold){
			$("#" + hold).removeClass("acc-orange");
			$(".accordionContent").slideUp();
			$(this).next().slideDown("slow");
			hold = btn;
		}
	});
});