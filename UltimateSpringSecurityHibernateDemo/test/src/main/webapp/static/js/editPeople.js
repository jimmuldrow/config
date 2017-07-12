
$(document).ready(function(){
	var ct = "";
	
	if($("input[name='customerType']").is(':checked')) { 
		ct = $("input[name='customerType']").val();
	}
	
	$("input[name='customerType']").click(function(){
		ct = $(this).val();
	});	
	
	$("#submit").click(function(event){
		$("#errFirstName").text("");
		$("#errLastName").text("");
		$("#errCustomerType").text("");
		$("#errDate").text("");
		$("#errMoney").text("");
		var isFirstNameValid = false;
		var isLastNameValid = false;		
		var isCustomerTypeValid = false;
		var isDateValid = false;
		var isMoneyValid = false;	
		var fn = editValue($("#firstName").val());
		var ln = editValue($("#lastName").val());
		ct = editValue(ct);
		var bd = editValue($("#birthDate").val());
		var splitr = bd.split("-");
		var mn = editValue($("#money").val());

		if((fn.length >= 2) && (fn.length <= 25)){
			isFirstNameValid = true;
		}
		
		if((ln.length >= 2) && (fn.length <= 50)){
			isLastNameValid = true;
		}	
		
		if(ct.length > 1){
			isCustomerTypeValid = true;
		}
		
		if((/^(\d){1,}$/.test(mn)) || (/^(\d){1,}\.(\d){1,2}$/.test(mn))){
			isMoneyValid = true;
		}
		
		if(splitr.length == 3){
			isDateValid = validDate(splitr[0], splitr[1], splitr[2]);
		}	
		
		if(isDateValid){
			var today = new Date();
			var compareDate = new Date();
			compareDate.setFullYear(splitr[0]);
			compareDate.setMonth(splitr[1] - 1);
			compareDate.setDate(splitr[2]);			
			var result = compareDates(compareDate, today);
	
			if(result != "FIRST_DATE_OLDER"){
				isDateValid = false;
			}
		}

		if((!isFirstNameValid) || (!isLastNameValid) || (!isCustomerTypeValid) || (!isDateValid) || (!isMoneyValid)){
			event.preventDefault();
			
			if(!isFirstNameValid){
				$("#errFirstName").text("First name must be between 2 and 25 characters.")
			}
			
			if(!isLastNameValid){
				$("#errLastName").text("Last name must be between 2 and 50 characters.")
			}
			
			if(!isCustomerTypeValid){
				$("#errCustomerType").text("Customer type must have a selected value.")
			}
			
			if(!isDateValid){
				$("#errDate").text("Date must be a valid YYYY-MM-DD format date in the past.");
			}
			
			if(!isMoneyValid){
				$("#errMoney").text("Money is invalid");
			}
		}

		function validDate(year, month, day){
			var dayobj = new Date(year, month-1, day);	
			
			if ((dayobj.getMonth()+1!=month)||(dayobj.getDate()!=day)||(dayobj.getFullYear()!=year)){
				return false;
			}
			else{
				return true;
			}		
		}
		
		function compareDates(date1, date2){
			var dt1 = date1.getTime();
			var dt2 = date2.getTime();

			if((date1.getDate() === date2.getDate())
			&&
			(date1.getMonth() === date2.getMonth())
			&&
			(date1.getFullYear() === date2.getFullYear())){
				return "DATES_EQUAL";
			}

			if(dt1 < dt2){
				return "FIRST_DATE_OLDER";
			}

			if(dt1 > dt2){
				return "SECOND_DATE_OLDER";
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

