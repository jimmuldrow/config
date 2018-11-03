package com.test.customannotations;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import com.test.utilities.DateUtils;
import com.test.enums.DateType;

public class ISODateInPastEditValidator implements ConstraintValidator<ISODateInPastEdit, String> {
	
	public void initialize(ISODateInPastEdit annotation) {
	}

	public boolean isValid(String birthDate, ConstraintValidatorContext context) {
		DateUtils dateUtils = new DateUtils();

		if (birthDate != null) {
			LocalDate birthYMD = dateUtils.getLocalDateFromString(birthDate, DateType.YMD);			
			if(birthYMD == null){return false;}
			LocalDate currentDate = LocalDate.now();
			return ((birthYMD.isBefore(currentDate)) ? true : false);
		}
		else{
			return false;
		}
	}
}