package com.test.customannotations;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import com.test.utilities.DateUtils;
import com.test.enums.DateType;

public class ISODateInPastEditValidator implements ConstraintValidator<ISODateInPastEdit, String> {
	
	@Autowired
	DateUtils dateUtils;
	
	public void initialize(ISODateInPastEdit annotation) {
	}

	public boolean isValid(String birthDate, ConstraintValidatorContext context) {	
		LocalDate birthYMD = dateUtils.getLocalDateFromString(birthDate, DateType.YMD);
		LocalDate currentDate = LocalDate.now();		
		if((birthYMD == null) || (currentDate == null)){return false;}		
		return ((birthYMD.isBefore(currentDate)) ? true : false);
	}
}