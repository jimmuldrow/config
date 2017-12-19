$(document).ready(function(){
	$("#menuContainer .details").hide();

	$("#menuContainer .header").mouseenter(function(){
		$("#menuContainer .header").css("color", "#68228b");
		$(this).css("color", "orange");
		$("#menuContainer .details").hide();
		var a = $(this).closest("ul").next();
		$(a).slideDown("slow");
	});

	$("#menuContainer .details a").mouseenter(function(){
		$(this).css("color", "#8888ff");
	});

	$("#menuContainer .details a").mouseleave(function(){
		$(this).css("color", "#2222cc");
	});

	$("#menuContainer").mouseleave(function(){
		$("#menuContainer .details").slideUp("slow");
		$("#menuContainer .header").css("color", "#68228b");
	});
});