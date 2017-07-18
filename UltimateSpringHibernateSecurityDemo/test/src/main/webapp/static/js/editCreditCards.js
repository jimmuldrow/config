$(document).ready(function(){
	var type = $("#ccType option:selected").val();

	$("#ccType").change(function(){
		type = $("#ccType option:selected").val();
	});
	
	$("#submit").click(function(event){
		$("#errCCType").text("");
		$("#errCCNumber").text("");
		var isCCTypeValid = false;
		var isCCNumberValid = false;
		type = editValue(type);
		var number = editValue($("#ccNumber").val());
		
		if(type.length > 1){
			isCCTypeValid = true;
		}

		if(/^(\d){10,25}$/.test(number)){
			isCCNumberValid = true;
		}

		if((!isCCTypeValid) || (!isCCNumberValid)){
			event.preventDefault();

			if(!isCCTypeValid){
				$("#errCCType").text("A valid credit card type must be selected.")
			}
			
			if(!isCCNumberValid){
				$("#errCCNumber").text("Credit card number must be 10 to 25 digits.");
			}
		}
		
		function editValue(v){
			if((v === null) || (v === undefined)){
				return "";
			}
			else{
				return $.trim(v);
			}
		}		
	});
});