package com.test.customannotations;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import com.test.utilities.DateUtil;

public class ISODateInPastEditValidator implements ConstraintValidator<ISODateInPastEdit, String> {
	public void initialize(ISODateInPastEdit annotation) {
	}

	public boolean isValid(String birthDate,
        ConstraintValidatorContext context) {	
		LocalDate localDate = DateUtil.setYmdDate(birthDate);
		return(localDate != null);
	}
}