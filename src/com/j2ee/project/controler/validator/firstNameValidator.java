package com.j2ee.project.controler.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import javax.faces.application.FacesMessage;

@FacesValidator(value = "check.firstName")
public class firstNameValidator implements Validator{

	private static final String FIRSTNAME_PATTERN = "^[a-zA-Z -]{2,25}";
	private Pattern pattern;
	private Matcher matcher;

	public firstNameValidator() {
		pattern = Pattern.compile(FIRSTNAME_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage(
					"First name validation failed : First Name Validation failed please follow the contraint "
							+ FIRSTNAME_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
			}
	}	
}
