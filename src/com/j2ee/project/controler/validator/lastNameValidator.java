package com.j2ee.project.controler.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import javax.faces.application.FacesMessage;

@FacesValidator(value = "check.lastName")
public class lastNameValidator implements Validator{

	private static final String LASTNAME_PATTERN = "^[a-zA-Z -]{2,25}";
	private Pattern pattern;
	private Matcher matcher;

	public lastNameValidator() {
		pattern = Pattern.compile(LASTNAME_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage(
					"Last name validation failed : Last Name Validation failed please follow the contraint "
							+ LASTNAME_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
			}
	}	
}
