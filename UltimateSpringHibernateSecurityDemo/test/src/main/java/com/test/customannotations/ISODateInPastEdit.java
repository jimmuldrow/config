package com.test.customannotations;

import java.lang.annotation.*;
import javax.validation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ISODateInPastEditValidator.class)
public @interface ISODateInPastEdit  {
    String message() default "Date is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}