$("#chk1").prop("checked", function(){return true;});
$("#checkStatus").text("checked");


$("#chk1").click(function(){
	var a = $("#chk1").prop("checked");

	if(a === true){
		$("#checkStatus").text("checked");
	}
	else{
		$("#checkStatus").text("not checked");
	}
});

$("#rd2").prop("checked", function(){return true;});
$("#radioStatus").text("Radio button selected is rd2");

$("input[name=group1]").click(function(){
	var a = $(this).attr("id");
	$("#radioStatus").text("Radio button selected is " + a);
});

$("#dropdownStatus").text("Option selected is: Two");

$("#slct1").on("change", function(){
	var a = $("#slct1 option:selected").val();
	$("#dropdownStatus").text("Option selected is: " + a);
});

$("#reset").click(function(){
	$("#form1").each (function(){
		this.reset();
	});
});
