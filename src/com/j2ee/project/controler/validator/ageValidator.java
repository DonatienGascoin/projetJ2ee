package com.j2ee.project.controler.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import javax.faces.application.FacesMessage;

@FacesValidator(value = "check.age")
public class ageValidator implements Validator{

	private static final String AGE_PATTERN = "^[1-9][0-9]";
	private Pattern pattern;
	private Matcher matcher;

	public ageValidator() {
		pattern = Pattern.compile(AGE_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage(
					"Age validation failed : Age between 1 and 99 years old. ");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
			}
	}	
}
